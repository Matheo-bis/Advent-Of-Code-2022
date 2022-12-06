from Pile import Pile

fichier = open("input")
lines = fichier.readlines()
fichier.close()

init=lines[:8]
piles=[Pile() for i in range(9)]
for line in init:
    j=0
    for i in range(1, len(line),4):
        if line[i]!=" ": piles[j].empiler(line[i])
        j+=1

for pile in piles:
    pile.inverser()

instructions=lines[10:]
for instruction in instructions:
    instruction=instruction.split("move ")[1]
    number , instruction = instruction.split(" from ")
    source , dest = instruction.split(" to ")
    for i in range(int(number)):
        piles[int(source)-1].transfere(piles[int(dest)-1])

for pile in piles:
    print(pile.depiler())
print()

piles=[Pile() for i in range(9)]
for line in init:
    j=0
    for i in range(1, len(line),4):
        if line[i]!=" ": piles[j].empiler(line[i])
        j+=1

for pile in piles:
    pile.inverser()

instructions=lines[10:]
for instruction in instructions:
    instruction=instruction.split("move ")[1]
    number , instruction = instruction.split(" from ")
    source , dest = instruction.split(" to ")
    temp = Pile()
    for i in range(int(number)):
        piles[int(source)-1].transfere(temp)
    for i in range(int(number)):
        temp.transfere(piles[int(dest)-1])
        
for pile in piles:
    print(pile.depiler())
