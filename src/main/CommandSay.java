public class CommandSay extends Command {

    public CommandSay() {
        super("say", "Allows the player to speak in the game");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("You said nothing.");
            return;
        }

        String message = String.join(" ", args);
        System.out.println("You say: " + message);
    }
}