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

    public void addItem(Item item) {
        inventory.addItem(item);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
