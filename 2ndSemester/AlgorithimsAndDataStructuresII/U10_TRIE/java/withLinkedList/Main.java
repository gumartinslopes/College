public class Main{
	public static void main(String[]args){
		try{
			TRIE dictionary = new TRIE();
			String []array = new String[11];
			array[0] = "batatinha";
			array[1] = "clebin milgrau";
			array[2] = "zezing do flaflu";
			array[3] = "bad company";
			array[4] = "bolo";
			array[5] = "bobo"; 
			array[6] = "bola";
			array[7] = "claymore";
			array[8] = "zagueiro";
			array[9] = "ferris";
			array[10] = "a e i o u";
			for(String word: array)
				dictionary.insert(word);
			dictionary.display();
		}	catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
