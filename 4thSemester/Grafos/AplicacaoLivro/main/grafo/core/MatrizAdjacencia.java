import java.util.*;
public class MatrizAdjacencia{
    private int[][]matriz;
    private List<Vertice> vertices;
    private int qtdVertices;
    
    // so é possivel criar a matriz se existirem vertices no grafo
    public MatrizAdjacencia(List<Vertice> vertices){
        this.vertices = vertices;
        this.qtdVertices = vertices.size();
        matriz = new int[qtdVertices][qtdVertices];
        initMatriz();
    }

    public void initMatriz(){
        for(int i = 0; i < matriz.length; i++)
                  for(int j = 0; j < matriz[i].length; j++)
                    matriz[i][j] = 0;   
    }

    public void mostraMatriz(){
        for(int i = 0;i < matriz.length; i++)
            for(int j = 0; j < matriz[i].length;j++)
                System.out.println(" " + matriz[i][j] + " ");
    }

    public void addAresta(int indiceInicial, int indiceFinal){
        Vertice vInicial = vertices.get(indiceInicial);
        Vertice vFinal = vertices.get(indiceFinal);
        if(indiceInicial != indiceFinal){
            matriz[indiceInicial][indiceFinal] = 1; //marca 1 na matriz
            matriz[indiceFinal][indiceInicial] = 1; 
            vInicial.addGrau();
            vFinal.addGrau();
        }
        //caso de loop
        else{
            matriz[indiceInicial][indiceFinal] = 1;
            vInicial.addGrau();
        }
    }
    
    public List<Vertice>getAdjacencias(int indiceVertice){
        List<Vertice>adjacencias = new ArrayList<Vertice>();
        for(int j = 0; j < matriz[indiceVertice].length; j++){
            if(matriz[indiceVertice][j] == 1)
                adjacencias.add(vertices.get(j));
        }
        return adjacencias;
    }
}