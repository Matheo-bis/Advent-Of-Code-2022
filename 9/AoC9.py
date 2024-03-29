import numpy as np

file = open("9/input")
lines = file.readlines()
file.close()

H=np.array([0,0])
T=np.array([0,0])
Covered=[]
directions={"U":np.array([0,1]),"D":np.array([0,-1]),"L":np.array([-1,0]),"R":np.array([1,0])}

for line in lines:
    direction, distence = line.split(" ")
    for i in range(int(distence)):
        H+=directions[direction]
        if(np.sqrt(np.sum(np.power(H-T, 2)))>np.sqrt(2)):
            vector=np.array([0,0])
            if(T[0]<H[0]): vector+=directions["R"]
            elif(T[0]>H[0]): vector+=directions["L"]
            if(T[1]<H[1]): vector+=directions["U"]
            elif(T[1]>H[1]): vector+=directions["D"]
            T+=vector
        if T.tolist() not in Covered: Covered.append(T.tolist())
print(len(Covered))

Rope=[np.array([0,0]) for i in range(10)]
Covered=[]
for line in lines:
    direction, distence = line.split(" ")
    for i in range(int(distence)):
        Rope[0]+=directions[direction]
        for j in range(1,10):
            H=Rope[j-1].copy()
            T=Rope[j].copy()
            if(np.sqrt(np.sum(np.power(H-T, 2)))>np.sqrt(2)):
                vector=np.array([0,0])
                if(T[0]<H[0]): vector+=directions["R"]
                elif(T[0]>H[0]): vector+=directions["L"]
                if(T[1]<H[1]): vector+=directions["U"]
                elif(T[1]>H[1]): vector+=directions["D"]
                T+=vector
            Rope[j-1]=H.copy()
            Rope[j]=T.copy()
        if Rope[9].tolist() not in Covered: Covered.append(Rope[9].tolist())
print(len(Covered))