
import java.util.Scanner;

public class Game {
    private CommandRegistry registry;
    private Worldmap worldmap;
    private Player player;
    private Inventory inventory;
    

    public Game() {
        System.out.println("Initializing game...");
        registry = new CommandRegistry(); // Instanciation du registre
        worldmap = WorldBuilder.buildWorld();
        player = new Player("player1");
        inventory = new Inventory();
    }

    public void run() {
        System.out.println("Running game...");

        // Ajoute les commandes
        registry.addCommand("help", new CommandHelp(registry));
        registry.addCommand("move", new CommandMove(worldmap));
        registry.addCommand("map", new CommandMap(worldmap));
        registry.addCommand("look", new CommandLook(worldmap));
        registry.addCommand("take", new CommandTake(worldmap, player));
        registry.addCommand("use", new CommandUse(player));
        registry.addCommand("inspect", new CommandInspect(player));
        registry.addCommand("inventory", new CommandInventory(inventory));



        
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
