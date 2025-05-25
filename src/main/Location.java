package main;
import java.util.ArrayList;
import java.util.List;

public class Location {
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

}
