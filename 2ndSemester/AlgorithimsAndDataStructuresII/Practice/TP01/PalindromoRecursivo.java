class PalindromoRecursivo{				//Trabalho Prático01Questão 1
	
        public static boolean verificaPalindromoR(String s){   //Funcao auxiliar para verificaPalindromoR
	     int tamanho = s.length();
	     return verificaPalindromoR(s,tamanho, 0);
	 } 

	public static boolean verificaPalindromoR(String s,int tam, int i){   //Funcao verificaPalindromo feita de forma recursiva
	     boolean resultado = true;
	     if(i > tam/2)
	         resultado = true;
	     
	     else if(s.charAt(i)!=s.charAt(tam-1-i))
		  resultado =  false;
	     
	     else
	          verificaPalindromoR(s, tam, i + 1); 
	    
	     return resultado;
	}

	public static boolean para(String s){   //Funcao que verifica se o programa chegou ao fim
	    return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');	
	}

	public static void main(String [] args){
	    String string = new String();
	    boolean ehPalindromo;

	    while(!para(string)){
	        string = MyIO.readLine();
	        ehPalindromo = verificaPalindromoR(string); 
	  	
	        if(ehPalindromo)
		    MyIO.println("SIM");
		else
		    MyIO.println("NAO");
	    }
	}//fim da main
}
