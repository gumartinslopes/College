//implementação da classe nó em java
class Node{
	int element;
	Node left;//filho à leftuerda
	Node right;//filho à righteita
	
	//construtores
	Node(int element){
		this(element, null, null);
	}
	
	Node(int element, Node left, Node right){
		this.element = element;
		this.left = left;
		this.right = right;
	}
}
