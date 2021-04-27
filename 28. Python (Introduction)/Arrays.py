words = ["Hello", "Hey", "Goodbye", "piano", "banana", "apple"]
words2 = [word for word in words if len(word) < 6]
print(words2)

cities = ["New York", "London", "Berlin", "Toronto"]
print(cities)
print(cities[1])
print(cities[-2].title())
print(cities[-2].upper())

cities.append("Zagreb")
print(cities)

cities.insert(0,"Milano")
print (cities)

del cities[2]
print(cities)

cities.remove("Zagreb")

cities.pop()
print(cities)

print(cities.sort(reverse=True))
cities.reverse()

cars = ["bmw", "honda", "vw", "toyota"]
for x in cars:
    print (x.upper())

arr_2d = [[1, 2, 3],
         [4, 5, 6],
         [7, 8, 9]]
print(arr_2d)
arr_2d_2 = [[1,2,3], [4,5,6,-1,-5], [7]]
print(arr_2d_2)

def print_matrix(arr_2d):
    for arr in arr_2d:
        for el in arr:
            print(el, end=" ")
        print()

print_matrix(arr_2d)

def print_matrix2(arr_2d):
    for i in range (len(arr_2d)):
        for j in range (len(arr_2d[i])):
            print(arr_2d[i][j], end = ' ')
        print()
print_matrix2(arr_2d)