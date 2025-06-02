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

        Item item = player.getItems().stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);

        if (item == null) {
            System.out.println("Vous n'avez pas d'objet nommé \"" + itemName + "\".");
            return;
        }

        if (item instanceof Usable usableItem) {
            usableItem.use(player);  // Option : passer le joueur ou la map si nécessaire
        } else if (item instanceof Key key) {
            key.use();  // Si la clé n'a pas besoin d'argument
        } else {
            System.out.println("Cet objet ne peut pas être utilisé.");
        }
    }
}
