#include "./header_files/mergesort.hpp"
#include <iostream>

void mergesort(Ponto arr[], int n){
    mergesort_rec(arr, 0, n);
}

void mergesort_rec(Ponto arr[], int esq, int dir){
    if(esq < dir){
        int mid = (esq + dir)/2;
        mergesort_rec(arr, esq, mid);
        mergesort_rec(arr, mid + 1, dir);
        merge(arr, esq, mid, dir);
    }
}

void merge(Ponto arr[], int esq, int mid, int dir){
    //criando duas particoes
    int n_esq = (mid + 1) - esq;
    int n_dir = dir - mid;

    Ponto* arr_esq = new Ponto[n_esq + 1];
    Ponto* arr_dir = new Ponto[n_dir + 1];

    int i_esq, i_dir, i;
    //flag para arrays de tamanhos diferentes
    arr_esq[n_esq].rotulo = arr_dir[n_dir].rotulo = "flag";
    arr_esq[n_esq].x = arr_dir[n_dir].x = 2147483647;
    arr_esq[n_esq].y = arr_dir[n_dir].y = 2147483647;

    //populando a particao da direita
    for(i_esq = 0; i_esq < n_esq; i_esq++){
        arr_esq[i_esq].rotulo = arr[esq + i_esq].rotulo;
        arr_esq[i_esq].x = arr[esq + i_esq].x;
        arr_esq[i_esq].y = arr[esq + i_esq].y;
    }

    //populando a particao da esquerda
    for(i_dir = 0; i_dir < n_dir; i_dir++){
        arr_dir[i_dir].rotulo = arr[mid + 1 + i_dir].rotulo;
        arr_dir[i_dir].x = arr[mid + 1 + i_dir].x;
        arr_dir[i_dir].y = arr[mid + 1 + i_dir].y;
    }

    //operacao de merge
    for(i_dir = i_esq = 0, i = esq; i <= dir; i++)
        if(arr_esq[i_esq].x <= arr_dir[i_dir].x){
            arr[i].rotulo = arr_esq[i_esq].rotulo;
            arr[i].x = arr_esq[i_esq].x;
            arr[i].y = arr_esq[i_esq].y;
            i_esq++;
        }
        else{
            arr[i].rotulo = arr_dir[i_dir].rotulo;
            arr[i].x = arr_dir[i_dir].x;
            arr[i].y = arr_dir[i_dir].y;
            i_dir++;
        }
    delete [] arr_esq;
    delete [] arr_dir;
}