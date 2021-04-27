import json
filename = "users.txt"

myfile = open(filename, mode="w", encoding="Latin-1")
person1 = {
    "name":"Tom",
    "age": 27
}

person2 = {
    "name" : "Katy",
    "age" : 35
}

persons = []
persons.append(person1)
persons.append(person2)

json.dump(persons, myfile)
myfile.close()

myFile2 = open(filename, mode="r",encoding="Latin-1")
jsonData = json.load(myFile2)
for section in jsonData:
    print("Name: " + str(section["name"]))
    print("Age: " + str(section["age"]))
