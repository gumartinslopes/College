//classe criada exclusivamente para simplificar a realizacao do tp 02
public class SimpleDate{
  private int day, month, year;
  
  public SimpleDate(){
    this(01,01,01);
  }

  public SimpleDate(int year){
    this(year, 01,01);
  }

  public SimpleDate(int year,int month){
    this(year, month, 01);
  }

  public SimpleDate(int year,int month, int day){
    setYear(year);
    setMonth(month);
    setDay(day);
  }
  
  public String getSimpleDateFormat(){
    return (String.format("%02d", getDay()) + "/" + String.format("%02d", getMonth()) + "/" + String.format("%04d",getYear()));
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
