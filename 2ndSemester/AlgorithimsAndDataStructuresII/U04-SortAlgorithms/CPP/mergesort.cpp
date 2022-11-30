#include "mergesort.hpp"
#include <iostream>

void mergesort(int arr[], int n){
    mergesort_rec(arr, 0, n);
}

void mergesort_rec(int arr[],int begin, int end){
    if(begin < end){
        int mid = (begin + end)/2;
        mergesort_rec(arr, begin, mid);
        mergesort_rec(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }
}

void mostra_array(int arr[], int n){
    std::cout << "[";
    for(int i = 0; i < n - 1; i++){
        std::cout << arr[i] << ", ";
    }
    std::cout<< arr[n - 1];
    std::cout << "]" << std::endl;
}

void merge(int arr[], int begin, int mid, int end){
    int n_left = (mid + 1) - begin;
    int n_right = end - mid;

    int* left = new int[n_left + 1]; 
    int* right = new int[n_right + 1];
    int left_index, right_index, index;
    
    right[n_right] = left[n_left] = 2147483647;
    
    for(left_index = 0; left_index < n_left; left_index++)
        left[left_index] = arr[begin + left_index];
    
    for (right_index = 0; right_index < n_right; right_index++)
        right[right_index] = arr[(mid+ 1) + right_index];

    //Intercalacao propriamente dita
    for (left_index = right_index = 0, index = begin; index <= end; index++){
        arr[index] = (left[left_index] <= right[right_index]) ? left[left_index++] : right[right_index++];
}
    delete[] left; 
    delete[] right; 
}