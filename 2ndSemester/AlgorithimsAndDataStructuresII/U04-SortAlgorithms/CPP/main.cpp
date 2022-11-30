#include <iostream>
#include "mergesort.hpp"

using namespace std;

void popula_array(int arr[], int n);


int main(){
  int n = 10;
  int values[n];
  popula_array(values, n);
  mostra_array(values, n);
  mergesort(values, n);
  mostra_array(values, n);

  return 0;
}

void popula_array(int arr[], int n){
  for(int i = 0; i < n; i++){
    arr[i] = n - i;
  }
}