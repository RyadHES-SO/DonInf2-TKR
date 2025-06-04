public class CommandHelp extends Command {
    private CommandRegistry registry;

    public CommandHelp(CommandRegistry registry) {
        super("help", "Displays all available commands");
        this.registry = registry;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Available commands:");
        for (ICommand cmd : registry.getCommands().values()) {
            System.out.printf("- %s : %s%n", cmd.getVerb(), cmd.getDescription());
        }
    }
}
