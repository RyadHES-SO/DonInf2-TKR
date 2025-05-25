package main;

public class Player {
    private String name;
    private Inventory inventory;

    public Player(String nom) {
        this.name = nom;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
