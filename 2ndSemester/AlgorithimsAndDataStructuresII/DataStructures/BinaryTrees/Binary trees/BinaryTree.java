class BinaryTree{
	Node raiz;
	//construtor
	BinaryTree(){
		raiz = null;
	}
	
	public void insert(int elemento)throws Exception{
		insert(raiz, elemento);
	}

	//metodo de insercao
	public Node insert(Node n, int elemento)throws Exception{
		if(n == null){
			n = new Node(elemento);
		}

		else if(elemento < n.elemento){
			n.esq = insert(n.esq, elemento);
		}
		
		else if(elemento > n.elemento){
			n.esq = insert(n.dir, elemento);
		}
		else{
			throw new Exception("Erro de insercao");
		}
		return n;
	}

	//metodo de insercao com passagem pelo pai
	public void insertByFather(int elemento, Node n)throws Exception{
		if(n == null){
			raiz = new Node(elemento);		
		}

		else if(elemento < raiz.elemento){
			insertByFather(raiz.esq, elemento, raiz);
		}
		
		else if(elemento > raiz.elemento){
			insertByFather(raiz.dir, elemento, raiz);
		}
		else{
			throw new Exception("Erro de insercao");
		}
	}

	public void insertByFather(Node n, int elemento,  Node pai)throws Exception{
		if(n == null){
			if(elemento < pai.elemento){
				pai.esq = new Node(elemento);
			}
			else {
				pai.dir = new Node(elemento);
			}
		}
		else if(elemento < n.elemento){
			insertByFather(n.esq, elemento,  n);
		}
		else if(elemento > n.elemento){
			insertByFather(n.dir, elemento,  n);
		}
		else{
			throw new Exception("Erro de insercao");
		}
	}
	public boolean search(int procurado){
		return search(procurado, raiz);
	}
	public boolean search(int procurado, Node n){
		boolean encontrou;
		if(n == null){
			encontrou = false;
		}
		else if(n.elemento == procurado){
			encontrou = true;
		}
		else if(n.elemento > procurado){
			encontrou = search(procurado, n.esq);
		}
		else{
			encontrou = search(procurado, n.dir);
		}
		return encontrou;
	}
	//metodos de caminhamento pela arvore
	public void walkCenter(Node n){
		if(n != null){
			walkCenter(n.esq);
			System.out.println(n.elemento + " ");
			walkCenter(n.dir);
		}
	}
	public void walkFirst(Node n){
		if(n != null){
			walkFirst(n.esq);
			walkFirst(n.dir);
			System.out.println(n.elemento + " ");
		}
	}
	public void walkAfter(Node n){
		if(n != null){
			System.out.println(n.elemento + " ");
			walkAfter(n.esq);
			walkAfter(n.dir);
		}
	}

}


