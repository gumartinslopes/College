/* C implementation QuickSort from  http://w...content-available-to-author-only...s.org/quick-sort/ */

/*
  Sequencial: 2.401 segundos
  Paralelo: 1.863 segundos
  Speedup Obtido: 1,28878
  Quantidade de núcleos: 2
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<omp.h>
 
// A utility function to swap two elements
void swap(int* a, int* b)
{
  int t = *a;
  *a = *b;
  *b = t;
}
 
/* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
int partition (int arr[], int low, int high)
{
  int pivot = arr[high];    // pivot
  int i = (low - 1);  // Index of smaller element
 
  //#pragma omp parallel for reduction(+:i)
  for (int j = low; j <= high- 1; j++) 
    {
      // If current element is smaller than or
      // equal to pivot
      if (arr[j] <= pivot)
        {
          i++;    // increment index of smaller element
          swap(&arr[i], &arr[j]);
        }
    }
  swap(&arr[i + 1], &arr[high]);
  return (i + 1);
}
 
/* The main function that implements QuickSort
 arr[] --> Array to be sorted,
  low  --> Starting index,
  high  --> Ending index */
void quickSort(int arr[], int low, int high)
{
  if (low < high)
    {
      /* pi is partitioning index, arr[p] is now
	 at right place */
      int pi = partition(arr, low, high);
 
      // Separately sort elements before
      // partition and after partition
      if((high - low) < 1000000)
      {
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
      }
      else{
        #pragma omp parallel sections
        {
          #pragma omp section
          quickSort(arr, low, pi - 1);
          #pragma omp section
          quickSort(arr, pi + 1, high);
        }
      }
    }
}

// Verificação de correção
bool is_sorted(int arr[], int size){
    for(int i = 0; i < size - 1; i++)
        if(i > i + 1)
            return false;
    return true;
}

/* Function to print an array */
void printArray(int arr[], int size)
{
  int i;
  for (i=0; i < size; i++)
    printf("%d ", arr[i]);
  printf("\n");
}

// Driver program to test above functions
int main()
{
  //setando número de threads para 2
  omp_set_num_threads(2);
  int i,n = 10000000;
  int *arr = (int*) malloc(n*sizeof(int));

  for(i=0; i < n; i++)
    arr[i] = rand()%n;

  quickSort(arr, 0, n-1);
  printArray(arr, n);
  //printf("Sorted array: %s\n", (is_sorted(arr, n)?"yes":"no"));
  return 0;
}