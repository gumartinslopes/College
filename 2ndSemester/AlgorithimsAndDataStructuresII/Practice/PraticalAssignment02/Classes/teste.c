#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define LINESIZE 10
int main(){
  char str[LINESIZE];
  strcpy(str, "abcAAdef");
  twoCharReplace(str, "AA", "##");
  printf("%s",str);
}
