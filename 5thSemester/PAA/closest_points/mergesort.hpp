#include "ponto.hpp"

void merge(Ponto arr[], int esq, int meio, int dir, bool ordenado_por_x);
void mergesort_rec(Ponto arr[], int esq, int dir, bool ordenado_por_x);
void mergesort(Ponto arr[], int n, bool ordenado_por_x);
int compare_x(const void* a, const void *b);
int compare_y(const void* a, const void *b);