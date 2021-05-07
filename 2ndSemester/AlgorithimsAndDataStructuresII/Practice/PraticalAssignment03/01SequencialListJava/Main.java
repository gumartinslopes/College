import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

//classe principal do programa
public class Main{
  public static int maxMusicNumber = 170653; 
  public static int inputNumber = 0;
  public static int totalComparisons;
  public static int totalMoves;

  public static String[] totalMusicInfo = new String[maxMusicNumber];
  public static Playlist myTracks = new Playlist();

  public static void main(String[] args){
    MyIO.setCharset("UTF-8");
    String filepath = "/tmp/data.csv";
    try{
      totalMusicInfo = ler(filepath, maxMusicNumber);
      standartInput();  //cadastro inicial
      readCommands();
      myTracks.display();
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
        if(id.compareTo("FIM") != 0)
          myTracks.insertLast(getRegister(totalSearchById(id)));
      }while(id.compareTo("FIM") != 0);
  }
  
  public static void readCommands()throws Exception{
    int commandQuantity = MyIO.readInt();
    for(int i = 0; i < commandQuantity; i++)
     operate(MyIO.readLine());
  }

  public static void operate(String input)throws Exception{
    String[] commands = input.split(" ");
    String operation = commands[0];
    
    if(operation.charAt(0) == 'I'){
      
      if(operation.charAt(1) == 'I')
        myTracks.insertFirst(getRegister(totalSearchById(commands[1])));
  
      else if(operation.charAt(1) == '*')
        myTracks.insertPos(Integer.parseInt(commands[1]),getRegister(totalSearchById(commands[2])));
      
      else if(operation.charAt(1) == 'F')
        myTracks.insertLast(getRegister(totalSearchById(commands[1])));

      else
        throw new Exception("Inserção inválida");
    }

    else if(operation.charAt(0) == 'R'){
      
      if(operation.charAt(1) == 'I')
        myTracks.removeFirst();
      
      else if(operation.charAt(1) == '*')
        myTracks.removePos(Integer.parseInt(commands[1]));
      
      else if(operation.charAt(1) == 'F')
        myTracks.removeLast();
      
      else
        throw new Exception("Remoção inválida");
    }

    else{
      throw new Exception("Operação inválida!");
    }
  }
 
  public static String[] ler(String path, int maxMusicNumber)throws IOException{
    String[] musicList = new String[170653];
    int i = 0;
    BufferedReader br = new BufferedReader(new FileReader(path));
    br.readLine(); //primeira linha do arquivo desprezada
    while(i < maxMusicNumber)
      musicList[i++] = br.readLine();
    return musicList;
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

  public static Music getRegister(String dadosNaoFormatados){
    String[] atributos = dataSplit(dadosNaoFormatados, 19);     //total de 19 atributos lidos porem 2 nao serao registrados
    trataNulidade(atributos);
    Music m = new Music();
    m.setValence(Double.parseDouble(atributos[0]));
    m.setYear(Integer.parseInt(atributos[1]));
    m.setAcousticness(Double.parseDouble(atributos[2]));
    m.setArtists(atributos[3]);
    m.setDanceability(Double.parseDouble(atributos[4]));
    m.setDuration_ms(Integer.parseInt(atributos[5]));
    m.setEnergy(Double.parseDouble(atributos[6]));
    //skip explicit
    m.setId(atributos[8]);
    m.setInstrumentalness(Double.parseDouble(atributos[9]));
    m.setKey(atributos[10]);
    m.setLiveness(Double.parseDouble(atributos[11]));
    m.setLoudness(Double.parseDouble(atributos[12]));
    //skip mode
    m.setName(atributos[14]);
    m.setPopularity(Integer.parseInt(atributos[15]));
    m.setRelease_date(atributos[16]);
    m.setSpeechiness(Double.parseDouble(atributos[17]));
    m.setTempo(Float.parseFloat(atributos[18]));
    return m;
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

class Playlist{
  private int length;
  private Music[] list;

  public Playlist(){
    this(500);
  }

  public Playlist(int maxLength){
    this.length = 0;
    this.list = new Music[maxLength];
  }

  public void display(){
    for(int i = 0; i < length; i++)
      System.out.println("[" + i + "] " + list[i].toString());
  }

  public void insertFirst(Music m){
    if(length == list.length)
      System.out.println("Número máximo de músicas na playlist alcançado.");
    else{
      for(int i = length; i > 0; i--)
        list[i] = list[i - 1].clone();
      list[0] = m.clone();
      length++;
    }
  } 

  public void insertPos(int pos, Music m){
    if(length == list.length)
      System.out.println("Número máximo de músicas na playlist alcançado.");
    else if(pos > list.length || pos < 0)
      System.out.println("Posição de inserção inválida");
    else{
      for(int i = length; i > pos; i--)
        list[i] = list[i - 1].clone();
      list[pos] = m.clone();
      length++;
    }
  }
  
  public void insertLast(Music m){
    if(length == list.length)
      System.out.println("Número máximo de músicas na playlist alcançado.");
    else
      list[length++] = m.clone();
  }
  
  //métodos de remoção
  public void removeFirst(){
    if(length == 0)
      System.out.println("A playlist está vazia, não há itens para remover");
    else{
      Music removed = list[0].clone();
      length--;
      for(int i = 0; i < length; i++)
        list[i] = list[i +1];
      System.out.println("(R) " + removed.getName());
    } 
  }
  
  public void removePos(int pos){
    if(length == 0) 
      System.out.println("A playlist está vazia, não há itens para remover");
    else if(pos < 0 || pos >= length)
      System.out.println("Posição de remoção inválida");
    else{
      Music removed = list[pos].clone();
      length--;
      for(int i = pos; i < length; i++)
        list[i] = list[i + 1];
      System.out.println("(R) " + removed.getName());
    }
  }
  
  public void removeLast(){
    if(length == 0)
      System.out.println("A playlist está vazia, não há itens para remover");
    else{
      Music removed = list[--length];
      System.out.println("(R) " + removed.getName());
    }
  }
}

//classe Music
class Music{
  //17 atributos da classe
  private String id;
  private String name;
  private String key;
  private ArrayList<String> artists = new ArrayList<String>();
  private SimpleDate release_date;
  private double acousticness;
  private double danceability;
  private double energy;
  private int duration_ms;
  private double instrumentalness;
  private double valence;
  private int popularity;
  private float tempo;
  private double liveness;
  private double loudness;
  private double speechiness;
  private int year;

  //construtores
  public Music(){

  }

  public Music(String id, String name, String key, String artistList, String release_date_string, double acousticness, 
   double danceability, double energy, int duration_ms, double instrumentalness, double valence,
   int popularity, float tempo, double liveness, double loudness, double speechiness, int year){

    setId(id);
    setName(name);
    setKey(key);
    setArtists(artistList);
    setRelease_date(release_date_string);
    setAcousticness(acousticness);
    setDanceability(danceability);
    setEnergy(energy);
    setDuration_ms(duration_ms);
    setInstrumentalness(instrumentalness);
    setValence(valence);
    setPopularity(popularity);
    setTempo(tempo);
    setLiveness(liveness);
    setLoudness(loudness);
    setSpeechiness(speechiness);
    setYear(year);
  }

  //metodos da classe
 
  public void imprimir(){
    System.out.println(toString()); 
  }

  public String toString(){
    String output = new String();
    output += (getId() + " ## " + this.artists + " ## " + this.name + " ## " + release_date.getSimpleDateFormat());
    output += (" ## " + this.acousticness + " ## " + this.danceability + " ## " + getInstrumentalness() + " ## " + this.liveness);
    output += (" ## " + this.loudness + " ## " + this.speechiness + " ## " + this.energy + " ## "+ this.duration_ms); 
    return output;
  }

  public Music clone(){
    Music cloneMusic = new Music();

    //copia de todos os atributos
    cloneMusic.id = this.id;
    cloneMusic.name = this.name;
    cloneMusic.artists = this.artists;
    cloneMusic.release_date = new SimpleDate(this.release_date.getYear() + "-" + this.release_date.getMonth() + "-" + this.release_date.getDay());
    cloneMusic.acousticness = this.acousticness;
    cloneMusic.danceability = this.danceability;
    cloneMusic.energy = this.energy;
    cloneMusic.duration_ms = this.duration_ms;
    cloneMusic.instrumentalness = this.instrumentalness;
    cloneMusic.valence = this.valence;
    cloneMusic.popularity = this.popularity;
    cloneMusic.tempo = this.tempo;
    cloneMusic.liveness = this.liveness;
    cloneMusic.loudness = this.loudness;
    cloneMusic.speechiness = this.speechiness;
    cloneMusic.year = this.year;

    return cloneMusic;
  }

  //metodo auxiliar para a formatacao de artistas
  public String formatArtists(String input){
    String output = new String();
    //tratamento de '
    output = input.replace("['","[");
    output = output.replace("']", "]");
    output = output.replace("',", ",");
    output = output.replace(" '", " ");
    
    //tratamento de []
    output = output.replace("[","");
    output = output.replace("]","");

    return output;
  }

  //metodos getters
  
  public String getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public String getKey(){
    return this.key;
  }

  public ArrayList<String> getArtists(){
    return this.artists;
  }
  
  public SimpleDate getRelease_date()
  {
    return this.release_date;
  }
  
  public double getAcousticness(){
    return this.acousticness;
  } 

  public double getDanceability(){
    return this.danceability;
  }

  public double getEnergy(){
    return this.energy;
  }

  public int getDuration_ms(){
    return this.duration_ms;
  }

  public double getInstrumentalness(){
    return this.instrumentalness;
  }

  public double getValence(){
    return this.valence;
  }

  public int getPopularity(){
    return this.popularity;
  }

  public float getTempo(){
    return this.tempo;
  }
  
  public double getLiveness(){
    return this.liveness;
  }

  public double getLoudness(){
    return this.loudness;
  }

  public double getSpeechiness(){
    return this.speechiness;
  }

  public int getYear(){
    return this.year;
  }

  //metodos setters
  
  public void setId(String id){
    this.id = id;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setKey(String key){
    this.key = key;
  }

  public void setArtists(String artistsList){
    artistsList = formatArtists(artistsList);
    String[] splittedList = artistsList.split(", "); 
    for(int i = 0; i < splittedList.length; i++)
      this.artists.add(splittedList[i]); 
  }
  
  public void setRelease_date(String input){
    this.release_date = new SimpleDate(input);
  }
  
  public void setAcousticness(double acousticness){
    this.acousticness = acousticness;
  }

  public void setDanceability(double danceability){
    this.danceability = danceability;
  }

  public void setEnergy(double energy){
    this.energy = energy;
  }

  public void setDuration_ms(int duration_ms){
    this.duration_ms = duration_ms;
  }

  public void setInstrumentalness(double instrumentalness){
    this.instrumentalness = instrumentalness;
  }

  public void setValence(double valence){
    this.valence = valence;
  }

  public void setPopularity(int popularity){
    this.popularity = popularity;
  }

  public void setTempo(float tempo){
    this.tempo =  tempo;
  }

  public void setLiveness(double liveness){
    this.liveness = liveness;
  }

  public void setLoudness(double loudness){
    this.loudness = loudness;
  }

  public void setSpeechiness(double speechiness){
    this.speechiness = speechiness;
  }

  public void setYear(int year){
    this.year = year;
  }
}

//classe criada exclusivamente para simplificar a manipulacao de datas do tp 02
class SimpleDate{
  private int day, month, year;
  
  public SimpleDate(){
    this("0001");
  }

  public SimpleDate(String dateString){
    int[] dateInfos = splitDate(dateString); 
    this.year = dateInfos[0];
    this.month = dateInfos[1];
    this.day = dateInfos[2];
  }
  
  public String getSimpleDateFormat(){
    return (String.format("%02d", getDay()) + "/" + String.format("%02d", getMonth()) + "/" + String.format("%04d",getYear()));
  }

  public static int[] splitDate(String input){
    int[] output = new int[3];

    //apenas ano
    if(input.length() == 4){
      output[0] = Integer.parseInt(input);//ano
      output[1] = 01;//mes 
      output[2] = 01;//dia
    } 
    
    //valores completos
    else{
      String[] auxData = input.split("-");
      output[0] =  Integer.parseInt(auxData[0]);
      output[1] =  Integer.parseInt(auxData[1]);
      output[2] =  Integer.parseInt(auxData[2]);
    }
    return output;
  }

  public int getYear(){
    return this.year;
  }

  public int getMonth(){
    return this.month;
  }

  public int getDay(){
    return this.day;
  }

  public void setYear(int year){
    this.year = year;
  }
  public void setMonth(int month){
    this.month = month;
  }
  public void setDay(int day){
    this.day = day;
  }
}
