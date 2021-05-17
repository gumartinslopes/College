public class Node{
  public char letter;
  public Node left, right;
  public SubNode subRoot;

  public Node(char letter){
    this(letter, null, null);
  }

  public Node(char letter, Node left, Node right){
    this.letter = letter;
    this.left = left;
    this.right = right;
    this.subRoot = null;
  }

  public void insertOnSubtree(String word)throws Exception{
    subRoot = insertOnSubtree(word, subRoot);
  }
  
  public SubNode insertOnSubtree(String word, SubNode sn)throws Exception{
    if(sn == null)
      sn = new SubNode(word);
    else if(word.compareTo(sn.getWord()) < 0)
      sn.sub_left = insertOnSubtree(word, sn.sub_left);
    else if(word.compareTo(sn.getWord()) > 0)
      sn.sub_right = insertOnSubtree(word, sn.sub_right);
    else 
      throw new Exception("The word " + word + " is already inside your tree");
    return sn;
  }
  
  public void removeSubNode(String word)throws Exception{
    subRoot = removeSubNode(word, subRoot);
  }

  public SubNode removeSubNode(String word, SubNode sn)throws Exception{
    if(sn == null)
      throw new Exception("This word is not on your tree");
    else if(word.compareTo(sn.getWord()) < 0)
      sn.sub_left = removeSubNode(word, sn.sub_left);
    else if(word.compareTo(sn.getWord()) > 0)
      sn.sub_right = removeSubNode(word, sn.sub_right);
    else
      sn.sub_left = getPredecessor(sn, sn.sub_left);
    return sn;
  }

  private SubNode getPredecessor(SubNode i, SubNode j){
    if(j.sub_right == null){
      i.setWord(j.getWord());
      j = j.sub_left;
    }
    else 
      j.sub_right = getPredecessor(i, j.sub_right);

    return j;
  }

  public void displaySubTree(){
    displaySubtree(subRoot);
  }

  public void displaySubtree(SubNode currentSubNode){
    if(currentSubNode != null){ 
      displaySubtree(currentSubNode.sub_left);
      System.out.println("\t" + currentSubNode.getWord());
      displaySubtree(currentSubNode.sub_right);
    } 
  }
}
