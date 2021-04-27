filename = "123.txt"

try:
    print("Try Block")
    myfile = open(filename, mode="r", encoding="Latin-1")
except Exception:
    print("Except block")
    print("Error")
else:
    print("Else block")
    print(myfile.read())
finally:
    print("Finally block")