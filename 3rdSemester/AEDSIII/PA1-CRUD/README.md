# ☕Desafio individual 1 - CRUD Genérico
O primeiro projeto de desafio individual da matéria foi a criação de um C.R.U.D(Create, Read, Update, Delete) utilizando a linguagem java com arquivos.db para o armazenamento de livros como tipos genéricos.

Para testar os métodos delete e update basta descomentar uma das duas linhas comentadas abaixo no arquivo `Main.java` note que os testes de ``create`` e ``read`` já estão descomentados para o funcionamento dos demais testes.
```
testCreate(arqLivros);
//testUpdate(arqLivros); //descomente para testar
//testDelete(arqLivros);
```




### ToDo List feita ao longo do projeto
- [x]  Classe Livro.
- [x]  Classe Cliente.
- [x]  Classe Arquivo C.R.U.D.
    - [x]  Construtor( )
    - [x]  Create( )
    - [x]  Read( )
    - [x]  Update( )
    - [x]  Delete( )
- [x]  Implementação de testes Básicos
    - [x]  Create( )
    - [x]  Read( )
    - [x]  Update( )
    - [x]  Delete( )
- [x]  Interface Registro.
- [x]  Estudar `tipos genéricos e collections em java`.
- [x]  Estudar classe `RandomAccessFile`
- [x]  Refatorações
    - [x]  Metódo search(procura registros).
    - [x]  Método record (encapsulamento da gravação em arquivo do registro)
 - **Nota**:
Um registro possui na ordem os campos `lápide`, `indicador de tamanho` e `vetor de bytes`.