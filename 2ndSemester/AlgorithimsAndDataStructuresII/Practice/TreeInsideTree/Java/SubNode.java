public class SubNode{
  private String sub_word;
  public SubNode sub_left, sub_right;

  public SubNode(String word){
    this(word, null, null);
  }
  
  public SubNode(String word, SubNode left, SubNode right){
    this.sub_word = word;
    this.sub_left = left;
    this.sub_right = right;
  }
  
  public String getWord(){
    return this.sub_word;
  }
  public void setWord(String word){
    this.sub_word = word;
  }
}
