public class CommandUse extends Command {
    private Worldmap worldmap;
    private Player player;

    public CommandUse(Worldmap worldmap, Player player) {
        super("use", "Uses an item from the inventory.");
        this.worldmap = worldmap;
        this.player = player;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: use <item_name>");
            return;
        }

        String itemName = String.join(" ", args); // pour gérer les noms à plusieurs mots
        Item itemToUse = null;

        for (Item item : player.getInventory().getInventory()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToUse = item;
                break;
            }
        }

        if (itemToUse == null) {
            System.out.println("You don't have that item.");
            return;
        }

        if (itemToUse instanceof Key) {
            Key key = (Key) itemToUse;
            key.use(); // déverrouille la location cible
            player.getInventory().removeItem(key); // retirer la clé de l'inventaire
            System.out.println("The key has been removed from your inventory.");
        } else {
            System.out.println("This item cannot be used.");
        }
    }
}
