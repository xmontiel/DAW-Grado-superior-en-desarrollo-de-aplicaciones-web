#!/bin/bash
clear

num1=$1
num2=$2

read -p "Elija el numero de la operación: 1.suma 2.resta 3.multiplicación 4.división: " opcion

if [ "$opcion" = "1" ]; then resultado=$(($num1+$num2))
echo "El resultado es $resultado"
elif [ "$opcion" = "2" ]; then resultado=$(($num1-$num2))
echo "El resultado es $resultado"
elif [ "$opcion" = "3" ]; then resultado=$(($num1*$num2))
echo "El resultado es $resultado"
elif [ "$opcion" = "4" ]; then resultado=$(($num1/$num2))
echo "El resultado es $resultado"
else echo "OPCIÓN INCORRECTA"
fi