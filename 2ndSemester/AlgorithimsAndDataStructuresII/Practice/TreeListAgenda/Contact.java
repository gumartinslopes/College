class Contact{
  private String name, cellPhoneNumber, email;
  int cpf;

  public Contact(String name, String cellPhoneNumber, String email, int cpf){
    this.name = name;
    this.cellPhoneNumber = cellPhoneNumber;
    this.email = email;
    this.cpf = cpf;
  }

  //getters
  public String getName(){
    return this.name;
  }
  
  public String getCellPhoneNumber(){
    return this.cellPhoneNumber;
  }

  public String getEmail(){
    return this.email;
  }

  public int getCpf(){
    return this.cpf;
  }

  //setters
  public void setName(String name){
    this.name = name;
  }

  public void setCellPhoneNumber(String cellPhoneNumber){
    this.cellPhoneNumber = cellPhoneNumber;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public void setCpf(int cpf){
    this.cpf = cpf;
  }

  public Contact clone(){
    Contact clone = new Contact(this.name, this.cellPhoneNumber, this.email, this.cpf);
    return clone;
  }
}
