class CiframentoDeCesar{
    public static String criptografa(String s){		//criptografa a string com chave 3 utilizando casting de forma manual
    	String cripto = new String();
	int aux;	
    	for(int i = 0; i < s.length(); i ++){		
	    if(s.charAt(i) == ' ' && s.charAt(i) !='\n')  //verificacao de espaco
	       cripto += ' ';
	    else{
	       aux = s.charAt(i) + 3;
	       cripto +=  (char)aux;	
	    }	       
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
		System.out.println(criptografa(myString));
	}
    }// final da main
}
