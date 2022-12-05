from Pile import Pile

fichier = open("5/input")
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
    print(instruction)
