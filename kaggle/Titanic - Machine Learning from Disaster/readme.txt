Titanic Survival Rate Prediction using Fastai

This Jupyter notebook demonstrates the process of predicting the survival rate of Titanic passengers using Fastai library and Kaggle dataset. 
The goal is to predict whether a passenger survived or not based on various features like age, sex, class, and more. 
The notebook includes importing necessary libraries, loading data, pre-processing, feature selection, data visualization, and model training.

Fastai version
The code uses Fastai version 2.5.3.

Data Loading
The code imports the necessary libraries and loads the Titanic training and test datasets.

code
import pandas as pd
import numpy as np
from fastai import *
from fastai.tabular.all import *
test = pd.read_csv('/kaggle/input/titanic/test.csv')
train = pd.read_csv('../input/titanic/train.csv')

Data Preprocessing
The code examines the percentage of missing values in the dataset and selects required features by filtering out columns with high null values, duplicate features, and high cardinality features.
The filtered dataset is then split into categorical and continuous features. The percentage of null values is calculated for the filtered dataset.
The TabularPandas object is created with the processed dataset, specifying the categorical and continuous features, target variable, and data splitting strategy (20% validation set).

model architecture :
Importing the required libraries including pandas, numpy, fastai, seaborn, and matplotlib
Loading the dataset of the Titanic from CSV files and displaying the null value distribution and unique values for each column in the dataset
Filtering the dataset based on required columns and splitting the data into training and validation sets
Handling categorical and continuous variables differently
Label-encoding the categorical variables and standardizing the continuous variables using standardization
Creating TabDataloaders to load the data for the model
Building the neural network with two layers, i.e., 30 and 10 neurons
Training the model with a maximum learning rate of 5e-2, using fit_one_cycle with 10 epochs.
