This REAME describes the various machine learning implemented for 2022S2 COMP90049 Project 3.

There are four different scikit-learn modules imported to implement machine learning algorithm and evalution metrics.

- KNeighborsClassifier for KNN
- MLPClassifier for MLP
- DummyClassifier for Zero-R
- metrics for evaluating

KNeighborsClassifier is implemented with parameters {n_neighbors=3, weights='distance', n_jobs=-1}.
"n_neighbors" determines how many nearest neighbors used to predict labels.
"weights" determines method to use as weights.
"n_jobs" determines how many cores to use for calculating

MLPClassifier is implemented with parameters{hidden_layer_sizes=(5,2),activation='logistic', max_iter=500}.
"hidden_layer_sizes" determines how many hidden layers and how many perceptrons in each layer.
"activation" determines which function to use for classifying outputs.
"max_iter" determines the maximum number of iteration for optimizor.

DummyClassifier is implemented with parameters{strategy= 'most_frequent'}.
"strategy" determines method used to predict.

"metrics" is using for showing classification_report and roc_auc_score.

There are two files used for "trainining" and "developing" of embedding representation.

- train_embedding.csv
- dev_embedding.csv

The file path in coding is based on the my own working directory. Please adjust before running.

For purpose of research, KNeighborsClassifier and MLPClassifier are implement twice. 
One is for training by entire dataset. The other one is for training by seperate subset of different identities.
Identities are chosen as ["Christian", "Muslim", "Female", "Homosexual gay or lesbian","Male"].

All coding blocks are described by at least one heading.






