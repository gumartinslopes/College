public class Cell{
  public Contact contact;
  public Cell next;
 
  public Cell(Contact contact){
    this(contact, null);
  }

  public Cell(Contact contact, Cell next){
    this.contact = contact.clone();
    this.next = next;
  }

  //construtor de testes
  public Cell(){
    this.contact = new Contact("Jhon Doe", "+00 000000-0000", "jhonDoe@gmail.com", 0);
    this.next = null;
  }
}
