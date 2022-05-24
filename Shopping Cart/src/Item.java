import java.text.NumberFormat;
import java.util.Objects;

public class Item {
    private String name;
    private double price;
    private int bulkQty;
    private double bulkPrice;
    public Item(String name, double price){
        this(name, price, 0, 0);
    }
    public Item(String name, double price, int bulkQty, double bulkPrice) throws IllegalArgumentException{
        if(price<0||bulkQty<0||bulkPrice<0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
        this.bulkQty = bulkQty;
        this.bulkPrice = bulkPrice;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double priceFor(int quantity) throws IllegalArgumentException{
        if(quantity<0){
            throw new IllegalArgumentException();
        }
        if(quantity>=bulkQty&&bulkQty>0){
            return quantity*bulkPrice;
        }else{
            return quantity*price;
        }
    }

    public int getBulkQty() {
        return bulkQty;
    }

    public double getBulkPrice() {
        return bulkPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, bulkQty, bulkPrice);
    }

    @Override
    public String toString() {
        String info = name + ", " + NumberFormat.getCurrencyInstance().format(price);
        if(bulkPrice>0 && bulkQty>0){
            info+=" " + bulkQty + " for " + NumberFormat.getCurrencyInstance().format(bulkPrice);
        }
        return info;
    }
}
