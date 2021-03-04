public class Music{
  //16 atributos da classe
  private String id;
  private String name;
  private String key;
  private String[] artists;
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

  public Music(){

  }

  public Music(String id, String name, String key, String[] artists, SimpleDate release_date, double acousticness, 
   double danceability, double energy, int duration_ms, double instrumentalness, double valence,
   int popularity, float tempo, double liveness, double loudness, double speechiness, int year){

    setId(id);
    setName(name);
    setKey(key);
    setArtists(artists);
    setRelease_date(release_date.getYear(), release_date.getMonth(), release_date.getSimpleDate());
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

  public String ler(String id, String path){
    String output = new String();
    Arq.openRead(path);
    do{
      output = Arq.readLine();
    }while(output.contains(id) == false);

    return output;
  }
  public static String[] mySplit(String input, int size){
    String aux = new String();
    String[] output = new String[size];
    int i, j;
    i = j = 0;

    while(i <= input.length() && j < size){
      //checagem de artista
      if(i == input.length() || input.charAt(i) == ','){
        output[j] = aux;
        aux = new String();
        j++;
      }

      else if(input.charAt(i) == '['){
        i++;
        do{
          aux += input.charAt(i);
          i++;
        }while(input.charAt(i) != ']');  
      }

      else if(input.charAt(i) == '"'){
        i++;
        do{
          aux += input.charAt(i);
          i++;
        }while(input.charAt(i) != '"');  
      }

      else{
        aux+= input.charAt(i);
      }
      i++;
    }
    return output;
  }

  public void registrar(String dadosNaoFormatados){
    String[] atributos = mySplit(dadosNaoFormatados, 19);     //total de 19 atributos no arquivo porem 2 nao serao registrados
    setValence(Double.parseDouble(atributos[0]));
    setYear(Integer.parseInt(atributos[1]));
    setAcousticness(Double.parseDouble(atributos[2]));
   // setArtists();
    setDanceability(Double.parseDouble(atributos[4]));
    setDuration_ms(Integer.parseInt(atributos[5]));
    setEnergy(Double.parseDouble(atributos[6]));
    //skip explicit
    setId(atributos[8]);
    setInstrumentalness(Double.parseDouble(atributos[9]));
    setKey(atributos[10]);
    setLiveness(Double.parseDouble(atributos[11]));
    setLoudness(Double.parseDouble(atributos[12]));
    //skip mode
    setName(atributos[14]);
    setPopularity(Integer.parseInt(atributos[15]));
    int[] data = splitData(atributos[16]);
    setRelease_date(data[0], data[1], data[2]);
    setSpeechiness(Double.parseDouble(atributos[17]));
    setTempo(Float.parseFloat(atributos[18]));
  }

  public void testPrint(){
    MyIO.println("Valence " + getValence());
    MyIO.println("year "+ getYear());
    MyIO.println("Acousticness " + getAcousticness());
//    MyIO.println(getArtists());
    MyIO.println("Danceability " + getDanceability());
    MyIO.println("Duration " + getDuration_ms());
    MyIO.println("Energy " + getEnergy());
    MyIO.println("Id " + getId());
    MyIO.println("Instrumentalness " + getInstrumentalness());
    MyIO.println("Key " + getKey());
    MyIO.println("Liveness " + getLiveness());
    MyIO.println("Loudness " + getLoudness());
    MyIO.println("Name " + getName());
    MyIO.println("Popularity " + getPopularity());
    MyIO.println("Release " + getRelease_date().getSimpleDateFormart());
    MyIO.println("Speechiness " + getSpeechiness());
    MyIO.println("Tempo " + getTempo());
  }

  public void imprimir(){
    MyIO.println(getId() + " ## " + getName() + " ## " + getAcousticness() + " ## " + getDanceability() + " ## ");
    MyIO.println(getInstrumentalness() + " ## " + getLiveness() + " ## " + getLoudness() + " ## " + getSpeechiness() + " ## ");
    MyIO.println(getEnergy() + " ## "+ getDuration_ms());
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

  public String[] getArtists(){
    return this.artists;
  }
  
  public SimpleDate getRelease_SimpleDate()
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

  public void setArtists(String[] artists){
    this.artists = artists;
  }
  
  public void setRelease_date(int year, int month, int day){
    this.release_date = new SimpleDate(year, month, day);
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
