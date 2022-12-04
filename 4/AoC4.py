file = open("input")
lines = file.readlines()
file.close()

count = 0
for line in lines:
    elf1, elf2 = line.split(",")
    begin1, end1 = elf1.split("-")
    begin2, end2 = elf2.split("-")
    if (int(begin1) >= int(begin2)) and (int(end1) <= int(end2)): count += 1
    elif (int(begin2) >= int(begin1)) and (int(end2) <= int(end1)): count += 1
print(count)

count = 0
for line in lines:
    elf1, elf2 = line.split(",")
    begin1, end1 = elf1.split("-")
    begin2, end2 = elf2.split("-")
    flag = False
    for i in range(int(begin1),int(end1)+1):
        if flag == True :
            flag = False
            break
        for j in range(int(begin2),int(end2)+1):
            if i==j:
                count +=1
                flag = True
print(count)
    
