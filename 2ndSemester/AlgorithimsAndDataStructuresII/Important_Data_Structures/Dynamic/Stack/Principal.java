class Principal{

	public static void main(String[] args){
		System.out.println("Implementando pilha flexível");

		Pilha p = new Pilha();
		p.inserir(1);
		p.inserir(2);
		p.inserir(3);
		p.inserir(4);
		p.inserir(5);

		p.mostrar();
		
	//	p.remover();
	//	p.mostrar();
	//	p.remover();

		System.out.println("\nA soma dos valores contidos na pilha é " + p.getSoma());
		System.out.println("\nO maior valor da sua pilha é " + p.getMaior());
		System.out.println("\nOrdem de remoção: " ); 
		p.mostraRemocao();
		System.out.println("\n Ordem de inserção: ");
		p.mostraInsercao();
		System.out.println("\nNo cabeca" + p.toFila().elemento);
	}
}

