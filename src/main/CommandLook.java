import java.util.List;

public class CommandLook extends Command {
    private Location location;

    public CommandLook(Location location) {
        super("look", "Permet d'examiner l'environnement.");
        this.location = location;
    }

    @Override
    public void execute(String[] args) {
        // Affiche la description de la zone
        System.out.println(location.getDescription());

        // Récupère les objets dans la zone
        List<Item> items = location.getItems();
        
        if (items.isEmpty()) {
            System.out.println("Il n'y a rien d'intéressant ici.");
        } else {
            System.out.println("Tu vois les objets suivants :");
            for (Item item : items) {
                System.out.println("- " + item.getName());
            }
        }
    }
}
