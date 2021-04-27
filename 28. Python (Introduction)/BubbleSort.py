list = [10, 75, 123, 45, 65, 52]

def bubbleSort(myList):
    lastItem = len(myList)-1
    for i in range(0, lastItem):
        for y in range(0, lastItem):
            if myList[y] > myList[y+1]:
                myList[y], myList[y+1] = myList[y+1], myList[y]
    return myList

print(bubbleSort(list))

