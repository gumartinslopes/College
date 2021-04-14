public class Main{
	public static void main(String[] args){
		try{
			CircleQueue q = new CircleQueue();
			q.insert(7);
			q.insert(8);
			q.insert(9);
			q.insert(78);
			q.remove();
			q.display();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	} 
}