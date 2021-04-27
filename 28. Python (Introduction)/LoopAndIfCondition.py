x = 0;

for x in range (1,100, 10):
    print (x)
    if x>50:
        break


y = 10;
while y<100:
    print(y)
    y+=1



age = 27
if (age<10):
    print("You are baby")
elif (age>10) and (age<20):
    print ("you are teenager")
else:
    print("you are old")

name ="Линар"
h=1.76
w=78
bmi = w / (h**2)
print ("Индекс массы тела" +" "+ name + "а"+' '+ "равен" +" "+ str(bmi))

if bmi<25:
    print (name +" " +"дрищ")
else:
    print (name +" "+ "масса")

mybool=10<5
print (mybool)

c = 5
d = 4
if c < d:
    print(' с меньше д')
else:
    print('с либо больше чем д, либо равняется d')
    print('asdf')

print('вне блока if')

my_list = [7, 5, 4, 4, 3, 2, 1, -5, -10, -15]

sum3 = 0
i2 = 0

while my_list[i2] > 0:
    sum3 += my_list[i2]
    i2 += 1

sum4 = 0
for element in my_list:
    if element <= 0:
        break

    sum4 += element

print(sum3)
print(sum4)

my_list4 = [7, 5, 4, 4, 3, 2, 1, -5, -10, -15, -18, -20, -23]
totalit = 0
for b in range(len(my_list4) - 1, -1, -1):
    if my_list4[b] > 0:
        break
    totalit += my_list4[b]
print(totalit)

word = ["Яблоко", "Груша", "Тыква", "Ананас", "Стоп", "Банан", "Апельсин"]
i12 = 0
while word[i12] != "Стоп":
    print(word[i12])
    i12 += 1

for w in range(len(word)):
    if word[w] == "Стоп":
        break
    print(word[w])

names = ['Mike', 'Ann', 'Bob', 'Tom']
for element in names:
    print(element)

for i in range(0, len(names), 1):
    print(names[i])

for h in range(len(names)):
    for j in range(h + 1):
        print(names[h])


sum4 = 0
def qqq (n, k):
    if n > 20:
        sum4 = 0
        print (list(range(1, n)))
        print("sum4"+" =" +" "+ str(sum4))
        print(n)
        print(k)
    elif n <= 20:
        sum4 = 0
        for i in range (1, n):
            if i % 2 == 0:
                sum4 = sum4 + i ** k
                print (i)
        print('n='+ ' '+ str(n))
        print('k='+ ' '+ str(k))
        print(("sum4"+" =" +" "+ str(sum4)))