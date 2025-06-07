import java.util.List;

public class CommandInventory extends Command {
    private Inventory inventory;

    public CommandInventory(Inventory inventory) {
        super("inventory", "Displays the player's inventory.");
        this.inventory = inventory;
    }

    @Override
    public void execute(String[] args) {
        List<Item> items = inventory.getInventory();
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : items) {
                System.out.println("- " + item.getName());
            }
        }
    }
}
