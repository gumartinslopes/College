public class Arquivo <t extends Entidade> {
    Constructor<t> construtor;
    T[] coisas = new T[3];
    int index;
    public Arquivo(Constructor<t> construtor){
        this.construtor = construtor;
        index = 0;
    }
    public void store(T obj){
        t[++index] = obj;
    }
    public void displayById(){
        for(T coisas: coisa){
            System.out.println(coisa.getId());
        }
    }
}
