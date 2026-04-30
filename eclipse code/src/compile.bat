@echo off
setlocal enabledelayedexpansion

REM Prompt for class file name without extension
set /p className=Enter the name of your Java class file (without .java): 

REM Ask to compile
set /p compileChoice=Do you want to compile the class? (yes/no): 

if /i "%compileChoice%"=="yes" (
    javac --module-path .\javafx-sdk-26.0.1\lib --add-modules=javafx.controls,javafx.fxml %className%.java
)

REM Ask to run
set /p runChoice=Do you want to run the class? (yes/no): 

if /i "%runChoice%"=="yes" (
    java --module-path .\javafx-sdk-26.0.1\lib --add-modules=javafx.controls,javafx.fxml %className%
)

pause