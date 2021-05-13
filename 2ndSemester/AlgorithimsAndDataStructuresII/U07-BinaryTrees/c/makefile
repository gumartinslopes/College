all: exec

exec: main.o binarytree.o node.o
	gcc -o exec main.o binarytree.o node.o

main.o: main.c
	gcc -o main.o main.c -c -W -Wall -ansi -pedantic

binarytree.o: binarytree.c
	gcc -o binarytree.o binarytree.c -c -W -Wall -ansi -pedantic

node.o: node.c
	gcc -o node.o node.c -c -W -Wall -ansi -pedantic

clean:
	rm -rf *.o *~exec
