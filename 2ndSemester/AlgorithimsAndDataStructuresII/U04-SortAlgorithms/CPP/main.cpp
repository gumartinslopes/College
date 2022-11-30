#include <iostream>
#include "mergesort.hpp"

using namespace std;

void popula_array(int arr[], int n);
void show_array(int arr[], int n);


int main(){
  int n = 10;
  int values[n];
  popula_array(values, n);
  show_array(values, n);
  mergesort(values, n);
  show_array(values, n);

  return 0;
}

void popula_array(int arr[], int n){
  for(int i = 0; i < n; i++){
    arr[i] = n - i;
  }
}

void show_array(int arr[], int n){
    std::cout << "[";
    for(int i = 0; i < n - 1; i++){
        std::cout << arr[i] << ", ";
    }
    std::cout<< arr[n - 1];
    std::cout << "]" << std::endl;
}