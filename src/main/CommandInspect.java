public class CommandInspect extends Command {
    private Player player;

    public CommandInspect(Player player) {
        super("inspect", "Inspect an item and get its description");
        this.player = player;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: inspect <item name>");
            return;
        }

        String itemName = String.join(" ", args);
        Item item = player.getItemByName(itemName);

        if (item == null) {
            System.out.println("You don't have an item named \"" + itemName + "\".");
        } else {
            item.inspect();
        }
    }
}
