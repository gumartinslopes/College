public class Livro {    
    private String titulo;
    private String autor;
    private float preco;    

    public Livro(){

    }

    //--- getters ---
    public String getTitulo(){
        return this.titulo;
    }
    public String getAutor(){
        return this.autor;
    }
    public float getPreco(){
        return this.preco;
    }

    //--- setters ---
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setPreco(float preco){
        this.preco = preco;
    }

}
