
import java.util.Scanner;

public class Game {
    private CommandRegistry registry;
    private Worldmap worldmap;
    private Player player;
    

    public Game() {
        System.out.println("Initializing game...");
        registry = new CommandRegistry(); // Instanciation du registre
        worldmap = WorldBuilder.buildWorld();
        player = new Player("player1");
    }

    public void run() {
        System.out.println("Running game...");

        // Ajouter la commande "help"
        registry.addCommand("help", new CommandHelp(registry));

        // registry.addCommand(name:"look", new CommandLook(registry));
        // Créer la commande move et l'ajouter
        registry.addCommand("move", new CommandMove(worldmap));
        registry.addCommand("map", new CommandMap(worldmap));


        
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
