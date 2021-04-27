a = set()
print(a)

a = set([1, 10, 5, 'Hello'])
print(a)

b = {1, 10, "Hello", "Hey"}
print(b)

a = {}
print(type(a))

a = set()
print(a)

a.add(1)
print(a)

a.add (2)
a.add('Hello')
a.add(10)

for el in a:
    print(el)

My_list = [1, 2, 1, 1, 5, "Hello", "hello"]
My_set = set()
for el in My_list:
    My_set.add(el)
print(My_set)

My_set = set(My_list)
print(My_set)

My_list = list(My_set)
print(My_list)

a = {'Hello', 'Hey', 1, 10, 5}
print(5 in a)

5 in a

print(3 in a)

print(5 not in a)

my_list = [1, 1, 2, 5, 10, 10, 10]
my_set = set(my_list)
total = 0
for num in my_set:
    total = total + num
print(sum)

my_list = [1, 1, 2, 5, 10, 10, 10]
print(sum(set(my_list)))

def qaz(set, list):
    if len(list) > len (set):
        print("Falsee")
    key = 1
    for el in list:
        if el in set:
            key1 = 1
            key = key * key1
        else:
            key1 = 0
            key = key * key1
    print(key)
    if key == 1:
        print('True')
    else:
        print('False')


def qwe(set, list):
    if len(list) > len(set):
        return False
    for el in list:
        if el not in set:
            return False
    return True

qaz({1,2,3,4,5}, [1,3,5])

qwe({1,2,3,4,5}, [1,3,5])