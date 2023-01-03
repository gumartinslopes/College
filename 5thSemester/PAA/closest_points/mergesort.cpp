#include "mergesort.hpp"

int compare_x(const void* a, const void *b){
    Ponto *p1 = (Ponto *)a, *p2 = (Ponto *)b;
    return (p1->x - p2->x); 
}

int compare_y(const void* a, const void *b){
    Ponto *p1 = (Ponto *)a, *p2 = (Ponto *)b;
    return (p1->y - p2->y); 
}


void merge(Ponto arr[], int esq, int meio, int dir, bool ordenado_por_x){
    int n_esq = (meio + 1) - esq;
    int n_dir = dir - meio;
    
    Ponto* arr_esq = new Ponto[n_esq + 1]; 
    Ponto* arr_dir = new Ponto[n_dir + 1];

    //ultimo elemento como flag
    arr_esq[n_esq].x = arr_dir[n_dir].x = 2147483647;
    arr_esq[n_esq].y = arr_dir[n_dir].y = 2147483647;
    
    int i_esq, i_dir, i;
    
    //inicializa esquerda
    for(i_esq = 0; i_esq < n_esq; i_esq++)
        arr_esq[i_esq] = arr[esq + i_esq]; 
    
    //inicializa direita
    for(i_dir = 0; i_dir < n_dir; i_dir++)
        arr_dir[i_dir] = arr[(meio + 1) + i_dir]; 
    

    //faz o merge
    for(i_esq = i_dir = 0, i = esq; i <= dir; i++){
        if(ordenado_por_x)
            arr[i] = (arr_esq[i_esq].x <= arr_dir[i_dir].x)?arr[i] = arr_esq[i_esq++] : arr[i] = arr_dir[i_dir++];
        else
            arr[i] = (arr_esq[i_esq].y <= arr_dir[i_dir].y)?arr[i] = arr_esq[i_esq++] : arr[i] = arr_dir[i_dir++];
    }
    delete[] arr_esq;
    delete[] arr_dir;
}

void mergesort_rec(Ponto arr[], int esq, int dir, bool ordenado_por_x){
    //caso recursivo
    if(esq <  dir){
        int meio = (esq + dir) / 2;
        mergesort_rec(arr, esq, meio, ordenado_por_x);
        mergesort_rec(arr, meio + 1, dir, ordenado_por_x);
        merge(arr, esq, meio, dir, ordenado_por_x);
    }
}

void mergesort(Ponto arr[], int n, bool ordenado_por_x){
    mergesort_rec(arr, 0, n - 1, ordenado_por_x);
}
