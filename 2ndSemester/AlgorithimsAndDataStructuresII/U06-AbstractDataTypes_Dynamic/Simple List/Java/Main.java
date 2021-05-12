public class Main{
	public static void main(String[] args){
		System.out.println("Hello");
		List l = new List();
		l.insertFirst(48);
		l.insertFirst(113);
		l.insertFirst(245);
		l.insertFirst(398);
		l.display();
		l.removeSecondPos();
		l.display();
	}
}