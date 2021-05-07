import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
/*
Questão 09: QuickSort Lista Flex Dupla java 
Author: Gustavo Martins Lopes da Costa
Matricula: 690773
*/

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
      myTracks.sort();
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

//classe celula dupla
class DoubleCell{
  public Music element;
  public DoubleCell next, prev;
  
  public DoubleCell(){
    this(new Music());
  }

  public DoubleCell(Music m){
    element = m.clone();
    next = null;
    prev = null;
  }
}

//classe lista
class Playlist{
  private DoubleCell first, last;
  private int log_comparisons, log_moves;

  public Playlist(){
    first = new DoubleCell();
    last = first;
  }
  
  public void display(){
    for(DoubleCell i = first.next; i != null; i = i.next)
      MyIO.println(i.element.toString());
  } 

  public void insertFirst(Music m){
    DoubleCell aux = new DoubleCell(m); 
    aux.prev = first;
    aux.next = first.next;
    first.next = aux;
    if(first == last)
      last = aux;
    else
      aux.next.prev = aux;
    aux = null;
  }

  public void insertLast(Music m){
    last.next = new DoubleCell(m.clone());
    last.next.prev = last;
    last = last.next;
  }
  
  public int getLength(){
    int counter = 0;
    for(DoubleCell i = first; i != last; i = i.next, counter++);
    return counter;
  }

  public void insertPos(int pos, Music m){
    int  playlistLength = getLength();
    if(pos < 0 || pos > playlistLength)
      MyIO.println("Posicao invalida, impossivel inserir");
    else if(pos == playlistLength)
      insertLast(m);
    else if(pos == 0)
      insertFirst(m);
    else {
      DoubleCell i = first;
      for(int j = 0; j < pos; j++, i = i.next);//caminhamento pela lista
      DoubleCell aux = new DoubleCell(m);
      aux.prev = i;
      aux.next = i.next;
      aux.prev.next = aux.next.prev = aux;
      aux = i = null;
    }
  }
  
  public void removeFirst(){
    if(last == first)
      MyIO.println("Playlist vazia, impossível remover");
   
    else{
      DoubleCell aux = first.next;
      first.next = first.next.next;
      Music removed = aux.element.clone();
      aux.next = first.prev = null;
      aux = null;  
      MyIO.println("(R) " + removed.getName());
    }
  }
  
  public void removeLast(){
    if(first == last)
      MyIO.println("Playlist vazia impossivel remover");
    else{  
      Music removed = last.element.clone();
      last = last.prev;
      last.next.prev = null;
      last.next = null;
      MyIO.println("(R) " + removed.getName());
    }
  }

  public void removePos(int pos){
    int  playlistLength = getLength();
    if(first == last)
      MyIO.println("Playlist vazia, impossivel remover");
    else if(pos < 0 || pos > playlistLength)
      MyIO.println("Posicao invalida, impossivel remover");
    else if(pos == playlistLength - 1)
      removeLast();
    else if(pos == 0)
      removeFirst();
    else {
      DoubleCell i = first.next;
      for(int j = 0; j < pos; j++, i = i.next);//caminhamento pela lista
      i.prev.next = i.next;
      i.next.prev = i.prev;
      Music removed = i.next.element.clone();
      i.next.prev = null;
      i=null;
      MyIO.println("(R) " + removed.getName());
    }
  }

  public DoubleCell getCell(int pos){
    DoubleCell i = first.next;
    for(int counter = 0; counter < pos; counter++)
      i = i.next;
    return i;
  }

  private void createLog(long executionTime, String filepath)throws Exception{
    BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
    bw.write("690773\t" + "\t" + log_comparisons + "\t" +  log_moves  + "\t" + executionTime);
    bw.close();    
  }
  
  private void swap(DoubleCell a, DoubleCell b){
    DoubleCell aux  = new DoubleCell(a.element);
    a.element = b.element.clone();
    b.element = aux.element.clone();
  }

  private boolean isMinorThan(DoubleCell a, DoubleCell b){
    boolean result;
    if(a.element.getDuration_ms() < b.element.getDuration_ms()){
      result = true;
      log_comparisons++;
    }
    else if(a.element.getDuration_ms() == b.element.getDuration_ms()){
      result = (a.element.getName().compareTo(b.element.getName()) < 0)? true : false;
      log_comparisons++;
    }
    else 
      result = false;
    return result;
  }
  
  public void sort()throws Exception{
    long begin = System.currentTimeMillis();
    quicksort(0, getLength() - 1);
    long end = System.currentTimeMillis();
    createLog((end - begin), "690773_quicksort2.txt");
  }
  
  private void quicksort(int left, int right){
    int i = left, j = right;
    DoubleCell pivot = new DoubleCell(getCell(((left + right) / 2)).element);

    while(i <= j){
      while(isMinorThan(getCell(i), pivot))
        i++;
      while(isMinorThan(pivot, getCell(j)))
        j--;
      if(i <= j){
        swap(getCell(i), getCell(j));
        log_moves++;
        i++;
        j--;
      }
    }
    if(left < j)
      quicksort(left, j);
    if(i < right)
      quicksort(i, right);
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
      this.release_date = new SimpleDate();
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
    MyIO.println(toString()); 
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
