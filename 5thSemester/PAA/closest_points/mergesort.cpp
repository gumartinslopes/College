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

}

void mergesort_rec(Ponto arr[], int esq, int dir, bool ordenado_por_x){
    //caso recursivo
    if(esq <  dir){

    }
}

void mergesort(Ponto arr[], int n, bool ordenado_por_x){
    mergesort_rec(arr, 0, n - 1,ordenado_por_x);
}
