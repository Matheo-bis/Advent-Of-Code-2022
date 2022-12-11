file = open("input")
lines = file.readlines()
file.close()

global i
global count
global x
i=0
count=0
x=1

def verify():
    global i
    global count
    global x
    i+=1
    if (i-20)%40==0 and i>=20:
        print(x)
        count+=i*x

for line in lines:
    if line=="noop\n":
        verify()
    else:
        title, number = line.split(" ")
        verify()
        verify()
        x+=int(number)
print(count)

global CRT
i=0
x=1
CRT=""
def verify2():
    global i
    global x
    global CRT
    if i==(x-1) or i==x or i==(x+1):
        CRT+="#"
    else: CRT+="."
    i+=1
    if i==40:
        print(CRT)
        CRT=""
        i=0

for line in lines:
    if line=="noop\n":
        verify2()
    else:
        title, number = line.split(" ")
        verify2()
        verify2()
        x+=int(number)

