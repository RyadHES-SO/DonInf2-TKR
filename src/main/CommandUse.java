import java.util.List;

public class CommandUse extends Command {

    private Player player;

    public CommandUse(Player player) {
        super("use", "Use an item, such as a key to unlock a location");
        this.player = player;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Which item do you want to use?");
            return;
        }

        String itemName = String.join(" ", args);


        Item item = player.getItems().stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);


        if (item == null) {
            System.out.println("You don't have this item.");
            return;
        }

        if (item instanceof Key) {
            ((Key) item).use();
        } else {
            System.out.println("This item cannot be used.");
        }
    }
}
