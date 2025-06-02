public class CommandUse implements ICommand {

    private Player player;

    public CommandUse(Player player) {
        this.player = player;
    }

    @Override
    public String getVerb() {
        return "use";
    }

    @Override
    public String getDescription() {
        return "permet d'utiliser un objet";
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Quel objet voulez-vous utiliser ?");
            return;
        }

        String itemName = String.join(" ", args); // ex : "Clé de la grotte"

        Item item = player.getInventory().stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);

        if (item == null) {
            System.out.println("Vous n'avez pas cet objet.");
            return;
        }

        if (item instanceof Key) {
            ((Key) item).use();
        } else {
            System.out.println("Cet objet ne peut pas être utilisé.");
        }
    }
}