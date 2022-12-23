import pandas as pd
from sklearn.semi_supervised import LabelPropagation



unlabeled_data = pd.read_csv("dataset/dataset/unlabeled_embedding.csv")
train_data = pd.read_csv("dataset/dataset/train_embedding.csv")

unlabeled_feature = unlabeled_data.iloc[:,1:]
unlabeled_feature.columns = range(unlabeled_feature.shape[1])
unlabeled_data["Toxicity"] = -1
unlabeled_label = unlabeled_data["Toxicity"]

train_label = train_data["Toxicity"]
train_feature = train_data.iloc[:,26:]
train_feature.columns = range(train_feature.shape[1])

train_label = pd.concat([train_label, unlabeled_label], ignore_index=True)
print(train_label)
