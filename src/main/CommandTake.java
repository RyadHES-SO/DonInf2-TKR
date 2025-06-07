import java.util.List;

public class CommandTake extends Command {

    private Worldmap worldmap;
    private Player player;

    public CommandTake(Worldmap worldmap, Player player) {
        super("take", "Takes an item from the current location and puts it in your inventory");
        this.worldmap = worldmap;
        this.player = player;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("What item do you want to take?");
            return;
        }

        String itemName = String.join(" ", args); // supports multi-word names

        Location currentLocation = worldmap.getPlayerLocation();
        List<Item> items = currentLocation.getItems();

        Item item = items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);

        if (item == null) {
            System.out.println("This item is not here.");
            return;
        }

        currentLocation.removeItem(item);
        player.addItem(item);
        System.out.println("You picked up: " + item.getName());
    }
}
