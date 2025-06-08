import java.util.Scanner;

public class CommandUse extends Command {
    private Player player;
    private Scanner scanner; // scanner partagé

    public CommandUse(Player player, Scanner scanner) {
        super("use", "Uses an item from the inventory.");
        this.player = player;
        this.scanner = scanner; // on garde la référence
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: use <item name>");
            return;
        }

        String itemName = String.join(" ", args);
        Item itemToUse = player.getItemByName(itemName);

        if (itemToUse == null) {
            System.out.println("You don't have an item named \"" + itemName + "\".");
            return;
        }

        if (itemToUse instanceof Key) {
            Key key = (Key) itemToUse;
            key.use();
            player.getInventory().removeItem(key);
            System.out.println("The key has been removed from your inventory.");
        } else if (itemToUse instanceof Letter) {
            Letter letter = (Letter) itemToUse;
            boolean solved = letter.use(scanner, player);
            if (solved) {
                player.getInventory().removeItem(letter);
                System.out.println("The letter has been removed from your inventory.");
            }
        } else {
            System.out.println("This item cannot be used.");
        }
    }
}
