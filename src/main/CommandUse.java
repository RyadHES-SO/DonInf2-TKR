public class CommandUse extends Command {

    private Player player;

    public CommandUse(Player player) {
        super("use", "Permet d'utiliser un objet de l'inventaire");
        this.player = player;
    }

    @Override
public void execute(String[] args) {
    if (args.length == 0) {
        System.out.println("Quel objet voulez-vous utiliser ?");
        return;
    }

    String itemName = String.join(" ", args).toLowerCase();

    Item foundItem = null;
    // Parcours simple de la liste d'items dans l'inventaire
    for (Item item : player.getInventory().getInventory()) {
        if (item.getName().equalsIgnoreCase(itemName)) {
            foundItem = item;
            break;
        }
    }

    if (foundItem == null) {
        System.out.println("Vous n'avez pas d'objet nommé \"" + itemName + "\".");
        return;
    }

    if (foundItem instanceof Key) {
        ((Key) foundItem).use();
    } else {
        System.out.println("Cet objet ne peut pas être utilisé.");
    }
}}


