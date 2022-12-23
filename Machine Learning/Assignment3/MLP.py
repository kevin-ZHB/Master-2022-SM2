from sklearn.neural_network import MLPClassifier
from sklearn import metrics
from sklearn.dummy import DummyClassifier
import pandas as pd
import numpy as np

train_file = "dataset/dataset/train_embedding.csv"
test_file = "dataset/dataset/dev_embedding.csv"

unlabeled_file = "dataset/dataset/test_embedding.csv"

identity  = ["Christian", "Muslim", "Female", "Homosexual gay or lesbian","Male"]

train_data = pd.read_csv(train_file)


test_data = pd.read_csv(test_file)
unlabeled_data = pd.read_csv(unlabeled_file)



train_label = train_data["Toxicity"]
train_feature = train_data.iloc[:,26:]


test_label = test_data["Toxicity"]
test_feature = test_data.iloc[:,26:]

unlabeled_feature = unlabeled_data.iloc[:,26:]

clf1 = MLPClassifier(hidden_layer_sizes=(5,2),activation='logistic', max_iter=500, warm_start=True)

clf1.fit(train_feature, train_label)
pro = clf1.predict_proba(test_feature)
predic = clf1.predict(unlabeled_feature).tolist()
ID = unlabeled_data["ID"]

predic = pd.DataFrame(predic)


result = pd.concat([ID, predic], names=["ID","Toxicity"], ignore_index=True, axis=1).set_axis(["ID", "Toxicity"], axis=1, inplace=True).to_csv("result.csv",index = False)

