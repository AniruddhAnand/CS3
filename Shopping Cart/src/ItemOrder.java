import java.util.Objects;

public class ItemOrder {
    private Item item;
    private int qty;
    ItemOrder(Item item, int qty){
        this.item  = item;
        this.qty = qty;
    }
    public double getPrice(){
        return item.priceFor(qty);
    }
    Item getItem(){
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemOrder itemOrder = (ItemOrder) o;
        return item.equals(itemOrder.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, qty);
    }
}
