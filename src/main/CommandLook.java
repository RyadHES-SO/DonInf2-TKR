import java.util.List;

public class CommandLook extends Command {
    private Worldmap worldmap;

    public CommandLook(Worldmap worldmap) {
        super("look", "Displays the items in the current location");
        this.worldmap = worldmap;
    }

    @Override
    public void execute(String[] args) {
        Location currentLocation = worldmap.getPlayerLocation();


        List<Item> items = currentLocation.getItems();

        if (items.isEmpty()) {
            System.out.println("There are no items here.");
        } else {
            System.out.println("Items present:");
            for (Item item : items) {
                System.out.println("- " + item.getName());
            }
        }
    }
}
