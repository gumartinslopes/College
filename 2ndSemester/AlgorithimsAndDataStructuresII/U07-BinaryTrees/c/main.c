#include <stdio.h>
#include "binarytree.h"

int main(){
 start();
 insert(2);
 insert(3);
 insert(1);
 insert(4);
 insert(107);
 displayCentral();
 removeNode(4);
 displayCentral();
  return 0;
}
