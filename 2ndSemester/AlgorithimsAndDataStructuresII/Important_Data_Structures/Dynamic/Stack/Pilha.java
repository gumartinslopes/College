class Pilha{
	private Celula topo;
	public Pilha(){
		topo = null;
	}
	public void inserir(int x) {
		Celula aux = new Celula(x);
		aux.prox = topo;
		topo = aux;
		aux = null;	//aux aponta para null pois não vamos usá-la denovo
		System.out.println(x + " foi empilhado");
	}
	public int remover() throws Exception{
		int elemento = topo.elemento;
		Celula aux = topo;
		
		System.out.println(aux.elemento + " foi removido");
		topo = topo.prox;
		aux.prox = null;
		aux = null;
		return elemento;
	}
	public void mostrar(){
		System.out.print("Sua pilha -> ");
		System.out.print("[");
		for(Celula i = topo; i != null; i=i.prox){
			System.out.print(i.elemento + " ");
		}
		System.out.println("]");
	}
	public int getSoma(){		//função auxiliar de recursão
		return getSoma(0, topo);
	}	
	public int getSoma(int soma, Celula i){
		if(i != null){
		    soma += i.elemento;		    
		    System.out.println("Somou " + i.elemento);
		    soma = getSoma(soma, i.prox);
		}
		return soma;
	}
	public int getMaior(){
		return getMaior(0, topo);
	}
	public int getMaior(int maior, Celula i){
		if(i != null){
		    if(i.elemento > maior)
	                maior = i.elemento;
	
		maior = getMaior(maior, i.prox);
		}

		return maior;
	}
	public void mostraInsercao(){
		Pilha aux = new Pilha();		//criamos uma pilha auxiliar que armazena invertido	
		Celula i = topo;
		insereInvertido(aux,i);
		aux.mostraRemocao();			//mostramos por fim a pilha auxiliar
		aux = null;		
	}
	public void insereInvertido(Pilha aux, Celula i){
		if(i != null){
			aux.inserir(i.elemento);
			insereInvertido(aux, i.prox);
		}
	}
	public void mostraRemocao(){	//método base para getRemocao()
		 int contador = 1;
		 mostraRemocao(topo, contador);
	}
	public void mostraRemocao(Celula i, int contador){
		if(i != null){
			System.out.println(contador + " -> " + i.elemento + ", ");
			mostraRemocao(i.prox, ++contador);
		}
	}
	public Celula toFila(){
		return toFila(topo);
	}
	public Celula toFila(Celula topo){
		//criamos o no cabeca 
		Celula cabeca = new Celula(7);
		Pilha fila = new Pilha();
		fila.inserir(cabeca.elemento);
		Celula i = topo;
		insereInvertido(fila,i);
		fila.mostrar();
		return cabeca;
	}
}
