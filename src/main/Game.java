package main;
import java.util.Scanner;

public class Game {
    private CommandRegistry registry;

    public Game(){
        System.out.println("Initializing game...");
        registry = new CommandRegistry();  // Instanciation du registre
        Worldmap worldmap = WorldBuilder.buildWorld();
        Player player1 = new Player("player1");
    }
    
    public void run() {
        System.out.println("Running game...");
        
        // Ajouter la commande "help"
        registry.addCommand("help", new CommandHelp(registry));
       // registry.addCommand(name:"look", new CommandLook(registry));

        // Boucle d'écoute des commandes
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;

            registry.executeCommand(input);
        }

        System.out.println("Game ended.");
    }
}
