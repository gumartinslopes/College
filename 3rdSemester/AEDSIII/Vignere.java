public class Vignere{
	public static int alphabetLen = 27;
	public static int [][]map = new int[alphabetLen][alphabetLen];
	public static int row = alphabetLen;
	public static int col = alphabetLen;

	public static void montaMapa(){
		
		for(int i = 0 ; i < col; i++){
			int letter = i;
			for(int j = 0; j < row; j++){
				map[i][j] = (((letter + j)%alphabetLen) + 65);
			}
		}
	}
	
	public static void displayMapa(){
		for(int i = 0; i < row; i ++){
			for(int j = 0; j < col; j++)
				System.out.print((char)map[i][j] + " ");
			System.out.println();
		}
	}

	public static String completa(String incompleto,int tamanho){
		String completo = "";
		int i = 0;
		while(i < tamanho){
			completo+= incompleto.charAt(i % incompleto.length());
			i++;
		}
		return completo;
	}

	public static char searchLine(int key, int letter){
		int col, line = 0;
		int keyCol = key-65;
		for(col = 0; col < keyCol; col++);
		while(map[col][line]!= letter)
			line++;
		return (char)(line + 65);
	}

	public static String desencripta(String chave,String textoCifrado){
		String textoOriginal = "";
		String chaveFormatada = completa(chave, textoCifrado.length());
		for(int i =0; i < chaveFormatada.length(); i++)
			textoOriginal += searchLine((int)chaveFormatada.charAt(i), (int)textoCifrado.charAt(i));
		return textoOriginal;
	}	

	public static void main(String[] args){
		montaMapa();
		String chave = "JUNTOS", textoCifrado = "JFVZBJIGGFQSIYELOFILARWEQHE";
		System.out.println(desencripta(chave, textoCifrado));
		
	} 
}