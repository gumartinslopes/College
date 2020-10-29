import java.io.*;
import java.net.*;

class leituraHtml{
  public static String getHtml(String endereco){  //retorna uma string conotendo o conteudo html
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  
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

      }

      return resp;
   }

  public static int contaVogal(char c, String s){	//metodo que economiza um if gigantesco
  	int total = 0;
	for(int i = 0; i < s.length(); i++){
	    if(s.charAt(i) == c)
		    total++;	
	}
	return total;
  }

  public static int contaConsoante(String s){
  	int total = 0;
	char aux;
	for(int i = 0; i < s.length(); i++){
	  aux = s.charAt(i);
	  if(aux >= 98 && aux <= 122 && aux!='a' && aux == 'e' && aux != 'i' && aux !='o' && aux != 'u')    //garante que esta entre a e z e nao eh vogal
		  total++;
	}
	return total;
  }
  public static boolean compara(int i, int j, String esp, String s){    //funcao recursiva para comparar duas strings
  	boolean result = true;
	if(s.charAt(i) != esp.charAt(j))
	    result = false;
	
	else if(j < esp.length() -1 && i < s.length() - 1)
	    result = compara(i + 1, j + 1, esp, s);

	return result; 
  }
  public static int contaTag(String tag, String s){
        int total = 0;
	for(int i = 0; i < tag.length(); i++){		//reduzindo comparações
	 if(s.charAt(i) == tag.charAt(0) && s.charAt(i + 1) == tag.charAt(1) && s.charAt(i + 2) == tag.charAt(2) && s.charAt(i + 3) == tag.charAt(3)){
	    if(compara(i,0, tag,s))
		total++;
	  }
	}
	return total;
  }
  //metodos utilizados para agilizar a escrita
  public static void escreve(char c,int i){
  	MyIO.print(c+"(" + i + ") "); 
  }

  public static void escreveString(String s, int i){
  	MyIO.print(s+"(" + i + ") ");
  }
  //metodo que verifica o fim do programa
  public static boolean para(String s){ 
      return(s.length() == 3 && s.charAt(0) == 'F'&& s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

  public static void main(String[] args) {
      String endereco,nome, html;
      do{
	   nome = MyIO.readLine();
     	   if(!para(nome)){
	   endereco = MyIO.readString();
      	   html = getHtml(endereco);

      	   escreve('a',contaVogal('a',html));   //1
     	   escreve('e',contaVogal('e',html));   //2
           escreve('i',contaVogal('i',html));   //3
      	   escreve('o',contaVogal('o',html));   //4
      	   escreve('u',contaVogal('u',html));   //5
      
      	   escreve('á',contaVogal('á',html));   //6
      	   escreve('é',contaVogal('é',html));   //7
      	   escreve('í',contaVogal('í',html));   //8
      	   escreve('ó',contaVogal('ó',html));   //9
      	   escreve('ú',contaVogal('ú',html));   //10
	 
      	   escreve('à',contaVogal('à',html));   //11
      	   escreve('è',contaVogal('è',html));   //12
      	   escreve('ì',contaVogal('ì',html));   //13
      	   escreve('ò',contaVogal('ò',html));   //14
      	   escreve('ù',contaVogal('ù',html));   //15
      
      	   escreve('ã',contaVogal('ã',html));   //16
      	   escreve('õ',contaVogal('õ',html));   //17
      	   escreve('â',contaVogal('â',html));   //18
      	   escreve('ê',contaVogal('ê',html));   //19
      	   escreve('î',contaVogal('î',html));   //20
      	   escreve('ô',contaVogal('ô',html));   //21
      	   escreve('û',contaVogal('û',html));   //22

      	   escreveString("consoante",(contaConsoante(html)));//23
      	   escreveString("<br>",contaTag("<br>",html));//24
      	   escreveString("<table>",contaTag("<table>",html));//25
      	   MyIO.print(nome);
      	   MyIO.print("\n");
     	}
      }while(!para(nome));
  }
}

