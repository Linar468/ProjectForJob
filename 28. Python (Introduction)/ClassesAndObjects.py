class Person():
    def __init__(self, name, surname, age, salary):
        self.name = name
        self.surname = surname
        self.age = age
        self.salary = salary

    def getInfo(self):
        info = "Name: " + self.name + ", surname: " + self.surname + ", age: " + str(self.age) + ", salary " + str(self.salary)
        print(info)

    def salaryUp(self):
        self.salary += 1000

person1 = Person("Linar", "Latypov", 27, 1500)

person1.getInfo()
person1.salaryUp()
person1.getInfo()