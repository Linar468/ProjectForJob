name = input("Please enter your name: ")
print ("Привет, " + name)

num1 = input("Enter x: ")
num2 = input("Enter y: ")
sum = int(num1) + int(num2)
print(sum)

password = " "
while (password != "111"):
    password = input("Enter password: ")


myList = []
msg = ""
while  msg!= "stop".upper():
    msg = input("Enter new item, or \"STOP\" to finish: ")
    myList.append(msg)
print(msg)
print(myList)


