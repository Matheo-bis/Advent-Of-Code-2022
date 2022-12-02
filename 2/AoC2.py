fichier = open("2/input")
lines = fichier.readlines()
fichier.close()

count = 0
for line in lines:
    coup1, coup2 = line.split(" ")
    print(coup2)
    if (coup1 == "A"):
        if (coup2 == "X\n"):
            count += 4
        elif (coup2 == "Y\n"):
            count += 8
        elif (coup2 == "Z\n"):
            count += 3
    elif (coup1 == "B"):
        if (coup2 == "X\n"):
            count += 1
        elif (coup2 == "Y\n"):
            count += 5
        elif (coup2 == "Z\n"):
            count += 9
    elif (coup1 == "C"):
        if (coup2 == "X\n"):
            count += 7
        if (coup2 == "Y\n"):
            count += 2
        if (coup2 == "Z\n"):
            count += 6
print(count)

count = 0
for line in lines:
    coup1, coup2 = line.split(" ")
    print(coup2)
    if (coup1 == "A"):
        if (coup2 == "X\n"):
            count += 3
        elif (coup2 == "Y\n"):
            count += 4
        elif (coup2 == "Z\n"):
            count += 8
    elif (coup1 == "B"):
        if (coup2 == "X\n"):
            count += 1
        elif (coup2 == "Y\n"):
            count += 5
        elif (coup2 == "Z\n"):
            count += 9
    elif (coup1 == "C"):
        if (coup2 == "X\n"):
            count += 2
        if (coup2 == "Y\n"):
            count += 6
        if (coup2 == "Z\n"):
            count += 7
print(count)