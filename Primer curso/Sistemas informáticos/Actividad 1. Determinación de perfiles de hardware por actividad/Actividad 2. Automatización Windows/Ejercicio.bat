@echo off
cls

rem  README:
rem Tras hacer varias pruebas, ocurren los siguientes problemas:
rem - Si se abre el archivo sin permisos de administrador:
rem   La comprobación de disco no se podrá efectuar.
rem - Si se accede al documento con doble click:
rem - La opción "SALIR" nos cerrará la consola.
rem Por tanto la manera óptima de utilizar este fichero bat es accediendo a CMD con permisos de admin y abrir el bat desde ahí.

:menu
cls
echo ***********************************************************
echo ***********************************************************
echo ****         TURBO ACTIVIDAD 2 SPECIAL EDITION         ****
echo ***********************************************************
echo ***********************************************************
echo.

echo IMPORTANTE: Es posible que no se genere toda la informacion si no se ejecuta como administrador.
echo.

cd /d "%~dp0"
rem Esta linea de código hace que los documentos se generen en la misma ruta en la que se encuentra el bat.
rem De otra manera, al ejecutar como admin abriendo directamente el archivo nos generaba los documentos en System32.

echo Nuestros documentos se generaran en:
cd
echo.

echo 1- CREAR ESTRUCTURA
echo 2- CREAR INFORMACION
echo 3- ABRIR DOCUMENTOS
echo 4- SALIR

choice /c 1234 /M "Elige una opcion"

if errorlevel 4 exit /B
if errorlevel 3 goto :abrir
if errorlevel 2 goto :informacion
if errorlevel 1 goto :estructura

:estructura
    echo GENERANDO DIRECTORIO RAIZ...
    mkdir DIR_RAIZ
    cd DIR_RAIZ
    echo GENERANDO DIRECTORIO DE RED...
    mkdir RED
    echo GENERANDO DIRECTORIO DE SISTEMA...
    mkdir SISTEMA
    echo GENERANDO DIRECTORIO ONLINE...
    mkdir ONLINE
    echo ESTRUCTURA CREADA CON EXITO!
    cd /d "%~dp0"
    rem: Utilizando esta linea de código en lugar de subir con cd.., en caso de no crear las carpetas, los archivos se crean en el mismo directorio y no van creandose subiendo.
    pause
    goto :menu

:informacion
    cd DIR_RAIZ
    cd RED
    echo GENERANDO DATOS DE IP EN RED/CONFIGRED.TXT...
    echo *********************************************************** > CONFIGRED.txt
    echo *********************************************************** >> CONFIGRED.txt
    echo ****         TURBO ACTIVIDAD 2 SPECIAL EDITION         **** >> CONFIGRED.txt
    echo ****                DATOS DE IP EN RED                 **** >> CONFIGRED.txt
    echo *********************************************************** >> CONFIGRED.txt
    echo *********************************************************** >> CONFIGRED.txt
    echo. >> CONFIGRED.txt
    ipconfig >> CONFIGRED.txt
    cd /d "%~dp0"

    cd DIR_RAIZ
    cd SISTEMA
    echo GENERANDO DATOS DE ESTATUS DE DISCO C: EN SISTEMA/CHEQUEO.TXT...
    echo *********************************************************** > CHEQUEO.txt
    echo *********************************************************** >> CHEQUEO.txt
    echo ****         TURBO ACTIVIDAD 2 SPECIAL EDITION         **** >> CHEQUEO.txt
    echo ****           DATOS DE ESTATUS DE DISCO C:            **** >> CHEQUEO.txt
    echo *********************************************************** >> CHEQUEO.txt
    echo *********************************************************** >> CHEQUEO.txt
    echo. >> CHEQUEO.txt
    chkdsk c: >> CHEQUEO.txt
    cd /d "%~dp0"

    cd DIR_RAIZ
    cd ONLINE
    echo DIME LA IP QUE DESEAS PINGUEAR:
    set /P ip=
    echo GENERANDO DATOS DE PINGUEO EN ONLINE/PINGIP.TXT...
    echo *********************************************************** > PINGIP.txt
    echo *********************************************************** >> PINGIP.txt
    echo ****         TURBO ACTIVIDAD 2 SPECIAL EDITION         **** >> PINGIP.txt
    echo ****                   IP PINGUEADA                    **** >> PINGIP.txt
    echo *********************************************************** >> PINGIP.txt
    echo *********************************************************** >> PINGIP.txt
    echo. >> PINGIP.txt
    ping %ip% >> PINGIP.txt
    cd /d "%~dp0"
    echo DOCUMENTOS CREADOS CON EXITO!
    pause
    goto :menu

:abrir
    cd DIR_RAIZ
    cd RED
    start notepad CONFIGRED.txt
    cd /d "%~dp0"

    cd DIR_RAIZ
    cd SISTEMA
    start notepad CHEQUEO.txt
    cd /d "%~dp0"

    cd DIR_RAIZ
    cd ONLINE
    start notepad PINGIP.txt
    cd /d "%~dp0"
    goto :menu
