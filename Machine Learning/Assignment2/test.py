from math import log
import pandas as pd

data = pd.read_csv("obesity.csv")
data = data.drop("ID", axis=1)

feature_names = data.iloc[:, :-1].keys()
label_values = data['label'].sort_values().unique()
# Count probability of each feature for each label
Conditional_pro = {}
Priori_pro = {}

total_instances = data.shape[0]

eps = 1/total_instances/1000

for label in label_values:
    Conditional_pro[label] = {}
    label_freq = len(data[data['label'] == label])
    total_num = len(data)
    Priori_pro[label] = label_freq / total_num

    for feature in feature_names:
        Conditional_pro[label][feature] = {}
        feature_cats = data[feature].unique()

        for cat in feature_cats:
            feature_freq = len(
                data[(data[feature] == cat) & (data['label'] == label)])
            if feature_freq == 0:
                Conditional_pro[label][feature][cat] = eps
            else:
                Conditional_pro[label][feature][cat] = feature_freq / label_freq

Prediction = []
Result= []
for index, row in data.iterrows():
    Probablily = {}
    for label in label_values:
        Probablily[label] = log(Priori_pro[label])
        for feature in feature_names:
            Probablily[label] += log(Conditional_pro[label]
                                        [feature][row[feature]])
    Result.append(Probablily)
    Prediction.append(max(Probablily, key=Probablily.get))


w_precision = 0

data_labels = data['label']

for label in label_values:
    TP = 0
    FP = 0
    
    weight = Priori_pro[label]
    for i in range(total_instances):
        if Prediction[i] == label:
            if data_labels[i] == label:
                TP += 1
            else:
                FP += 1
    
    w_precision += weight*TP/(TP+FP)

Error_rate = {}
for feature in feature_names:
    feature_cats = data[feature].unique()
    
    total_err = 0
    for cat in feature_cats:
        num_cat = len(data[(data[feature] == cat)])
        label_freq = {}
        
        for label in label_values:
            freq = len(data[(data[feature] == cat) & (data['label'] == label)])
            
            label_freq[label] = freq
        
        
        predict_label = max(label_freq, key=label_freq.get)
        total_err += num_cat-label_freq[predict_label]

    Error_rate[feature] = total_err/total_instances

selected_feature = min(Error_rate, key=Error_rate.get)
error = Error_rate[selected_feature]

"""
print("------")
print(Error_rate)
print(selected_feature, error)
print(w_precision)
"""

print(Conditional_pro)