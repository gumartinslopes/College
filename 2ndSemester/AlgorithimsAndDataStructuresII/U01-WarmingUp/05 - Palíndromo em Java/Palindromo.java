import java.util.Scanner;

class Palindromo{
	public static Scanner sc = new Scanner(System.in);	

	//metodo que determina a existencia de palindromo
	public static boolean checkPalindromo(String palavra){
		boolean resultado = true;
		int tamanho = palavra.length();
		int i = 0;

		do{
			if(palavra.charAt(i) != palavra.charAt(tamanho - 1 - i))
				resultado = false;
			i++;
		}while(i < tamanho/2 && resultado != false);
		return resultado;
	}

	//metodo main
 	public static void main(String[] args){
		String entrada;
		do{
			entrada = sc.nextLine();
			if(checkPalindromo(entrada)){
				System.out.println("SIM");
			}
			else{
				System.out.println("NAO");
			}
		}while(entrada.compareTo("FIM") != 0);
	}
}