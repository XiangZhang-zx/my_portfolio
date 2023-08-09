## Toxic Comment Classification Challenge

### Overview:
In this project, I tackled the challenge of identifying and classifying toxic online comments. The goal was to predict the probability of various types of toxicity for each comment, such as toxic, severe toxic, obscene, threat, insult, and identity hate.

### Data Source:
The dataset was sourced from the [Kaggle Toxic Comment Classification Challenge](https://www.kaggle.com/c/jigsaw-toxic-comment-classification-challenge).

### Key Features:

1. **Data Preprocessing:**
    - Utilized the `TfidfVectorizer` to convert the raw comments into a matrix of TF-IDF features.
    - Implemented custom tokenization to handle punctuations and special characters effectively.

2. **Modeling:**
    - Trained multiple models including Logistic Regression, Naive Bayes, and Support Vector Machine (SVM) for each label.
    - Evaluated model performance using the Receiver Operating Characteristic (ROC) curve and Area Under the Curve (AUC) metrics.
    - **Model Selection:** Chose the `LinearSVC` model as it demonstrated the highest AUC among the models tested, indicating its superior performance in distinguishing between the classes.
    - Visualized the ROC curves for each model and label to compare their performances.

3. **Prediction:**
    - Used the `CalibratedClassifierCV` wrapper around the `LinearSVC` to get prediction probabilities for the test set.
    - Generated a submission file with predicted probabilities for each label, suitable for Kaggle submission.

### Results:
Achieved a high score of 0.97 on Kaggle, demonstrating the effectiveness of the models in classifying toxic comments.

### Technologies Used:
- **Programming Language:** Python
- **Libraries:** pandas, scikit-learn, matplotlib
