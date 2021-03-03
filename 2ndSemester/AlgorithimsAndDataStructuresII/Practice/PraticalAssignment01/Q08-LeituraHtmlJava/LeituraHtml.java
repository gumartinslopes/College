import java.io.*;
import java.net.*;

class LeituraHtml {
  public static int []valores;  //aray onde a quantidade de caracteres eh contabilizada
   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }
  
   //metodo que checa o fim do programa
   public static boolean checkFim(String entrada){
    return (entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
   }

   //contabilizacao de vogais sem acento
   public static void contaVogais(char c){
      if(c == 'a')
        valores[0]++;
      else if(c == 'e')
        valores[1]++;
      else if(c == 'i')
        valores[2]++;
      else if(c == 'o')
        valores[3]++;
      else if(c == 'u')
        valores[4]++;
   }

   //contabilizacao de letras com acento agudo ´
   public static void contaVogaisAgudo(char c){
      if(c == 225)          //utilizacao dos codigos da extended ascii table
        valores[5]++;
      else if(c == 233)
        valores[6]++;
      else if(c == 237)
        valores[7]++;
      else if(c == 243)
        valores[8]++;
      else if(c == 250)
        valores[9]++;
   }

   //contabilizacao de letras com acento grave `
   public static void contaVogaisGrave(char c){
      if(c == 224)
        valores[10]++;
      else if(c == 232)
        valores[11]++;
      else if(c == 236)
        valores[12]++;
      else if(c == 242)
        valores[13]++;
      else if(c == 249)
        valores[14]++;
   }

   //contabilizacao de letras com til
   public static void contaVogaisTil(char c){
      if(c == 132)
        valores[15]++;
      else if(c == 245)
        valores[16]++; 
   }
  
   //contabilizacao de letras com til
   public static void contaVogaisCirc(char c){
      if(c == 226)
        valores[17]++;
      else if(c == 234)
        valores[18]++;
      else if(c == 238)
        valores[19]++;
      else if(c == 244)
        valores[20]++;
      else if(c == 251)
        valores[21]++;
   }


   public static boolean isVogal(char c){
     boolean resp = false;
     char[] vogais = {'a','e','i','o','u','A','E','I','O','U'};
     for(int i = 0;i < vogais.length; i++){
      if(c == vogais[i]){
        resp = true;
        i = vogais.length;//a execucao para ao encontrar um valor desejado
      }
     }
     return resp;
   }
  
  
  //metodo de contabilizacao de consoantes
   public static void contaConsoante(char c){
        if(isVogal(c) == false && (c > 97 && c < 123))
          valores[22]++;
   }
   
  //verificacao de existencia da tag <br>
   public static boolean checkBr(String entrada, int i){
     boolean resp = false;
    if(entrada.charAt(i) == '<' && entrada.charAt(i + 1) =='b' && entrada.charAt(i + 2) == 'r' && entrada.charAt(i + 3) == '>')
      resp = true;
    return resp;
   }

  //verificacao de existencia da tag <table>
   public static boolean checkTable(String entrada, int i){
      boolean resp = false;
      if(entrada.charAt(i) == '<' && entrada.charAt(i + 1) == 't' && entrada.charAt(i + 2) == 'a' && entrada.charAt(i + 3) == 'b' 
          && entrada.charAt(i + 4) =='l' && entrada.charAt(i + 5) == 'e'&& entrada.charAt(i + 6) == '>')
        resp = true;
      return resp;
   }



   //funcao base para a contabilizacao
   public static void contabiliza(String entrada){
    for(int i = 0; i < entrada.length(); i++){
     contaVogais(entrada.charAt(i)); 
     contaVogaisAgudo(entrada.charAt(i));
     contaVogaisGrave(entrada.charAt(i));
     contaVogaisTil(entrada.charAt(i));
     contaVogaisCirc(entrada.charAt(i));
     contaConsoante(entrada.charAt(i));
     if(checkBr(entrada,i)){
      valores[23]++;
      i+= 3;//devemos caminhar o i em 3 casas para evitar que valores sejam contados mais de uma vez
     }
     else if(checkTable(entrada,i)){
      valores[24]++;
      i+= 6;
     }
    }
   }
  
  //funcao que compila todas os resultados
  public static void getResp(){
    MyIO.print("a(" + valores[0] + ") e(" + valores[1] + ") i(" + valores[2] + ") o(" + valores[3] + ") u(" + valores[4] + ")");
    MyIO.print(" á(" + valores[5] + ") é(" + valores[6] + ") í(" + valores[7] + ") ó(" + valores[8] + ") ú(" + valores[9] + ")");
    MyIO.print(" à(" + valores[10] + ") è(" + valores[11] + ") ì(" + valores[12] + ") ò(" + valores[13] + ") ù(" + valores[14] + ")");
    MyIO.print(" ã(" + valores[15] + ") õ(" + valores[16] + ")"); 
    MyIO.print(" â(" + valores[17] + ") ê(" + valores[18] + ") î(" + valores[19] + ") ô(" + valores[20] + ") û(" + valores[21] + ")");
    MyIO.print(" consoante(" + valores[22] + ")");
    MyIO.print(" <br>(" + valores[23] + ")");
    MyIO.print(" <table>(" + valores[24] + ")");
  }
  public static void main(String[] args) {
      String nome, endereco, html;
      do{
        nome = MyIO.readLine();//leitura da primeira linha
        if(!checkFim(nome)){
          valores = new int[26];
          endereco = MyIO.readLine();//leitura da segunda linha
          html = getHtml(endereco);
          contabiliza(html);
          getResp();
          MyIO.print(" " + nome);
          MyIO.println("");
        }
      }while(!checkFim(nome));
   }
}
