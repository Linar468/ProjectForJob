a = [3, 5, 20]
print(a)

a.append(15)
print(a)

a.append('Hi!')
print(a)

a.append([5, 6])
print(a)
a.pop()
print(a)



print(a[3])

a[0]=100
print(a)

a.pop(2)
print(a)

b = ["Hello", "Goodbye", "Hey"]
temp = b[0]
b[0] = b[2]
b[2] = temp

b[0], b[2] = b[2], b[0]
print(b)
a, b, c, e = 1, 2, 3, 4
print(a)
print(b)
print(c)
print(e)


a = [1, 2, 3, 4, 5]
b = []
for num in a:
    b.append(num * 2)
print(b)

c = [num * 2 for num in a]
print(c)

range3 = [num * 3 for num in range(1, 6)]
print(range3)

range_el = []
for num in range(1,6):
    range_el.append(num * 3)
print(range_el)


t = []
for num in a:
    if num < 10:
        t.append(num)
print(t)

t2 = [num for num in a if num < 10]
print(t2)

t3 = [num ** 2 for num in a if num < 10]
print(t3)

myList = list(range(1,10))
print(myList)

myNewList = myList[1:3]
myNewNewList = myList[:]
print (myNewList)

print(list(range(1, 100)))

