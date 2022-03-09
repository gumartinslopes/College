# Busca em profundidade
### Notas
 - Branco: representa que o vértice ainda não foi visitado.
 - Vermelho: representa que o vértice está na pilha de visitas(ou estamos nele ou em algum filho).
 - Preto: representa que o vértice e seus filhos já foram visitados e não estão mais na pilha.
### Pseudocódigo
```
grafo = [va, vb, vc, vd, ve, vf, vg]
/*Aqui é onde o algoritmo começa*/
setup(){
	inicializaGrafo(grafo); 
	contagemTempo = 0;
	for(vertice em grafo)
		if(vertice.cor == "Branco")
		visitaRecursivo(vertice)
	
}

/*Aqui é onde colocamos o grafo todo como branco*/
inicializaGrafo(Grafo grafo){
	for(vertice em gravo)
		vertice.cor = "Branco";
}

visitaRecursivo(Vertice vertice){
	vertice.cor = "Vermelho"
	contagemTempo++;
	vertice.tempoInicio = contagemTempo;
	for(filho em vertice.filhos)
		if(filho)
	vertice.tempoFim= contagemTempo;
}

```