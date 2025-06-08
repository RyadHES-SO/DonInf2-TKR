import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }
}