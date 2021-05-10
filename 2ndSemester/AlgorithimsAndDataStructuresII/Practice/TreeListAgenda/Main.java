public class Main{
  public static void main(String []args){
    try{
      Agenda contatinhos = new Agenda();
      Contact []listaDeContatinhos = new Contact[20];
      getContacts(listaDeContatinhos);

      for(int i = 0; i < 20; i++)
        contatinhos.insertContact(listaDeContatinhos[i]);
      contatinhos.display();
    }catch(Exception ex){
      System.out.println(ex.getMessage());
      ex.printStackTrace();
    }
  }

  public static void getContacts(Contact[] lista){
    lista[0] = new Contact("Tio Sukita", "+55 313131-3232", "mePassaEmAedsII@gmail.com", 45);
    lista[1] = new Contact("Arnold Shwarzenegger" ,"+55 313131-4545", "pumpIron@gmail.com", 5);
    lista[2] = new Contact("Chuck Norris", "+55 66666 - 6666", "bigBoss@gmail.com", 666);
    lista[3] = new Contact("HanSolo", "+55 7878-7878", "12parsecs@gmail.com",4455);
    lista[4] = new Contact("Julia", "+55 31 8839-3132", "jingleJu@gmail.com", 78988);
    lista[5] = new Contact("Linus Torwalds", "+55 31 7898-8964", "windowsSucks@gmail.com", 4565);
    lista[6] = new Contact("Elon Musk", "+55 31 7891-1011", "toTheMun@gmail.com", 455);
    lista[7] = new Contact("Luis Armstrong", "+55 31 5454-5454", "whatAWonderfullWorld@gmail.com", 8888);
    lista[8] = new Contact("Patolino", "+55 45 6664-6661", "vaCacarCoelho@gmail.com", 788898);
    lista[9] = new Contact("Dwaine Jhonson", "+55 78 6545-5466", "theRockIsCooking@gmail.com", 78787); 
    lista[10] = new Contact("McKaverinha", "+55 78 6545-5778", "skrr@gmail.com", 7877); 
    lista[11] = new Contact("Eric Clapton", "+55 78 6545-8888", "laaayla@gmail.com", 78787);
    lista[12] = new Contact("James Hatfield", "+55 78 6545-7788", "masterOfPuppets@gmail.com",666666); 
    lista[13] = new Contact("RAffa Moreira", "+55 78 6545-7771", "fernandoClothin@gmail.com", 777);
    lista[14] = new Contact("Eric Idle", "+55 78 888-8888", "spamspamspam@gmail.com", 9888);
    lista[15] = new Contact("Bruce Wayne", "+55 12 3567-8998", "darkNight@gmail.com", 665654);
    lista[16] = new Contact("Peter Parker", "+55 13 4555-4788", "friendlyNeibourgh", 5555); 
    lista[17] = new Contact("Clarke Kent", "+55 78 7775-8888", "notSuperman@gmail.com", 78888);
    lista[18] = new Contact("Ronald Drump", "+55 78 6665-6668", "notTrump@gmail.com", 111111);
    lista[19] = new Contact("This Guy", "+55 78 8885-8888", "notThatGuy@gmail.com", 444488);
  }
}
