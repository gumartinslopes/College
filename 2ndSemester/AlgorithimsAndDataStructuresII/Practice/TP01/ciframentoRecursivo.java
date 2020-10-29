class ciframentoRecursivo{
    public static String criptografa(String s){
        return criptografa(s, 0);
    }
    public static String criptografa(String s, int i){		//criptografa a string com chave 3 utilizando casting de forma manual
        String cripto = new String();
 	
        cripto += (char)(s.charAt(i) + 3); 
	if(i < s.length() - 1){  
	   cripto +=criptografa(s, i +1);
	}
	 	
	    return cripto;
    }

    public static boolean para(String string){		//funcao que verifica se a entrada acabou
    	return (string.length()>=3 && string.charAt(0) == 'F' && string.charAt(1) == 'I' && string.charAt(2) == 'M');
    }

    public static void main(String[] args){
    	String myString = new String();
	while(!para(myString)){
     		myString = MyIO.readLine();
		MyIO.println(criptografa(myString));
	}
    }// fim da main


}
