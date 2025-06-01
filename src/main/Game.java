
import java.util.Scanner;

public class Game {
    private CommandRegistry registry;
    private Worldmap worldmap;
    

    public Game() {
        System.out.println("Initializing game...");
        registry = new CommandRegistry(); // Instanciation du registre
        worldmap = WorldBuilder.buildWorld();
        Player player1 = new Player("player1");
    }

    public void run() {
        System.out.println("Running game...");

        // Ajouter la commande "help"
        registry.addCommand("help", new CommandHelp(registry));
        // registry.addCommand(name:"look", new CommandLook(registry));
        // Créer la commande move et l'ajouter
        CommandMove moveAction = new CommandMove(worldmap);
        Command moveCommand = new Command("move", "Déplace le joueur (north, south, east, west)", moveAction);
        registry.addCommand("move", moveCommand);

        // ajout Teicir -- commande Use : //

        CommandUse useAction = new CommandUse(player); // tu utilises le player déclaré dans Game
        Command useCommand = new Command("use", "Utilise un objet de l'inventaire", useAction);
        registry.addCommand("use", useCommand);

        // Boucle d'écoute des commandes
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit"))
                break;

            registry.executeCommand(input);
        }

        System.out.println("Game ended.");
    }
}
