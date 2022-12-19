/*
    Programa para a visualizacao de como funciona o acesso a arquivos em um sistema operacional
    Aqui, fazemos uma abertura e copia de um arquivo para outro especificado ao rodar o programa.
*/

#include <sys/types.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdbool.h>

int main(int argc, char *argv[]);

#define BUF_SIZE 4066
#define OUTPUT_MODE 700

int main(int argc, char *argv[]){
    int in_fd, out_fd, rd_count, wt_count;
    char buffer[BUF_SIZE];

    /*Abrindo o arquivo de entrada*/
    in_fd = open(argv[1], O_RDONLY);
    if(in_fd < 0) 
        exit(2);

    /*Criando o arquivo de copia*/
    out_fd = creat(argv[2], OUTPUT_MODE);
    if(out_fd < 0)
        exit(3);
    
    /*Fazendo a copia propriamente dita*/
    while(true){
        rd_count = read(in_fd, buffer, BUF_SIZE);
        if(rd_count <= 0)
            break;
        wt_count = write(out_fd, buffer, rd_count);
        if(wt_count <= 0)
            exit(4);
    }

    /*Fechamento do arquivo*/
    close(in_fd);
    close(out_fd);
    if(rd_count == 0)
        exit(0);
    else
        exit(5);
}
