public class Box<T>{
    private T obj;
    public void store(T obj){
        this.obj = obj;
    }

    public T retrieve(){
        return this.obj;
    }
}