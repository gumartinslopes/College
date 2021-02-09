import java.util.Scanner;
class Cometa{
	public static Scanner sc = new Scanner(System.in);
	public static int getProximoAno(int anoAtual){
		int proximo = 1986;//ano de passagem inicialmente forncecido
		do{	
			proximo += 76;
		}while(proximo <= anoAtual);//se esse for um ano de passagem ele eh ignorado
		
		return proximo;
	}
	public static void main(String[] args){
		int anoAtual;
		do{
			anoAtual = sc.nextInt();
			if(anoAtual != 0)
				System.out.println("Ano " + getProximoAno(anoAtual));
		}while(anoAtual != 0);
	}
}