class Fila{
	private Celula primeiro, ultimo;
	public Fila(){
		primeiro = new Celula();
		ultimo = primeiro;
	}
	//metodo de inserir
	public void enfileirar(int x){
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;	
		System.out.println(x + " entrou na fila\n");
	}
	//método de remover
	public int desenfileirar()throws Exception{
		if(primeiro == ultimo) 
			throw new Exception("Erro, o primeiro é igual ao último");
		Celula aux = primeiro;
		primeiro = primeiro.prox;	//avançamos o primeiro em uma Celula
		int removido = primeiro.elemento;
		aux.prox = null;
		aux = null;	//nullificamos a aux pois não vamos utiliza-la novamente
		System.out.println(removido + " saiu da fila\n");
		return removido;
	}
	public int getMaior(){
		int maior = 0;
		for(Celula i = primeiro.prox; i !=null;i = i.prox){
			if(i.elemento > maior)
				maior =i.elemento;
		}
		return maior;
	}
	public int getSoma(){
		int resultado = 0;
		for(Celula i = primeiro.prox; i != null; i = i.prox){
			resultado += i.elemento;
		}
		return resultado;
	}
	public void inverte(){
		Celula fim = ultimo;
		while(primeiro != fim){
			Celula nova = new Celula(primeiro.prox.elemento);
			nova.prox = fim.prox;
			fim.prox = nova;
			Celula aux = primeiro.prox;
			primeiro.prox = aux.prox;
			nova = aux = aux.prox = null;
			if(ultimo == fim){
				ultimo = ultimo.prox;
			}
		fim  = null;
		}
	}
	public void mostrar(){
		System.out.print("Sua fila -> ");
		System.out.print("[");
		for(Celula i = primeiro.prox; i != null; i = i.prox){
			System.out.print(i.elemento +" ");
		}
		System.out.print("]\n");
	}
	public void mostrarTerceiroElemento(){
		if(primeiro.prox.prox.prox != null)
		    System.out.println((primeiro.prox.prox.prox.elemento));

		else
		    System.out.println("Terceiro valor não existente");
	}
	public int contar(){
		return contar(primeiro.prox);
	}
	public int contar(Celula i){
		int result = 0;
		if(i == null)
			result = 0;
			//pares && multiplos de 5
		else if(i.elemento % 2 == 0 && i.elemento % 5 == 0)
			result =  1  + contar(i.prox);
		else{
			result = contar(i.prox);
		}
		return result;  
	}
	//                                   ?
	public void metodoDoidao(){
		Celula fim = ultimo;
		while(primeiro != fim){
			System.out.println("Laço \n");
			ultimo.prox = new Celula(primeiro.prox.elemento);
			System.out.println("ultimo.prox->"+ ultimo.prox.elemento);
			Celula tmp = primeiro;
			System.out.println("tmp->" + tmp.elemento);
			primeiro = primeiro.prox;
			System.out.println("primeiro->" + primeiro.elemento);
			tmp = tmp.prox = null;
			ultimo = ultimo.prox;
			System.out.println("ultimo->" + ultimo.elemento);
		}
		fim = null;
	}


}
