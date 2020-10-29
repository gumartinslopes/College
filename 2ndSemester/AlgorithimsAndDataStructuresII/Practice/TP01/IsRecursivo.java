class IsRecursivo{
     //metodos que verificam se eh composto apenas por vogais
     public static boolean isAllVowel(String str){
     	
	return isAllVowel(str, 0);
     }
     public static boolean isAllVowel(String str, int i){
     	boolean result = true;

	if(str.charAt(i)!='A' && str.charAt(i)!='E' && str.charAt(i)!='I' && str.charAt(i)!='O' && str.charAt(i)!='U' && 
	   str.charAt(i)!='a' && str.charAt(i)!='e' && str.charAt(i)!='i' && str.charAt(i)!='o' && str.charAt(i)!='u')
	    result = false;
	
	else if(i < str.length() -1)
	    result = isAllVowel(str,i+1);

	return result;
     }

     //metodos que verificam se eh composto por apenas consoantes
     public static boolean isAllConsonant(String str){
 
        return isAllConsonant(str, 0);
     }
    
     public static boolean isAllConsonant(String str,int i){
     	boolean result = true;
         
	if(!(str.charAt(i) > 64 && str.charAt(i) < 91) && !(str.charAt(i) > 96 && str.charAt(i) < 123))   //filtro de letras
		result = false;
	else if(str.charAt(i) =='A' || str.charAt(i) =='E' || str.charAt(i) =='I' || str.charAt(i) =='O' || str.charAt(i) =='U' && 
	   str.charAt(i) =='a' || str.charAt(i) =='e' || str.charAt(i) =='i' || str.charAt(i) =='o' || str.charAt(i) =='u')
		result = false;				//filtro de vogais

	else if(i < str.length() -1)
	    result = isAllConsonant(str, i + 1);
	    
	return result;
     }
     //metodos que verificam se eh um inteiro 
     public static boolean isAnInt(String str){    
         return isAnInt(str, 0);
     }

     public static boolean isAnInt(String str, int i){
     	boolean result = true;
	
	if(!(str.charAt(i) <= 57 && str.charAt(i) > 47))	//caso base
		result = false;       			
	
	else if(i < str.length() -1)			//caso recusrivo
		result = isAnInt(str, i + 1);
	
	return result;
     }

     //metodo que verifica se eh um float
     public static boolean isAFloat(String str){
     	 return isAFloat(str, 0);
     }
     
     public static boolean isAFloat(String str, int i){
     	boolean result  = true;
	
	if(isAllVowel(str) || isAllConsonant(str) || isAnInt (str))
		result = false;
	else if((str.charAt(i) > 57 || str.charAt(i) < 47) && (str.charAt(i) != '.' && str.charAt(i) != ','))
		result = false;

	else if(i < str.length() -1)
	    result = isAFloat(str, i + 1);

	return result;
     }

     //metodo que verifica o fim do programa	
     public static boolean para(String str){
     	return (str.length() >=3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
     }

     //metodo que faz o output
     public static String verifica(boolean x){
         String result = new String();

	 if(x == true)
		 result = "SIM";
	 else
		 result = "NAO";
	 return result;
     }

     public static void main(String[] args){
	    String myString = new String();
	    boolean x1, x2, x3, x4;
	    while(!para(myString)){
	        myString = MyIO.readLine();

		x1 = isAllVowel(myString);
		x2 = isAllConsonant(myString);
		x3 = isAnInt(myString);
		x4 = isAFloat(myString);
		MyIO.println(verifica(x1) + " " + verifica(x2) + " " + verifica (x3) + " " + verifica(x4));
	    }
    }//fim da main
}
