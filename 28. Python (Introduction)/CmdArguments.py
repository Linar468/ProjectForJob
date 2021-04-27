import os
import sys

print("Hello")

x = len(sys.argv)
print(sys.argv)

if x>1:
    if sys.argv[1] == "/?":
        print("Help requested")
    print("Arguments entered:" + str(sys.argv))

else:
    print("Arguments not provided")

os.system("dir > test.txt")
os.mkdir("new dir")
sys.exit()
