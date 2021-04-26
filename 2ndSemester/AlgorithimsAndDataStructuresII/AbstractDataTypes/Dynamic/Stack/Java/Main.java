class Main{
	public static void main(String[] args){
		try{
			PilhaFlex s = new PilhaFlex();
			s.push(1);
			s.push(2);
			s.push(56);
			s.push(3);
			s.push(2);
			s.pop();
			s.display();
			System.out.println(s.getRecursiveBiggestElement());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}