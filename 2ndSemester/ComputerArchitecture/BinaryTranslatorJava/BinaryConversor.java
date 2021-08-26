import java.util.Scanner;
public class BinaryConversor{ 
	public static String getBits(int n){
	    String w = new String();
	    for(int i = n; i > 0; i /=2)
	      w += ((i%2 == 0)?0:1);  
	    return reverse(w);
	}

	public static String reverse(String s){
		int len = s.length();
		String newS = new String();
		for(int i = 0;i  < len; i++)
	      newS += s.charAt(len - i - 1);
	  return newS;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Insert a value and see it's binary representation -> ");
		System.out.println(getBits(sc.nextInt()));
	}	
}

