import java.util.ArrayList;
import java.util.*;
public class Grafo{
	private int qtdMaxVertices;
	private boolean isQtdMaxDefinida = false;
	private int qtdAtualVertices;
	private Map<String, Integer> rotulosIndexados = new HashMap<String, Integer>();
	private List<Vertice> vertices = new ArrayList<Vertice>();
	private MatrizAdjacencia matrizAdjacencia;

	public Grafo()throws Exception{
		this(10);
	}

	public Grafo(int qtdVertices)throws Exception{
		if(qtdVertices <= 0)
			throw new Exception("Quantidade máxima insuficiente! Ovalor deve ser maior ou igual a 0");
		this.qtdMaxVertices = qtdVertices;
		this.isQtdMaxDefinida = true;
	}

	public void mostraGrafo(){
		for(Vertice vertice:vertices)
			System.out.println(" - Vertice " + vertice.getRotulo());
	}
	
	public void adicionaVertice(String rotulo)throws Exception{
		if(qtdAtualVertices == qtdMaxVertices){
			throw new Exception("A quantidade de vértices permitida (" + qtdMaxVertices + ") já foi excedida");
		}
		
		Vertice novoVertice = new Vertice(rotulo);
		this.rotulosIndexados.put(rotulo, qtdAtualVertices);
		this.vertices.add(novoVertice);
		qtdAtualVertices++;
	}

	public List<Vertice>getTodosVertices(){
		return this.vertices;
	}
	
	public Vertice getVertice(String rotulo)throws Exception{
		if(!existeVertice(rotulo))
			throw new Exception("Vertice nao existente");
		int indice = rotulosIndexados.get(rotulo);
		return this.vertices.get(indice);
	} 

	public List<Vertice> getAdjacencias(String rotulo)throws Exception{
		if(!existeVertice(rotulo))
			throw new Exception("Vertice nao existente");
		int indice = rotulosIndexados.get(rotulo);
		return matrizAdjacencia.getAdjacencias(indice);
	}

	//faz um update na lista de adjacencia
	public void conectarVertices(String rotuloInicial, String rotuloFinal)throws Exception{		
		if(!existeVertice(rotuloInicial) ||  !existeVertice(rotuloFinal)){
			throw new Exception("Um dos vertices nao existe");	
		}
		int indiceInicial = rotulosIndexados.get(rotuloInicial);
		int indiceFinal = rotulosIndexados.get(rotuloFinal);
		existeMatriz();
		matrizAdjacencia.addAresta(indiceInicial, indiceFinal);
	} 

	public void existeMatriz(){
		if(matrizAdjacencia == null)
			this.matrizAdjacencia = new MatrizAdjacencia(vertices);
	}

	public boolean existeVertice(String rotulo){
		int indice = rotulosIndexados.get(rotulo);
		return vertices.get(indice) != null;
	}
}