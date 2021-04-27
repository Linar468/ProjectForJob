inputfile = "ABC.txt"
myFile = open (inputfile, mode="r", encoding="latin_1")
print(myFile.read())
myFile.close()

myFile2 = open (inputfile, mode="r", encoding="latin_1")
myList = []
for line in myFile2:
    print("Hello " + line)
    myList.append(line)
myFile2.close()

myFile3 = open(inputfile, mode="r", encoding="latin_1")
for num, line in enumerate(myFile3, 1):
    print(str(num) + " Hello " + line)
myFile3.close()


myFile4 = open(inputfile, mode="r", encoding="latin_1")
for num, line in enumerate(myFile4, 1):
    if "X" in line:
        print(str(num) + " Hello " + line)
myFile4.close()


outputfile = "newFile.txt"
myFile5 = open(outputfile, mode="w", encoding="latin_1")
myFile5.write("New line")
myFile5.close()

