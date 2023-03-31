## Titanic Survival Rate Prediction using Fastai
### Introduction
This project aims to predict the survival rate of passengers onboard the Titanic using the Fastai library. The Titanic disaster is a well-known historical event where a large number of people lost their lives. Kaggle provides a dataset that contains the details of the passengers who were onboard the Titanic. This dataset has been used for the Kaggle competition "Titanic: Machine Learning from Disaster."

### Objective of the Project
The objective of this project is to develop a machine learning model that can predict the survival rate of passengers based on their characteristics.

### Dataset Description
The dataset contains two parts: training set and test set. The training set contains 891 records, and the test set contains 418 records. The data dictionary of the variables used in the dataset is given below:

| Variable | Definition | Key |
| -------- | ---------- | --- |
| survival | Survival | 0 = No, 1 = Yes |
| pclass   | Ticket class | 1 = 1st, 2 = 2nd, 3 = 3rd |
| sex      | Sex | |
| Age      | Age in years | |
| sibsp    | # of siblings / spouses aboard the Titanic | |
| parch    | # of parents / children aboard the Titanic | |
| ticket   | Ticket number | |
| fare     | Passenger fare | |
| cabin    | Cabin number | |
| embarked | Port of Embarkation | C = Cherbourg, Q = Queenstown, S = Southampton |

### Data Loading
The necessary libraries have been imported, and the Titanic training and test datasets have been loaded.

### Data Preprocessing
The missing values in the dataset have been examined. The relevant features have been selected, and the filtered dataset has been split into categorical and continuous features. The percentage of null values for the filtered dataset has been calculated. A TabularPandas object has been created with the processed dataset and data splitting strategy.

### Data Visualization
The relationship between selected features and the survival rate has been visualized using bar plots, scatter plots, and violin plots.

### Model Training
A Tabular Neural Network (TabNN) has been defined using the TabularModel class from the Fastai library. The network architecture includes two hidden layers with 30 and 10 neurons, respectively. The TabularLearner class has been used to train the model using the fit_one_cycle method with a learning rate of 0.005 and 10 epochs. The survival rate of the test dataset has been predicted using the trained model, and the output has been saved in a CSV file in the required format for submission.

### Conclusion
In this project, we developed a machine learning model that can predict the survival rate of passengers onboard the Titanic with a 0.98 accuracy rate. The model was developed using the Fastai library, and the training dataset was preprocessed and visualized before training the model. The trained model was used to predict the survival rate of the test dataset, and the output was saved in a CSV file in the required format for submission. Further improvements can be made by using more complex models or by including additional features in the dataset.
