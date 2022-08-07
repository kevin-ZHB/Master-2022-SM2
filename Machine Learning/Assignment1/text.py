
import math
from collections import Counter
from sklearn.metrics import accuracy_score

data = open("car.features", 'r').readlines()
labels = open("car.labels", 'r').readlines()

train_features = []
train_labels   = []
test_features = []
test_labels   = []


###########################
## YOUR CODE BEGINS HERE
###########################

# Get rid of header
features = data[1:]
labels = labels[1:]

for index in range(len(features)):
    feature = features[index].strip().split(",")
    label  = labels[index].strip().split(",")
    # convert from string list to numeric list
    feature[0] = int(feature[0])
    feature[1:]= list(map(lambda x: float(x), feature[1:]))
    label[0] = int(label[0])

    if index < 163:
        train_features.append(feature)
        train_labels.append(label[1])
    else:
        test_features.append(feature)
        test_labels.append(label[1])
    index += 1




def euclidean_distance(fw1, fw2):
    # insert code here
    distance = math.sqrt(sum(map(lambda x, y: (x-y)**2, fw1, fw2)))
    # same result by using math.dist(fw1,fw2)
    
    return distance




def cosine_distance(fw1, fw2):
    # insert code here

    def dot(fw1,fw2):
        result = sum(map(lambda x,y: x*y, fw1, fw2))
        return result
    
    def norm(fw1):
        result = math.sqrt(sum(map(lambda x: x**2, fw1)))
        return result

    distance = 1- dot(fw1,fw2) / (norm(fw1)*norm(fw2))
    return distance


def chebyshev_distance(fw1, fw2):
    # insert code here
    
    distance = max(map(lambda x,y: x-y, fw1, fw2))

    return distance




def KNN(train_features, train_labels, test_features, k, dist_fun, weighted=False):
    
    predictions = []
    
    ###########################
    ## Your answer BEGINS HERE
    ###########################
    
    
    
    for test_feature in test_features:
        
        # Calculate distances
        Dist_label = []
        for train_feature in train_features:
            dist = dist_fun(train_feature, test_feature)
            label = train_labels[train_feature[0]]
            Dist_label.append([dist,label ])
        
        """ 
        Automatically break ties since instances with smaller identifier are always calculated first.
        """
        Knn = sorted(Dist_label, key = lambda x: x[0])[:k]
        
        if weighted:
            eps = 0.000001
            w_Knn = {}
            for neighboor in Knn:
                weight =  1/(neighboor[0]+eps)
                label = neighboor[1]
                w_Knn[label] = w_Knn.get(label,0.0)+weight
            
            prediction =max(w_Knn,key = w_Knn.get)
            
        
        else:
            Knn_lables = [i[1] for i in Knn]
            prediction = Counter(Knn_lables).most_common()[0][0]
        
        predictions.append(prediction)

        
    ###########################
    ## Your answer ENDS HERE
    ###########################
    
    return predictions


knn_euc_1_pre= KNN(train_features, train_labels, test_features, 1, euclidean_distance, weighted=False)


accuracy_knn_euc_1 = accuracy_score(knn_euc_1_pre,test_labels)

print(accuracy_knn_euc_1)