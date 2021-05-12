public class Main{
	public static void main(String[] args){
		try{
			Stack s = new Stack(20);
			for(int i = 0; i < 20; i++){
				s.push(i);
			}
			s.display();
			s.pop();
			s.pop();
			s.display();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	} 
}