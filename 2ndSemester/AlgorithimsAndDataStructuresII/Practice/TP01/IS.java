class IS{
    public static boolean isAllVowel(String str){		//retorna false se nao forem apenas vogais
	boolean isvow = true;

	for(int i = 0; i < str.length(); i ++){
	    if(str.charAt(i)!='A' && str.charAt(i)!='E' && str.charAt(i)!='I' && str.charAt(i) !='O' && str.charAt(i)!='U'&&
	      str.charAt(i)!='a' && str.charAt(i)!='e' && str.charAt(i)!='i' && str.charAt(i)!='o' && str.charAt(i)!='u')
		isvow = false;
	} 
	
	return isvow;	
    }
  
    public static boolean isAllConsonant(String str){		// retorna false se nao forem apenas consoantes 
  	 boolean isCons = true;

	for(int i = 0; i < str.length(); i ++){
	   if(!(str.charAt(i) > 64 && str.charAt(i) < 91) && !(str.charAt(i) > 96 && str.charAt(i) < 123 ))			//filtro de letras
              isCons = false;
	   else if(str.charAt(i) == 'A'|| str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U'||	//filtro de consoantes
	           str.charAt(i) == 'a'|| str.charAt(i) == 'e'|| str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
	      isCons = false;
	}

        return isCons;
    }

 
    public static boolean isAnInt(String str){
    	boolean isInt = true;
	for(int i = 0; i < str.length(); i ++){
	    if(!(str.charAt(i) <= 57 && str.charAt(i) > 47))	//verificando se o o char fica entre 0(48) a 9(57) pelo codigo ascii
		    isInt = false;
	}
   	return isInt;
    }

    //metodo que verifica floats caso as anteriores sejam false
    public static boolean isAFloat(String str){
   	boolean isF = true;

	if(isAnInt(str) || isAllConsonant(str) || isAllVowel(str))
	    isF = false;    
	
	else{
	   for(int i = 0; i < str.length(); i ++){
	     if((str.charAt(i) > 57 || str.charAt(i) < 47) && (str.charAt(i) != '.' && str.charAt(i) != ','))
	        isF = false;
	   }	
	}
	return isF; 
    }

    //metodo que verifica o fim do programa
    public static boolean para(String str){	
    	return(str.length() >= 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    //metodo que economizou varios ifs para fazer o output 
    public static String verifica(boolean x){
       String result = new String();

       if(x == true)
	    result = "SIM";
       else
	    result = "NAO";
       return result;
    }

    public static void main(String [] args){
    	String myString = new String();
	boolean x1, x2, x3, x4;
	while(!para(myString)){
	    myString =MyIO.readLine();

            x1 = isAllVowel(myString);
	    x2 = isAllConsonant(myString);
	    x3 = isAnInt(myString);   
	    x4 = isAFloat(myString);		  
	   MyIO.println(verifica(x1) + " " + verifica(x2) + " "  + verifica(x3) + " " + verifica(x4));
	}
    } //fim da main
}
