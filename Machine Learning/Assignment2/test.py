import pandas as pd

df = pd.read_csv("obesity.csv")
df = df.drop("ID" ,axis=1)
header = df.iloc[:,:-1].keys()

print(header)