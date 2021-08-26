import java.io.Console;

public class Main {
    public static void main(String[] args){
        Box<Item> toyBox = new Box<>();
        Box<String> puzzleBox = new Box<>();
        puzzleBox.armazena("Chicken");
        Item toy = new Item("doll", 20);
        toyBox.armazena(toy);

        System.out.println(puzzleBox.recupera());
        System.out.println(toyBox.recupera());
    }
}
