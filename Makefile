# Makefile para ListaSequencial

JAVAC=javac
JAVA=java
SRC=Program.java ListaSequencial.java
CLASSES=Program.class ListaSequencial.class

all: compilar

compilar:
	$(JAVAC) $(SRC)

run: compilar
	$(JAVA) Program

clean:
	rm -f *.class
