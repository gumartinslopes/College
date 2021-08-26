public class Produto implements Entidade{
   protected int idProduto;
   public Produto(int id){
       this.idProduto = id;
   }
   public int getId(){
       return idProduto;
   } 
}
