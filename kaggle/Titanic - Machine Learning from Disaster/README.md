# Titanic Survival Rate Prediction using Fastai

## Introduction
Background information about the Titanic disaster and the Kaggle competition

## Objective of the project

## Dataset Description
Explanation of the training set and test set
Data dictionary of the variables in the dataset

## Data Loading
Code for importing necessary libraries and loading the Titanic training and test datasets

## Data Preprocessing
Examination of missing values in the dataset
Selection of relevant features
Splitting of the filtered dataset into categorical and continuous features
Calculation of percentage of null values for the filtered dataset
Creation of TabularPandas object with processed dataset and data splitting strategy

## Data Visualization
Visualization of the relationship between selected features and the survival rate using bar plots, scatter plots, and violin plots

## Model Training
Definition of Tabular Neural Network (TabNN) using the TabularModel class from the fastai library
Network architecture including two hidden layers with 100 and 50 neurons, respectively
Use of the TabularLearner class to train the model using the fit_one_cycle method with a learning rate of 0.1 and 10 epochs
Prediction of the survival rate of the test dataset using the trained model
Saving the output in a CSV file in the required format for submission

## Conclusion
Summary of the project and its findings
Implications of the results and potential future work
