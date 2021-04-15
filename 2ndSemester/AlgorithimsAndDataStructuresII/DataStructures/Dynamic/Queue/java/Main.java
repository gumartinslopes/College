public class Main{
	public static void main(String[] args){
		Queue q = new Queue();
		
		for(int i = 5; i <= 25; i += 5)
			q.insert(i);

		//q.display();
		q.metodoDoidao();
		//q.display();
		
		/*
		//q.reverse();
		q.display();
		System.out.println("O maior elemento da sua fila eh : " + q.getBiggest());
		System.out.println("A soma de todos os elementos contidos na sua fila eh " + q.getSum());
		System.out.println("A quantidade de valores pares e multiplos de 5 na sua fila eh " + q.countEven());
		*/
	}
}