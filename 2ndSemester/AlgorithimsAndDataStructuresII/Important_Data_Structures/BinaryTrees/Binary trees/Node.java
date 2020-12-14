class Node{
	int elemento;
	Node esq;
	Node dir;

	//construtor base com elemento
	Node(int elemento){
		this(elemento, null, null);
	}
	//construtor base com elemento e nos
	Node(int elemento, Node esq, Node dir){
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}

}


						    /*
							   1 Node 
							   	  *
							    /   \
							
							*/