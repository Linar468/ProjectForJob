def function1():
    print("dlfjge")
    print("ыыыыы")

function1()

def function2(x):
    return 2*x
a = function2(5)
print(a)


def sumtwo(x,y):
    return x+y
sa = sumtwo(500,600)
print (sa)


def fun5(some):
    print(some)
    print("sgawrgwerg")

def fun6():
    return 5

def fun8(x):
    print(x)
    print("krsljgha")
    return 3*x

b = fun8(10)
print(b)

n1 = "Том"
h1 = 1.90
w1 = 80

n2 = "Джери"
h2 = 1.50
w2 = 40

n3 = "Стюарт"
h3 = 1.60
w3 = 150


def calc(name, height, weight):
    bmi = weight / (height ** 2)
    print("Индекс мт:" + " " + str(bmi))

    if bmi < 25:
        return name + " не страдает избыточным весом"
    else:
        return name + " имеет лишний вес"
bmi1 = calc(n1, h1, w1)
bmi2 = calc(n2, h2 ,w2)
bmi3 = calc(n3, h3, w3)

print (bmi1)
print(bmi2)
print(bmi3)

def convmil():
    miles = km / 1.609
    print("В "+str(km)+" километрах " + str(miles)+ " миль")
km=2500
convmil()

def is_even(x):
    c = x % 2
    if c == 0  :
        return str(x) + " число четное"
    else:
        print ("число нечетное")

is_even(560)