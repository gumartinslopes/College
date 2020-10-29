import java.util.Random;

class AlteracaoAleatoria{
	//metodo que troca 2 valores aleatorios da string
	public static String alteraString(String str){
	    Random gerador = new Random();
            gerador.setSeed(4);

	    String stringAlterada = new String();

	    char charAntigo = (char)('a' + Math.abs((gerador.nextInt() % 26)));
	    char charNovo = (char)('a' + Math.abs((gerador.nextInt() % 26)));
	    
	    for(int i = 0; i < str.length(); i ++){
	    	if(str.charAt(i) == charAntigo)
		    stringAlterada += charNovo;
		else
		    stringAlterada += str.charAt(i);
	    } 
	    return stringAlterada;
	}
	
	//metodo que verifica o fim do programa
	public static boolean para(String s){
	    return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}
	
	public static void main(String[] args){
	    String myString = new String();
	    while(!para(myString)){
	    	myString = MyIO.readLine();
		MyIO.println(alteraString(myString));
	    }
	}//fim da main
	

}
