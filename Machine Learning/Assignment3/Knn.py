from sklearn.neighbors import KNeighborsClassifier
from sklearn import metrics
from sklearn.dummy import DummyClassifier
import pandas as pd


train_file = "dataset/dataset/train_embedding.csv"
test_file = "dataset/dataset/dev_embedding.csv"

identity  = ["Christian", "Muslim", "Female", "Homosexual gay or lesbian","Male"]

train_data = pd.read_csv(train_file)
print("train data load successfully")

test_data = pd.read_csv(test_file)
print("test data load successfully")

#train_label = train_data["Toxicity"]
#train_feature = train_data.iloc[:,26:]
#print("train data processed")


test_label = test_data["Toxicity"]
test_feature = test_data.iloc[:,26:]

print("test data processed")

clf1 = KNeighborsClassifier(n_neighbors=3, weights='distance', n_jobs=-1, metric = 'cosine')
#clf1.fit(train_feature, train_label)



for i in identity:
    print(i)
    
    train = train_data.loc[train_data[i] == 1 ]
    train_label = train["Toxicity"]
    train_feature = train.iloc[:,26:]
    
    test = test_data.loc[test_data[i] == 1 ]

    clf1.fit(train_feature, train_label)

    test_label = test["Toxicity"]
    test_feature = test.iloc[:,26:]
    print("test data processed")

    
    print("Knn model trained")
    predic = clf1.predict(test_feature)
    print(metrics.classification_report(test_label, predic))

    """
    clf2 = DummyClassifier(strategy= 'most_frequent')
    clf2.fit(train_feature, train_label)
    predic = clf2.predict(test_feature)
    print(metrics.classification_report(test_label, predic))
    """
    
    print("---------------------------------")