# Comandos no Vim

## Modos
- *esc* -> nenhum modo escolhido.
- *i* -> inserção de caracteres.
- *v* -> modo visual, seleciona coisas.

## Movimentação
1. *G* -_> Nos leva ao fim do texto.
2. *gg*-> Nos leva de volta ao inicio.
3. *{* -> Caminha blocos de texto (ou código) acima.
4. *}* -> Caminha blocos de texto (ou código) abaixo.
5. *o*  -> Adiciona uma linha e entra no modo de inserção.
6. *h j k l* -> Fazem o trabalho das teclas de seta respetivamente esquerda, cima, baixo direita.
7. *\* * -> Encontra todas as instâncias da palavra que o cursor aponta.
## Movimentação Horizontal
1. *w* -> Avança para a primeira letra próxima palavra na linha.
2. *b* -> Retorna para  primeira letra da palavra anterior.
3. *0* -> Volta para o inicio da linha.
4. *f + caractere*-> Avança para a próxima ocorrência do caractere que escolhermos.
5. *t + caractere*-> Avança para a o caractere anterior ao caractere que escolhemos.

## Manipulação de texto
1. *dd* -> Deleta uma linha, podemos prefixar valores que correspondem ao número de linhas deletadas.
2. *d* + movimentação -> Deleta a linha atual e a linha na qual o cursor aponta.
3. *D* -> Deleta o que estiver a frente do cursor na linha.
4. *u* -> Desfaz ações(undo).
5. *Ctrl + r*-> Refaz ações(re do).
6. *c + w* ->Deleta a palavra e entra no modo de escrita(Change Word).
