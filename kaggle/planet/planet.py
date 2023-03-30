%reload_ext autoreload
%autoreload 2
%matplotlib inline

from fastai.vision import *

path = Path('/kaggle/input/')

# Read in the csv file containing the image labels
df = pd.read_csv(path/'train_v2.csv')
df.head()

# Define the data augmentation transforms
tfms = get_transforms(flip_vert=True, max_lighting=0.1, max_zoom=1.05, max_warp=0.)

# Set the random seed for reproducibility
np.random.seed(42)

# Create the data bunch for training
src = (ImageItemList.from_csv(path, 'train_v2.csv', folder='train-jpg', suffix='.jpg')
       .random_split_by_pct(0.2)
       .label_from_df(sep=' '))

data = (src.transform(tfms, size=128)
        .databunch(num_workers=0)
        .normalize(imagenet_stats))

data.show_batch(rows=3, figsize=(12, 9))

# Define the architecture of the neural network
arch = models.resnet50

# Define metrics to evaluate the model's performance
acc_02 = partial(accuracy_thresh, thresh=0.2)
f_score = partial(fbeta, thresh=0.2)

# Create the convolutional neural network
learn = create_cnn(data, arch, metrics=[acc_02, f_score], model_dir='/tmp/models')

# Find the optimal learning rate for the first round of training
learn.lr_find()
learn.recorder.plot()

# Train the model using the one-cycle policy for 5 epochs
lr = 0.01
learn.fit_one_cycle(5, slice(lr))
learn.save('stage-1-rn50')

# Unfreeze the model and find the optimal learning rate for the second round of training
learn.unfreeze()
learn.lr_find()
learn.recorder.plot()

# Train the model using the one-cycle policy for another 5 epochs
learn.fit_one_cycle(5, slice(1e-5, lr/5))
learn.save('stage-2-rn50')

# Increase the image size and train the model again
data = (src.transform(tfms, size=256)
        .databunch(num_workers=0)
        .normalize(imagenet_stats))

learn.data = data
data.train_ds[0][0].shape
learn.freeze()

learn.lr_find()
learn.recorder.plot()
lr=1e-2/2
learn.fit_one_cycle(5, slice(lr))
learn.save('stage-1-256-rn50')

learn.unfreeze()
learn.fit_one_cycle(5, slice(1e-5, lr/5))
learn.recorder.plot_losses()
learn.save('stage-2-256-rn50')

# Export the trained model
learn.export()

# Load the test data and make predictions
test = ImageItemList.from_folder(path/'test-jpg').add(ImageItemList.from_folder(path/'test-jpg-additional'))
len(test)
learn = load_learner(path, test=test)
preds, _ = learn.get_preds(ds_type=DatasetType.Test)

# Set a threshold for the predictions and generate the final labels
thresh = 0.2
labelled_preds = [' '.join([learn.data.classes[i] for i,p in enumerate(pred) if p > thresh]) for pred in preds]
labelled_preds[:5]

# Generate the submission file
fnames = [f.name[:-4] for f in learn.data.test_ds.items]
df = pd.DataFrame({'image_name': fnames, 'tags': labelled_preds}, columns=['image_name', 'tags'])
df.to_csv(path/'submission.csv', index=False)
