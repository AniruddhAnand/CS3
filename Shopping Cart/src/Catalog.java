import java.util.ArrayList;

public class Catalog {
    private String name;
    private ArrayList<Item> items;
    Catalog(String name){
        this.name = name;
        items = new ArrayList<>();
    }
    public void add(Item item){
        items.add(item);
    }

    public int size(){
        return items.size();
    }
    public Item get(int index){
        return items.get(index);
    }
    String getName(){
        return name;
    }
}
