public class Item {
    private String name;
    private float value;
    public Item(String name, float value){
        this.name = name;
        this.value = value;
    }
    public String toString(){
        return (this.name + ": " + this.value);
    }
}
