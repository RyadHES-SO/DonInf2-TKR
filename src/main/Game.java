import java.util.Scanner;

public class Game {
    private CommandRegistry registry;
    private Worldmap worldmap;
    private Player player;
    private Scanner scanner; // Scanner unique partagé

    public Game() {
        // Création des instances
        System.out.println("Initializing game...");
        registry = new CommandRegistry();
        worldmap = WorldBuilder.buildWorld();
        player = new Player("player1");
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Running game...");

        // Ajout des commandes au registery
        registry.addCommand("help", new CommandHelp(registry));
        registry.addCommand("move", new CommandMove(worldmap));
        registry.addCommand("map", new CommandMap(worldmap));
        registry.addCommand("look", new CommandLook(worldmap));
        registry.addCommand("take", new CommandTake(worldmap, player));
        registry.addCommand("use", new CommandUse(player, scanner));
        registry.addCommand("say", new CommandSay());
        registry.addCommand("inspect", new CommandInspect(player));
        registry.addCommand("inventory", new CommandInventory(player.getInventory()));

        // Boucle d'écoute des commandes
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit"))
                break;

            registry.executeCommand(input);
        }

        System.out.println("Game ended.");
        scanner.close(); // fermeture du scanner à la fin
    }
}
