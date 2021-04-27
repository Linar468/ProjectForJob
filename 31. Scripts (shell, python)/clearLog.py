#!/bin/python3

import os
import sys
if(len(sys.argv) < 3):
    print("Missing arguments!")
    exit(1)
fileName  = sys.argv[1]
limitSize  = int(sys.argv[2])

if(os.path.isfile(fileName) == True):
    fileSize = os.stat(fileName).st_size
    fileSize = fileSize / 1024
    if(fileSize >= limitSize):
        myfile = open(fileName, 'w')
        myfile.close()