import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;


class Jogador{
//Gustavo Martins Lopes da Costa 690773	20/10/2020
//-----------declaração de variáveis-------------
	int id;
	String nome;
	int altura;
	int peso;
	String universidade;
	int anoNascimento;
	String cidadeNascimento;
	String estadoNascimento;

//-----------construtores------------------------
	
	public Jogador(){
	
	}
	
	public Jogador(String entrada){
		String campos[] = entrada.split(",");
		this.id = Integer.parseInt(campos[0]);
		this.nome = campos[1];
		this.altura = Integer.parseInt(campos[2]);
		this.peso = Integer.parseInt(campos[3]);
		this.universidade = campos[4];
		this.anoNascimento = Integer.parseInt(campos[5]);
		if(campos.length > 6){
			this.cidadeNascimento = (campos[6].isEmpty())? "nao informado": campos[6];
			if(campos.length < 8)
				this.estadoNascimento = "nao informado";
			else
				this.estadoNascimento = campos[7];
		} else {
			this.cidadeNascimento = "nao informado";
			this.estadoNascimento = "nao informado";
		}
		
	}
//----------getters e setters---------------------
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getNome(){
		return nome;
	} 
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public int getAltura(){
		return altura;
	}
	
	public void setAltura(int altura){
		this.altura = altura;
	}
	
	public int getPeso(){
		return peso;
	}
	
	public void setPeso(int peso){
		this.peso = peso;
	}
	
	public String getUniversidade(){
		return universidade;
	
	}
	public void setUniversidade(String universidade){
		this.universidade = universidade;
	}
	
	public int getAnoNascimento(){
		return anoNascimento;
	}
	
	public void setAnoNascimento(int anoNascimento){
		this.anoNascimento = anoNascimento;
	}
	
	public String getCidadeNascimento(){
		return cidadeNascimento;
	}
	
	public void setCidadeNascimento(String cidadeNascimento){
		this.cidadeNascimento = cidadeNascimento;
	}
	
	public String getEstadoNascimento(){
		return estadoNascimento;
	}

	public void setEstadoNascimento(String estadoNascimento){
		this.estadoNascimento = estadoNascimento;
	}

//---------------------demais metodos da classe----------------------------
	public Jogador clone(){
		Jogador clonado = new Jogador();
		clonado.id = this.id;
		clonado.nome = this.nome;
		clonado.altura = this.altura;
		clonado.peso = this.peso;
		clonado.universidade = this.universidade;
		clonado.cidadeNascimento = this.cidadeNascimento;
		clonado.estadoNascimento = this.estadoNascimento;
		return clonado;
	}

	//metodo de imprimir modificado para a questao
	public void imprimir(){
		MyIO.println("[" + id +" ## " + nome + " ## " + altura + " ## " + peso + " ## " + anoNascimento + 
		" ## " + universidade + " ## " + cidadeNascimento + " ## " + estadoNascimento +"]");
	}
}
class CelulaDupla{
    public Jogador elemento;
    public CelulaDupla prox, ant; //adicionada a celula anterior
    
    public CelulaDupla(){
      this(null);
    }  

    public CelulaDupla (Jogador j){
      this.elemento = j;
      this.prox = ant =  null;
    }
}
class Lista{
  private CelulaDupla primeiro, ultimo;
  private int tam = 0;
  private int comparacoes;
  private int movimentacoes;
  private long tempoAntes;
  private long tempoDepois;
  private long tempoTotal;
  //construtor se mantem igual ao da lista unica
  public Lista(){
    primeiro = new CelulaDupla();
    ultimo = primeiro;
  }
  
  public void inserirInicio(Jogador j){
    CelulaDupla aux =  new CelulaDupla(j);
    aux.ant = primeiro;         //
    aux.prox = primeiro.prox;
    primeiro.prox = aux;

    if(primeiro == ultimo){
      ultimo= aux;
    }
    else {
      aux.prox.ant = aux;
    }

    tam++;
    aux = null;
  }

  public void inserir(Jogador j, int pos)throws Exception{
    if(pos < 0 || pos > tam){
      throw new Exception("Posicao invalida");
    }
    else if(pos == 0){
        inserirInicio(j);
    }
    else if (pos == tam){
        inserirFim(j);
    }
    else {
      CelulaDupla i = primeiro;
      //caminhamento para a posicao desejada.
      for(int k = 0; k < pos; k++, i = i.prox);

      CelulaDupla aux = new CelulaDupla(j);
      aux.ant = i;
      aux.prox = i.prox;
      aux.ant.prox = aux.prox.ant = aux;

      aux = null;
      i = null;
      
      tam++;
    }
  }
  
  //insercao do ultimo jogador
  public void inserirFim(Jogador j){
    ultimo.prox = new CelulaDupla(j);
    ultimo.prox.ant = ultimo; //modificacao da lista simples
    ultimo = ultimo.prox;
    tam++;
  }
  //remocao do primeiro jogador
  public Jogador removerInicio()throws Exception{
    if(primeiro == ultimo){
      throw new Exception("Erro de remocao");
    }
    CelulaDupla aux = primeiro.prox;
    primeiro.prox = primeiro.prox.prox;
    Jogador removido = aux.elemento;
    
    aux.prox = primeiro.ant = null;
    aux = null;
    tam--;
    return removido;
  }
  //remocao de jogador passando uma posicao
  public Jogador remover(int pos)throws Exception{
    Jogador removido = new Jogador();
    if(primeiro == ultimo || pos < 0 || pos > tam){
      throw new Exception("Erro de remocao");
    }
    else if(pos == 0){
      removido = removerInicio();
    }
    else if(pos == tam - 1){
      removido = removerFim();
    }
    else {
      CelulaDupla i = primeiro;
      CelulaDupla aux;

      //caminhando até a posicao desejada
      for(int j = 0; j < pos; j++, i = i.prox);
      i.ant.prox = i.prox;
      i.prox.ant = i.ant;
      removido = i.elemento;
      i.prox = i.ant = null;
      i = null;
    }
    tam--;
    return removido;
  } 
  //remocao do ultimo jogador
  public Jogador removerFim()throws Exception{
    if(primeiro == ultimo){
      throw new Exception("Erro de remocao");
    }
    
    Jogador removido = ultimo.elemento;

    ultimo = ultimo.ant;
    ultimo.prox.ant = null;
    ultimo.prox = null;
    

    tam--;
    return removido;
  }
  public void mostrarLista(){
    int contador = 0;
                          //pulamos o no cabeca
    for(CelulaDupla i = primeiro.prox; i != null; i=i.prox, contador++){
      i.elemento.imprimir();  
    }
  }
  //metodo que troca a jogadores
  public void swap(CelulaDupla a,CelulaDupla b) throws Exception{
    
    if((a.elemento == null) || (b.elemento == null)){
      throw new Exception("CELULA VAZIA");
    }

    Jogador aux = a.elemento;
    a.elemento = b.elemento;
    b.elemento = aux;
  }

  //metodo que retorna  a celula referente ao valor desejado
  CelulaDupla getCelula(int d){
    CelulaDupla resp = primeiro.prox;                                                                  //primeiro.prox = lista[0] 
    for(int i = 0; i < d; i++){                                                                   //ultimo = lista[tam - 1]
      resp = resp.prox;
    }  
    return resp;
  }
  

  //metodo base do quicksort
  public void ordena()throws Exception{
    tempoAntes = System.currentTimeMillis();

    ordena(0, tam-1);
    tempoDepois = System.currentTimeMillis();
    documenta();
  }
  //ordenacao pelo anoNascimento
  public void ordena(int esq, int dir) throws Exception{
      int i = esq, j = dir;
      CelulaDupla pivot = getCelula((esq + dir)/2);
      while(i <= j){
        comparacoes++;
        while(getCelula(i).elemento.estadoNascimento.compareTo(pivot.elemento.estadoNascimento) < 0){
          comparacoes++;
          i++;
        } 
        comparacoes++;
        while(getCelula(j).elemento.estadoNascimento.compareTo(pivot.elemento.estadoNascimento) > 0){
         comparacoes++;
          j--;
        }

        if(i <= j){
          swap(getCelula(i), getCelula(j));
          movimentacoes += 3;
          i++;
          j--;
        }
      }

      if(esq < j)
        ordena(esq, j);
      
      if(i < dir)
        ordena(i, dir);
  }

  //metodo que cria o arquivo de log
  void documenta()throws Exception{
      FileWriter arq = new FileWriter("690773_quicksort2.txt");
      PrintWriter gravarArq = new PrintWriter(arq);
      tempoTotal = tempoDepois - tempoAntes;
      gravarArq.printf("690773\t"  + tempoTotal + "\t" + comparacoes );
      arq.close();
  }
}

class Principal{	
	public static  Lista l = new Lista();
	//metodo que le do arquivo
	public static String ler(int id){
		String path = "arquivo.txt";//mude aqui		
		FileReader fr = null;
		BufferedReader br = null;
		boolean achou = false;
		int contador = -1;
		String linha = "[nao informado] ## nao informado ##  nao informado ## nao informado ## nao informado"+ 
		" ## nao informado ## nao informado ## nao informado ##";
		try{
		    fr = new FileReader(path);
		    br = new BufferedReader(fr);
		    while(achou == false && linha != null){
			linha = br.readLine();
			if(contador == id)
				achou = true;
			contador++;
		    }
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		finally{

			try{
				br.close();
				fr.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		return linha;
	}
	//metodo que cadastra
	public static Jogador criaJogador(String entrada){
  
		 		int id = Integer.parseInt(entrada);
			 	String linha = ler(id);
				Jogador j = new Jogador(linha);
       
        return j;
	}
	//metodo que reaproveita a insercao para fazer o cadastro
	public static void cadastra(){
		String entrada;
		boolean acabou = false;
		do{
			   entrada =  MyIO.readLine();
			   if(entrada.equals("FIM")){
			        	acabou = true;
			   } 
			   else{
            Jogador a = criaJogador(entrada);
				    l.inserirFim(a);
			    } 
		    } while(acabou == false);
	}
				
	public static void main(String[] args){
		int id;
		String entrada;
		boolean acabou = false;

		try{
		  cadastra();
      l.ordena();
     l.mostrarLista();
		}
		catch(Exception ex){
	//		System.out.println(ex.getMessage());
		  ex.printStackTrace();
    }	
	}
}
