//implementação da árvore binária de pesquisa em java

class BinaryTree{
	//criamos o nó raíz
	Node root;
	//construtor
	public BinaryTree(){
		root = null;
	}
	//metodo base para inserção
	public void insert(int x) throws Exception{
		root  = insert(x, root);
		System.out.println("The element " + x + " has been inserted");
	}
	//metodo de insercao em si
	public Node insert(int x, Node n) throws Exception{
		if(n == null){
			n = new Node(x);
		}
		
		else if(x < n.element){
			n.left = insert(x, n.left);
		}
		
		else if(x > n.element){
			n.right = insert(x, n.right);
		}
		
		else{
			throw new Exception("Tree error, same element");
		}
		//retornamos o no inserido 
		return n;
	}
	public void insertByFather(int x)throws Exception{
		if(root == null){
			root  = new Node(x);
		}
		else if(x < root.element){
			insertByFather(x, root.left, root);
		}
		else if(x > root.element){
			insertByFather(x, root.right, root);
		}
		else{
			throw new Exception("Tree error, same element");
		}
		System.out.println("The element " +  x + " has been inserted");
	}

	public void insertByFather(int x, Node n, Node father) throws Exception{
		if(n == null){
			if(x < father.element){
				if(x < father.element){
					father.left = new Node(x);
				}
				else{
					father.right = new Node(x);
				}
			}
		}
		else if(x < n.element){
				insertByFather(x, n.left, n);
		}
		else if(x > n.element){
				insertByFather(x, n.right, n);
		}
		else {
			throw new Exception("Tree error, same element");
		}
	}
	public boolean search(int x, Node n){
		boolean found = false;
		if(n == null){
			found = false;
		}
		else if(x == n.element){
			found = true;
		}
		else if(x < n.element){
			found = search(x,n.left);
		}
		else{
			found = search(x,n.right);
		}
		return found;
	}

	//3 formas diferentes para se printar toda a Binary Tree
	public void walkCenter(Node n){
		if(n != null){
			walkCenter(n.left);
			System.out.println(n.element + " ");
			walkCenter(n.right);
		}
	}
	public void walkFirst(Node n){
		if(n != null){
			walkFirst(n.left);
			walkFirst(n.right);
			System.out.println(n.element + " ");
		}
	}
	public void walkAfter(Node n){
		if(n != null){
			System.out.println(n.element + " ");
			walkAfter(n.left);
			walkAfter(n.right);
		}
	}
	public void remove(int x)throws Exception{
		root = remove(x, root);
	}

	public Node remove(int x, Node n)throws Exception{
		if(n == null){
			throw new Exception("The element is not present in your tree");
		}
		else if(x < n.element){
			n.left = remove(x, n.left);
		}
		else if(x > n.element){
			n.right = remove(x, n.right);
		}
		else if(n.right == null){
			n = n.left;
		}
		else if(n.left == null){
			n = n.right;
		}
		else{
			n.left = previous(n, n.left); 
		}
		return n;
	}
	//in case of 2 sons
	public Node previous(Node i, Node j){
		if(j.right != null){
			j.right = previous(i, j.right);
		}
		else{
			i.element = j.element;
			j = j.left;
		}
		return j;
	}
	public int sumOfTree(Node n){
		int sum = 0;
		if(n != null)
			sum = n.element + sumOfTree(n.left) + sumOfTree(n.right);
		return sum;
	}
	public int countEven(Node n){
		int counter = 0;
		if(n != null){
			counter = (n.element % 2 == 0) ? ++counter :counter;
			counter += countEven(n.left) + countEven(n.right);
		}
		return counter;
	}
  //--------Metodos de balanceamento-------
  
  public Node rotateLeft(Node n){
    Node nRight = n.right;
    Node nRightLeft = nRight.left;

    nRight.left = n;
    nRight = nRightLeft;

    return nRight;
  }

  public Node rotateRight(Node n){
    Node nLeft = n.left;
    Node nLeftRight = nLeft.right;

    nLeft.right = n;
    nLeft = nLeftRight;

    return nLeft;
  }

  public Node rotateLeftRight(Node n){
    n.left = rotateLeft(n.left);
    return rotateRight(n);
  }

  public Node rotateRightLeft(){
    n.right = rotateRight(n.right);
    return rotateLeft(n);
  }
  /*
  public int getType(){
      int type;
      //arvore balanceada
      if(root.right != null && root.left != null){
        type = 0;
      }
      //arvore manca apenas para a direita ou para os dois lados
      else if(root.right != null){
        if(root.right.left == null){
          type = 1;
        }
        else {
          type = 
        }
      }
      //arvore manca para a esquerda ou para os dois lados
      else{
        if(root.left.right == null){
          type = 
        }
        else {
          type = 
        }
      }
  }
  //0 = balanceada
  //1 = manca para a esquerda
  //2 -manca para a direita
  //3 - Manca para a direita e para a esquerda  
  //4 - Manca para a esquerda e para a direita
  
  public void Balance(){
    switch getType(){
      case 0 : {
        MyIO.println("Essa é sua árvore balanceada:");
        walkFirst();
        break;
      }    
      case 1: {
        rotateRight(root);
        break;
      }
      case 2: {
        rotateLeft(root);
        break;
      }
      case 3:{
        rotateLeftRight(root);
        break;
      }
      case 4:{
        rotateRightLeft(root);
        break;
      }
    
    }
  }
  */
}

