list = [10, 12, 14, 29, 37, 55, 67, 81, 132]

def binarySearch(myList, find, start, stop):
    if start > stop:
        return False
    else:
        mid = (start+stop)//2
        if find == myList[mid]:
            return mid
        elif find < myList[mid]:
            return binarySearch(myList, find, start, mid-1)
        else:
            return binarySearch(myList, find, mid+1, stop)

find = 29
start = 0
stop = len(list)
x = binarySearch(list, find, start, stop)
if x == False:
    print("Not found")
else:
    print (find, " Found at index ", x )