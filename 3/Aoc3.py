fichier = open("3/input")
lines = fichier.readlines()
fichier.close()

priorities={}
for i in range(1,27):
    priorities[chr(0x60+i)]=i
    priorities[chr(0x40+i)]=26+i

count=0
for line in lines:
    mid=len(line)//2
    comp1=line[:mid]
    comp2=line[mid:]
    for char in comp1:
        if comp2.__contains__(char): 
            count+=priorities[char]
            break
print(count)