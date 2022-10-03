from sklearn.dummy import DummyClassifier
import pandas as pd


train_file = "Machine Learning/Assignment3/dataset/dataset/train_tfidf.csv"
test_file = "Machine Learning/Assignment3/dataset/dataset/dev_tfidf.csv"

train_data = pd.read_csv(train_file)
print("train data load successfully")

test_data = pd.read_csv(test_file)
print("test data load successfully")


train_label = train_data["Toxicity"]
train_feature = train_data.iloc[:,26:]
print("train data processed")


test_label = test_data["Toxicity"]
test_feature = test_data.iloc[:,26:]
print("test data processed")

clf = DummyClassifier(strategy= 'most_frequent')
clf.fit(train_feature, train_label)
score = clf.score(test_feature, test_label)

print(score)