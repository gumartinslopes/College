public class Cliente implements Entidade{
    protected int idCliente;
    public Cliente(int id){
        this.idCliente = id;
    }
    public int getId(){
        return idCliente;
    }
}
