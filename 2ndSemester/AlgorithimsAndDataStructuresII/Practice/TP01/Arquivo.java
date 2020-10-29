import java.io.*;
class Arquivo{
    public static double formata(double d){		//metodo utilizado apenas para formatar os resultados sem.0
    	double formatado;				//nao afeta a resolucao do algoritmo
	 if(d == (int)d)
		 formatado = Math.rint(d);
	 else
	    formatado = d;

	 return formatado;
    }
    public static void main(String[] agrs)throws Exception {
       RandomAccessFile raf = new RandomAccessFile("TP01.txt","rw");	//arquivo,operação
      
       int quantidade = MyIO.readInt();
       double valor;
      
       for(int i = 0; i < quantidade; i ++){    //laço que escreve no arquivo
           valor = MyIO.readDouble();
   	   raf.writeDouble(valor); 
       }

       for(int j = (quantidade * 8) - 8 ; j >= 0 ; j-=8){  //double tem uma distancia de 8 bits, por isso subtraimos 8 a cada iteracao
       	   raf.seek(j);
	   MyIO.println(formata(raf.readDouble()));
       }
      raf.close();
    }
}
