def privet(x):
    if x == 0:
        return
    else:
        print("Hello")
        privet(x-1)

privet(10)

def sum(x):
    if x == 0:
        return 0
    elif x == 1:
        return 1
    else:
        return x + sum(x-1)

z = sum(5)
print(z)

def factorial(x):
    if x == 0:
        return 1
    else:
        return x * factorial(x-1)

a = factorial(10)
print(a)

def fibonacci(x):
    if x == 0:
        return 0
    elif x == 1:
        return 1
    else:
        return fibonacci(x-1) + fibonacci(x-2)

s = fibonacci(10)
print(s)