#!/bin/bash

addition=0
subtraction=0
multiplication=0
division=0

myFunc()
{
        echo "Function is called"
        echo "Num1= $1"
        echo "Num2= $2"
        addition=$(($1+$2))
        subtraction=$(($1-$2))
        multiplication=$(($1*$2))
        division=$(($1/$2))
}

myFunc 100 500
echo "Addition = $addition"
echo "Subtraction = $subtraction"
echo "Multiplication = $multiplication"
echo "Division = $division"
