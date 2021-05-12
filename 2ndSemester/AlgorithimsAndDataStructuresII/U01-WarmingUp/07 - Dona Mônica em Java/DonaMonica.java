import java.util.Scanner;

class DonaMonica{
	public static Scanner sc = new Scanner(System.in); 
	public static int calculaIdadeFilho3(int idadeMae, int idadeFilho1, int idadeFilho2){
		return(idadeMae - (idadeFilho1 + idadeFilho2));
	}

	public static int getMaisVelho(int filho1, int filho2, int filho3){
		int maiorIdade;
		if(filho1 > filho2 && filho1 > filho3)
			maiorIdade = filho1;
		else if(filho2 > filho1 && filho2 > filho3)
			maiorIdade = filho2;
		else 
			maiorIdade = filho3;
		return maiorIdade;
	}

	public static void main(String[] args){
		int idadeDonaMonica;
		int idadeFilho1;
		int idadeFilho2;

		do{
			idadeDonaMonica = sc.nextInt();
			if(idadeDonaMonica !=0 ){
				idadeFilho1 = sc.nextInt();
				idadeFilho2 = sc.nextInt();
				int idadeFilho3 = calculaIdadeFilho3(idadeDonaMonica, idadeFilho1, idadeFilho2);
				System.out.println(getMaisVelho(idadeFilho1, idadeFilho2, idadeFilho3));
			}	
			
		}while(idadeDonaMonica != 0);
	}
}