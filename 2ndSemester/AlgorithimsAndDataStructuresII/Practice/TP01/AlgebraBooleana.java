class AlgebraBooleana{
     public static String removeEspacos(String str){	//metodo necessario para facilitar a filtragem dos caracteres
         String aux = new String();
	 
	 for(int i = 0; i < str.length(); i++){
	     if(str.charAt(i) != 32)           //valor para espacos em branco
	 	aux += str.charAt(i);
	 }
	 return aux;
     }

     public static boolean or(String str, int index){
     	
     }
     public static boolean and(String str, int index){
     
     }
     public static boolean not(String str, int index){
     
     }

    //metodo chave do programa !alterar descricao
    public static boolean resolve (String str){
	//a resolver
        return result;
    }

    //metodo que verifica o fim do programa
    public static boolean para(String str){
	return (str.length()  == 1 && str.charAt(0) == '0');
    }
    
    public static void main(String[] args){
	String myString = new String();
     	
	do{
	    myString = MyIO.readLine();
	    myString =  removeEspacos(myString);
	    MyIO.println(myString);
	  
	   if(resolve(myString) == true);
	     MyIO.println("1");
	   else
	     MyIO.println("0");  

	}while(!para(myString));
    }
}
