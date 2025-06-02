public class CommandHelp extends Command {
    private CommandRegistry registry;

    public CommandHelp(CommandRegistry registry) {
        super("help", "Permet d'afficher toutes les commandes");
        this.registry = registry;
    }

    @Override
    public void execute(String[] args) {
        registry.printHelp();
    }
}
