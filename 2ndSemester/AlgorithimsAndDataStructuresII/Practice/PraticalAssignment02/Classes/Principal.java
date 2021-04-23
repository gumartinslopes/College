import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


//classe principal do programa
public class Principal{
  public static int maxMusicNumber = 170653;
  public static int maxPlaylistSize = 500;
  public static int inputNumber = 0;
  public static int totalComparisons;
  public static int totalMoves;

  public static String[] totalMusicInfo = new String[maxMusicNumber];
  public static Music[] playlist = new Music[maxPlaylistSize];

  public static void main(String[] args){
    MyIO.setCharset("UTF-8");
    String filepath = "/tmp/data.csv";
    try{
      long initialTime = System.currentTimeMillis();
      totalMusicInfo = playlist[0].ler(filepath, maxMusicNumber);
      standartInput();
      
      for(int i = 0; i < inputNumber; i++)
        playlist[i].imprimir();
      long afterTime = System.currentTimeMillis();
      long executionTime = afterTime - initialTime;
      
      createLog(executionTime,"690773_sequencial");
    }

    catch(Exception ex){
      MyIO.println(ex.toString());
      ex.printStackTrace();
    }
}

  public static void standartInput(){ 
     //registro de entrada padrao
     String id = new String();
      do{
        id = MyIO.readLine();
        if(id.compareTo("FIM") != 0){
          playlist[inputNumber] = new Music();
          registrar(totalSearchById(id));
          inputNumber++;
        }
      }while(id.compareTo("FIM") != 0);
  }

  public static void createLog(long executionTime, String filepath)throws IOException{
    BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
    bw.write("690773_sequencial.txt\t" + executionTime + "\t" + totalComparisons);
    bw.close();
  }

  //metodo que procura dentre todas as musicas a que possui determinado id
  public static String totalSearchById(String id){
    String resp = new String();
    for(int i = 0; i < maxMusicNumber; i++){
      if(totalMusicInfo[i].contains(id) == true){ 
        resp = totalMusicInfo[i];
        i = maxMusicNumber;
      }
    }
    return resp;
  }
 
  public static void registrar(String dadosNaoFormatados){
    String[] atributos = dataSplit(dadosNaoFormatados, 19);     //total de 19 atributos lidos porem 2 nao serao registrados
    trataNulidade(atributos); 
    playlist[inputNumber].setValence(Double.parseDouble(atributos[0]));
    playlist[inputNumber].setYear(Integer.parseInt(atributos[1]));
    playlist[inputNumber].setAcousticness(Double.parseDouble(atributos[2]));
    playlist[inputNumber].setArtists(atributos[3]);
    playlist[inputNumber].setDanceability(Double.parseDouble(atributos[4]));
    playlist[inputNumber].setDuration_ms(Integer.parseInt(atributos[5]));
    playlist[inputNumber].setEnergy(Double.parseDouble(atributos[6]));
    //skip explicit
    playlist[inputNumber].setId(atributos[8]);
    playlist[inputNumber].setInstrumentalness(Double.parseDouble(atributos[9]));
    playlist[inputNumber].setKey(atributos[10]);
    playlist[inputNumber].setLiveness(Double.parseDouble(atributos[11]));
    playlist[inputNumber].setLoudness(Double.parseDouble(atributos[12]));
    //skip mode
    playlist[inputNumber].setName(atributos[14]);
    playlist[inputNumber].setPopularity(Integer.parseInt(atributos[15]));
    playlist[inputNumber].setRelease_date(atributos[16]);
    playlist[inputNumber].setSpeechiness(Double.parseDouble(atributos[17]));
    playlist[inputNumber].setTempo(Float.parseFloat(atributos[18]));
  }

  public static void trataNulidade(String[] naoTratado){
    for(int i = 0; i < naoTratado.length; i++){
      if(naoTratado[i] == null)
        naoTratado[i] = "01"; 
    }
  }

  public static String[] dataSplit(String input, int arrayLength){
    String[] output = new String[arrayLength];
    
    //tratamento de virgulas internas e dos artistas
    String aux = input.replace(", ", "##");
    aux = aux.replace("\"[", "[");
    aux = aux.replace("]\"","]");
    
    output = aux.split(",");
    //retratamento de virgulas
    for(int i = 0; i < arrayLength; i++)
      output[i] = output[i].replace("##", ", ");

    return output;
  }

}

