import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ItemOrder> itemOrders;
    ShoppingCart(){
        itemOrders  = new ArrayList<>();
    }
    public void add(ItemOrder newOrder){
        int index = itemOrders.indexOf(newOrder);
        if(itemOrders.contains(newOrder)){
            itemOrders.remove(index);
        }
        itemOrders.add(newOrder);
    }
    public double getTotal(){
        double total = 0;
        for(ItemOrder itemOrder:itemOrders){
            total+=itemOrder.getPrice();
        }
        return total;
    }
}
