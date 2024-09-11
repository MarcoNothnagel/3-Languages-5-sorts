@echo off

cd C:\Users\Marco\OneDrive\BSc IT\Y3B3\python\
g++ -o sorting sorting.cpp
.\sorting.exe

cd C:\Users\Marco\OneDrive\BSc IT\Y3B3\python\
del *.class
javac sorting.java
java sorting

"C:\Users\Marco\AppData\Local\Programs\Python\Python39\python.exe" "C:\Users\Marco\OneDrive\BSc IT\Y3B3\python\sorting.py"

START "" "C:/Users/Marco/OneDrive/BSc IT/Y3B3/python/export.xlsx"

EXIT /b