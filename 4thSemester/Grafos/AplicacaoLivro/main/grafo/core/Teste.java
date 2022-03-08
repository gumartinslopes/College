import java.util.*;
public class Teste{
	public static void main(String[] args){
		try{
			Grafo grafo1 = new Grafo();
			String []rotulos = {"A","B","C","D","E"};
			String []conexoes = {"A-B","A-E","A-C","C-D","D-E"};
			addVertices(rotulos, grafo1);
			criaConexoes(conexoes, grafo1);
			grafo1.mostraGrafo();
			mostraGraus(grafo1);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
	}

	public static void addVertices(String[] rotulos, Grafo grafo)throws Exception{
		for(int i = 0; i < rotulos.length; i++)
			grafo.adicionaVertice(rotulos[i]);
	}

	public static void criaConexoes(String[] conexoes, Grafo grafo)throws Exception{
		for(int i = 0; i < conexoes.length; i++){
			String []rotulos = conexoes[i].split("-");		
			grafo.conectarVertices(rotulos[0], rotulos[1]);
		}
	}
	
	public static void mostraGraus(Grafo grafo)throws Exception{
		System.out.println("O vertice A possui estas adjacencias:");
		List<Vertice> adjacentes = grafo.getAdjacencias("A");
		for(Vertice v:adjacentes)
			System.out.println(v.getRotulo() + " ");
	}
}