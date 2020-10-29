class Palindromo{						//Trabalho Pratico 01Questao 01

	//funcao que identifica se eh um palindromo ou nao
	public static boolean verificaPalindromo(String s){		
		boolean resultado = true;
		int tamanho = s.length();
		for(int i = 0; i <= (tamanho/2); i++) {
		    if(s.charAt(i)!= s.charAt(tamanho - 1 - i)){
			   resultado = false;
		    }
		}
		return resultado;
	}

	//funcao que determina se o programa chegou ao fim
	public static boolean para(String s){									
		return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}

	public static void main(String [] args){
		String string  = new String();	
		
		while(!para(string)){
		    string = MyIO.readLine();
	            boolean ehPalindromo = verificaPalindromo(string);
		    
		    if(ehPalindromo)
			MyIO.println("SIM");
		    else 
			MyIO.println("NAO");
		}

	}//fim da main
}
