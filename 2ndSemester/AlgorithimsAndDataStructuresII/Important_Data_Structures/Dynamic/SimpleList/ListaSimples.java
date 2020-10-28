class ListaSimples {
	private Celula primeiro, ultimo;
	public ListaSimples(){
		primeiro = new Celula();
		ultimo = primeiro;
	}

	//---------metodos de  insercao--------------
	public void inserirInicio(int x){
		Celula aux = new Celula(x);
		aux.prox = primeiro.prox;
		primeiro.prox = aux;
		if(primeiro == ultimo){
			ultimo = aux;
		}
		aux = null;
		System.out.println(x + " foi inserido no inicio da sua lista");
	}
	public void inserirFim(int x){
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;	
		System.out.println(x + " entrou na lista\n");
	}
	//---------metodos de remocao--------------
	public int removerFim()throws Exception{
		if(primeiro == ultimo)
			throw new Exception("ERRO");
		Celula i;
		for(i = primeiro; i.prox!= ultimo; i = i.prox);
		int elemento = ultimo.elemento;
		ultimo = i;
		i = ultimo.prox = null;
		return elemento;
	}
	public int removerInicio()throws Exception{
		if(primeiro == ultimo) 
			throw new Exception("Erro, o primeiro é igual ao último");
		Celula aux = primeiro;
		primeiro = primeiro.prox;	//avançamos o primeiro em uma Celula
		int removido = primeiro.elemento;
		aux.prox = null;
		aux = null;	//nullificamos a aux pois não vamos utiliza-la novamente
		System.out.println(removido + " saiu da lista\n");
		System.out.println(removido + " foi removido");
		return removido;
	}
	public int remover(int pos)throws Exception {
		int removido, tamanho = getTamanho();
		if(primeiro  == ultimo || pos < 0 || pos >= tamanho){
			throw new Exception("ERRO");
		}
		else if(pos == 0)
			removido = removerInicio();
		else if(pos == tamanho -1)
			removido = removerFim();
		else{
			Celula i = primeiro;
			for(int j = 0; j < pos; j++, i = i.prox);
			Celula aux = i.prox;
			removido = aux.elemento;
			i.prox = aux.prox;
			aux.prox = null;
			i = aux = null;
		}
		System.out.println(removido + " foi removido");
		return removido;
	}
	public int removerSegunda(){
		System.out.println(primeiro.prox.elemento);
		Celula aux = primeiro.prox.prox;	
		primeiro.prox.prox = null;
		primeiro.prox.prox = aux.prox;
		int removido = aux.elemento;
		aux = null;

		return removido;
	}
	
	//---------demais metodos--------------
	public int getTamanho(){
		int tam = 1;
		for(Celula i = primeiro.prox; i != null; i = i.prox)
			tam++;
		return tam;
	}
	//metodo de insercao que depende da posicao
	public void inserir(int x, int pos)throws Exception{
		int tamanho = getTamanho();
		if(pos < 0 || pos > tamanho){
			throw new Exception("Erro");
		}
		else if(pos == 0)
			inserirInicio(pos);
		else if(pos == tamanho)
			inserirFim(x);
		else{
			Celula i = primeiro;
			for(int j = 0; j < pos; j++, i= i.prox);
			Celula aux = new Celula(x);
			aux.prox = i.prox;
			i.prox = aux;
			aux = i = null;
		}
	}
	
	public void mostrar(){
		System.out.print("Sua lista -> ");
		System.out.print("[");
		for(Celula i = primeiro.prox; i != null; i = i.prox){
			System.out.print(i.elemento +" ");
		}
		System.out.print("]\n");
	}

}
