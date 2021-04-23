import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

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

  public static String[] ler(String path, int maxMusicNumber)throws IOException{
    String[] musicList = new String[170653];
    int i = 0;
    BufferedReader br = new BufferedReader(new FileReader(path));
    br.readLine(); //primeira linha do arquivo desprezada
    while(i < maxMusicNumber){ 
      musicList[i] = br.readLine();
      i++;
    }
    return musicList;
  } 

 
  public void imprimir(){
    MyIO.print(getId() + " ## " + this.artists + " ## " + this.name + " ## " + release_date.getSimpleDateFormat());
    MyIO.print(" ## " + this.acousticness + " ## " + this.danceability + " ## " + getInstrumentalness() + " ## " + this.liveness);
    MyIO.println(" ## " + this.loudness + " ## " + this.speechiness + " ## " + this.energy + " ## "+ this.duration_ms); 
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
