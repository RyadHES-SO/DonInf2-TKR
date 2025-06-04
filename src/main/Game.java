import java.util.Scanner;

public class Game {
    private CommandRegistry registry;
    private Worldmap worldmap;
    private Player player;

    public Game() {
        System.out.println("Initializing game...");
        registry = new CommandRegistry();
        worldmap = WorldBuilder.buildWorld();
        player = new Player("player1");

        registry.addCommand("help", new CommandHelp(registry));
        registry.addCommand("move", new CommandMove(worldmap));
        registry.addCommand("use", new CommandUse(player));
    }

    public void run() {
        System.out.println("Starting game...");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            worldmap.displayMap(); // Display map each turn

            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Game ended.");
                break;
            }

            registry.executeCommand(input);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
