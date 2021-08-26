public class Square implements FiguraGeometrica{
    public Square(int lado, String nomeFigura){
        this.lado = lado;
        this.nomeFigura = nomeFigura;
    }

    private int lado;
    private String nomeFigura;

    public int getlado(){
        return this.lado;
    }
    public void setlado(int lado){
        this.lado = lado;
    }
    @Override
    public String getNomeFigura(){
        return this.nomeFigura;
    }
    @Override
    public int getArea(){
        return this.lado * this.lado;
    }
    @Override
    public int getPerimetro(){
        return this.lado * 4;
    }
    @Override
    public String toString(){
        return ("[" + this.lado +", " + this.nomeFigura + "]");
    }
}
