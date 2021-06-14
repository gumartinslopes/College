import java.util.Scanner;
import java.io.IOException;

public class Main{
	public static HashTable ht;
	public static Scanner inputReader = new Scanner(System.in);
	public static void main(String[] args){
		try{	
		System.out.print("What is the size of your table? ->");
		int length = inputReader.nextInt();
		ht = new HashTable(length);
			int input;
			do{
				clearConsole();
				input = readInput("Quit (0)\nInsert (1)\nRemove (2)\nSearch (3) \nDisplay (4)" , 5);
				if(input != 0)
					operate(input);
			}
			while(input != 0);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public static int readInput(String prompt, int quantOptions){
		int input;
		boolean chooseOption;
		do{
			System.out.println(prompt);
			input = (Integer.parseInt(inputReader.next()));
			if(input < 0 || input > quantOptions - 1){
				chooseOption = false;
				System.out.println("Choose a valid option!");
			}
			else	
				chooseOption = true;
		}while(!chooseOption);
		return input;
	}

	public static void operate(int option)throws Exception{
		if(option == 1){
			System.out.print("Which number will you insert?\n->");
			ht.insert(Integer.parseInt(inputReader.next()));
		}
		else if(option == 2){
			System.out.print("Which number will you remove?\n->");
			ht.remove(Integer.parseInt(inputReader.next()));
		}
		else if(option == 3){
			System.out.print("Which number will you search?\n->");
			int key = Integer.parseInt(inputReader.next());
			boolean result = ht.search(key);

			if(result == true)
				System.out.println("The element " + key + " exists in your table");
			else 
				System.out.println("The element " + key  + " does not exist in your table");
		}
		else{
			System.out.println("Your table:");
			ht.display();	
		}
		holdInteraction();
	}			

	public static void clearConsole()throws Exception{
		if(System.getProperty("os.name").contains("Windows"))
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		else 
			Runtime.getRuntime().exec("clear");
	}

	public static void holdInteraction(){
		System.out.println("Press any key to continue...");
		inputReader.next();
	}
}
