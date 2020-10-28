class Principal{
	public static void main(String[] args)throws Exception{
		Fila f = new Fila();
		f.enfileirar(5);
		f.enfileirar(10);
		f.enfileirar(15);
		f.enfileirar(20);
		f.enfileirar(25);
		
		f.mostrar();
		System.out.println("O maior valor da sua Fila é: " + f.getMaior());
	//	System.out.println("Inverteu");
	//	f.inverte();
	//	f.mostrar();
	//	System.out.println("Desinverteu");
	//	f.inverte();
	//	f.mostrar();

	//	int removido = f.desenfileirar();
	        f.mostrarTerceiroElemento();
	//	removido = f.desenfileirar();
		f.mostrar();
		System.out.println("A soma dos valores da sua fila é : " + f.getSoma());
	//	f.enfileirar(10);
	//	f.enfileirar(20);
		f.mostrar();
		System.out.println("A quantidade de valores pares multiplos de 5 na sua fila eh " + f.contar());
		f.metodoDoidao();
	}
}
