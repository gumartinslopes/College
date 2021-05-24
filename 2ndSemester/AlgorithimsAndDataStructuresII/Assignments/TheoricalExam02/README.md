# Questão 01
Seja nossa classe Fila Flexível, faça um método R.E.C.U.R.S.I.V.O que recebe três objetos do tipo Fila
e mostra na tela a soma do primeiro elemento das três Filas, a do segundo, do terceiro e, assim, sucessivamente. 
Lembre-se que as filas podem ter tamanhos distintos.

### Resposta:
```
  //método auxiliar
  public static void printSum(Fila f1, Fila f2, Fila f3){
    printSum(f1.primeiro, f2.primeiro, f3.primeiro);
  }

  public static void printSum(Celula c1, Celula c2, Celula c3){
    if(c1 != null || c2 != null || c3 != null){
      int sum = 0;
      sum += (c1 != null)? c1.elemento : 0;
      sum += (c2 != null)? c2.elemento : 0;
      sum += (c3 != null)? c3.elemento : 0; 
      System.out.println(sum);
      printSum(validarProximo(c1), validarProximo(c2), validarProximo(c3));
    }
  } 

  //método que define a existência de uma próxima célula
  public static Celula validarProximo(Celula c){
    return ((c == null)? c : c.prox);
  }
```

# Questão 02

### Reposta:
```
//função que cria a lista duplamente encadeada
CelulaDupla* toDoubleLinkedList(Celula *topo, Celula *primeiro){
    CelulaDupla *ultimo;
    CelulaDupla *iPilha = topo, *iFila = primeiro;  
    
    //inserções intercaladas
    while(iPilha != NULL && iFila != NULL){
        inserir(iPilha.elemento);
        inserir(iFila.elemento);
        ultimo = iFila;

        iPilha = iPilha->prox;
        iFila = iFila->prox;
    }

    //inserções restantes da pilha
    while(iPilha != NULL){
    inserir(iPilha->elemento);
    ultimo = iPilha;
    iPilha = iPilha->prox;
    }

    //ou inserções restantes da fila
    while(iFila != NULL){
        inserir(iFila->elemento);
        ultimo = iFila;
        iFila = iFila->prox;
    }

    iPilha = iFila = NULL;
    return ultimo;
}
```
