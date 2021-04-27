person = {"name" : "Linar",
           "surname":"Latypov",
           "age":27,
          "salary":1500}
print(person)
person["salary"] = 2000
print (person)

employees = []
employees.append(person)
print(employees)
employees[0]["salary"] = 3000
print(employees)

d = {"Alex" : 25, "Petr": 50, "Kate" : 30, "Tom" : 15}
print(d)
len(d)
d["Ann"] = 100, 150
print(d)
d["Kate"] = 40
print(d["Kate"])
print(d)
for k, v in d.items():
    print(k)
    print(v)

for key, value in d.items():
    print ("Ключ: " + str(key) + " , значение: " + str(value))