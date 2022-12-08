file = open("8/input")
lines = file.readlines()
file.close()

matrix=[]
for line in lines:
    matrix.append([])
    for char in line:
        if char != '\n': matrix[len(matrix)-1].append(int(char))
print(matrix)

count = 0
I=len(matrix)
J=len(matrix[0])
for i in range(I):
    for j in range(J):
        # sur le bord?
        if i==0 or j==0 or i == I-1 or j == J-1: 
            count += 1
        else:
            tree=matrix[i][j]
            # vers le haut
            isVisibleUp = True
            k = i-1
            while(k>=0):
                if matrix[k][j]>=tree:
                    isVisibleUp = False
                    break
                k -= 1
            # vers le bas
            isVisibleDown = True
            k = i+1
            while(k<I):
                if matrix[k][j]>=tree:
                    isVisibleDown = False
                    break
                k += 1
            # vers la gauche
            isVisibleLeft = True
            k = j-1
            while(k>=0):
                if matrix[i][k]>=tree:
                    isVisibleLeft = False
                    break
                k -= 1
            # vers la droite
            isVisibleRight = True
            k = j+1
            while(k<J):
                if matrix[i][k]>=tree:
                    isVisibleRight = False
                    break
                k += 1
            # test final
            if isVisibleUp or isVisibleDown or isVisibleLeft or isVisibleRight : count+=1
print(count)

count = []
for i in range(I):
    for j in range(J):
        # sur le bord?
        if i==0 or j==0 or i == I-1 or j == J-1: 
            continue
        else:
            tree=matrix[i][j]
            # vers le haut
            VisibleUp = 0
            k = i-1
            while(k>=0):
                VisibleUp += 1
                if matrix[k][j]>=tree:
                    break
                k -= 1
            # vers le bas
            VisibleDown = 0
            k = i+1
            while(k<I):
                VisibleDown += 1
                if matrix[k][j]>=tree:
                    break
                k += 1
            # vers la gauche
            VisibleLeft = 0
            k = j-1
            while(k>=0):
                VisibleLeft += 1
                if matrix[i][k]>=tree:
                    break
                k -= 1
            # vers la droite
            VisibleRight = 0
            k = j+1
            while(k<J):
                VisibleRight += 1
                if matrix[i][k]>=tree:
                    break
                k += 1
            # test final
            count.append(VisibleUp*VisibleDown*VisibleLeft*VisibleRight)
print(max(count))