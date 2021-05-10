public class ShellSort extends InternalSort{
	public  ShellSort(){
		super();
	}

	public  ShellSort(int arraySize){
		super(arraySize);
	}

	@Override
	public void sort(){
		int h = 1;
		do{
			h = (h * 3) + 1;
		}while(h < n);
		
		do{
			h/=3;
			for(int color = 0; color < h; color++){
				insertionByColor(color, h);
			}
		}while(h != 1);
	} 

	private void insertionByColor(int color, int h){
		for(int i = (h + color); i < n; i += h){
			int aux = array[i];
			int j = i - h;
			while((j >= 0) && (array[j] > aux)){
					array[j + h] = array[j];
					j-= h;
			}
			array[j + h] = aux;
		}
	}
}