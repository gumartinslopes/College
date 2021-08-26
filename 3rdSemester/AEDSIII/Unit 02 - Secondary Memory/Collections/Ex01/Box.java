public class Box<T>{
   private T objeto;
   public void armazena(T objeto){
    this.objeto = objeto;
   }
   public T recupera(){
       return this.objeto;
   }
}