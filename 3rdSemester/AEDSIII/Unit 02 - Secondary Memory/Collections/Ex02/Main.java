public class Main {
    public static void main(String[] args){
        Arquivo <Cliente> arquivoDeClientes = new Arquivo<>(Cliente.class.getConstructor());
        Arquivo <Produto> arquivoDeProdutos = new Arquivo<>(Produto.class.getConstructor());
        Cliente c1 = new Cliente(12);
        Cliente c2 = new Cliente(24);
        arquivoDeClientes.store(c1);
        arquivoDeClientes.store(c2);
        arquivoDeClientes.display();
    }
}
