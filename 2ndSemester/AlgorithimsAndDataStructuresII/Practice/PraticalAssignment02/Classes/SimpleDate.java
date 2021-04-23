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
