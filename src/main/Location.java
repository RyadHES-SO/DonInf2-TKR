import java.util.ArrayList;
import java.util.List;

import utils.IPrintable;

public class Location implements IPrintable {
    private String name;
    private String description;
    private boolean state; // true = déverrouillé, false = verrouillé
    private List<Item> itemLocation;

    public Location(String name, String description, boolean state) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.itemLocation = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getState() {
        return state;
    }

    public void unlock() {
        this.state = true;
    }

    public void lock() {
        this.state = false;
    }

    public void addItem(Item item) {
        itemLocation.add(item);
    }

    public void removeItem(Item item) {
        itemLocation.remove(item);
    }

    public List<Item> getItems() {
        return itemLocation;
    }

    // === IPrintable ===
    @Override
    public String getPrintableString() {
        return state ? "O" : "X"; // O = déverrouillé, X = verrouillé
    }

    @Override
    public boolean isGrayedOut() {
        return !state;
    }
}
