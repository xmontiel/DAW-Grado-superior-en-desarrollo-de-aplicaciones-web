#!/bin/bash
clear
rm -f castilla.txt
rm -rf VACACIONES
touch castilla.txt
echo León Zamora Salamanca Palencia Valladolid Segovia Burgos Ávila Soria Toledo Gualadajara Ciudad Real Albacete Cuenca > castilla.txt
mkdir VACACIONES
cd VACACIONES
touch cataluña.txt
echo Barcelona Lleida Girona Tarragona > cataluña.txt
touch cantabria.txt
echo Santander Torrelavega > cantabria.txt
touch galicia.txt
echo Lugo Compostela Coruña Vigo Ourense > galicia.txt
cd ..

fichero="castilla.txt"
directorio="VACACIONES"
salida="SALIDAS.txt"

echo "Busqueda de palabra en el fichero $fichero y en el directorio $directorio. Introduzca la palabra a buscar:"
read -r palabra
echo "BUSQUEDA EN $fichero:" > "$salida"
grep "$palabra" "$fichero" >> "$salida"
echo "********************************************" >> "$salida"
echo "BUSQUEDA EN $directorio:" >> "$salida"
grep -r "$palabra" "$directorio" >> "$salida"
echo "RESULTADOS DE LA BUSQUEDA EN $salida:"
cat SALIDAS.txt
echo "ESTOS ES TODO AMIGOOOO!!!."

