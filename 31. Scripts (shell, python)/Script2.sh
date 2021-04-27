#!/bin/bash
username = "Linar"
myos = `uname -a`
echo "This script name is $0"
echo "Operation system is $myos"
echo "username = $username"
echo "Privet, $1"
echo "Hello, $2"
num1=100
num2=500
sum=$((num1+num2))
echo "$num1 + $num2 = $sum"
myHost=`hostname`
mygtw="8.8.8.8"
ping 4 $myHost
ping -c 4 $mygtw
echo -n "This is done..."
echo "Really done"
                
