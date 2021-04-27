#!/bin/bash
if   [ "$1" == "simple" ]; then
     echo "Privet, Linar"
elif [ "$1" == "official" ]; then
     echo "Zdravstvuite, Linar"
else echo "Hello"

read -p "Enter something" x
echo "Starting case selection..."
case $x in
         1) echo "This is 1";;
     [2-9]) echo "This is from 2 to 9";;
   "Hello") echo "$x";;
         *) echo "Parameter unknown"

esac
echo "Done"