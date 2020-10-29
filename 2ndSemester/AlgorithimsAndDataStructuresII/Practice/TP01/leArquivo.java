import java.io.*;

class leArquivo{
    public static void main(String[] args)throws Exception{
        RandomAccessFile raf = new RandomAccessFile("exemplo.txt","rw");

	int inteiro = raf.readInt();
	double real = raf.readDouble();
	char caractere = raf.readChar();
	boolean booleano = raf.readBoolean();
	String str = raf.readLine();
	
	System.out.println("inteiro: " + inteiro + " reaal " + real + " caractere " + caractere + " booleano " + booleano + " String " + str);
        
	raf.seek();	//Retorna o  file pointer para a posição 0
	System.out.println(raf.readInt());
	raf.seek(12);

	System.out.println(raf.readChar());

	raf.seek(12);
	raf.writeChar('@');

	raf.seek(12);
	System.out.println(raf.readChar());

	raf.close();
    }
}
