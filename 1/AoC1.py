file = open("input")
lines = file.readlines()
file.close()

elves=[]
buff=0

for line in lines:
    if line=="\n":
        elves.append(buff)
        buff=0
    else:
        buff+=int(line)
print(max(elves))

maxbuff=0
for i in range(3):
    maxbuff+=max(elves)
    elves.remove(max(elves))
print(maxbuff)

