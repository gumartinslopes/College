class Principal{
	public static void main(String[] args){
	    ListaSimples l = new ListaSimples();
	    try{
	    l.inserirInicio(12);
	    l.inserirInicio(32);
	    l.inserirInicio(25);
	    l.mostrar();
	    l.removerSegunda();
	    l.mostrar();
	    }
	    catch(Exception ex){
		ex.printStackTrace();
	    }
		
	 }


	
}	
