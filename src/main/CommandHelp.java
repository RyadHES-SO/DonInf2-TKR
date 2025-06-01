

public class CommandHelp implements ICommand {

    private CommandRegistry registry;

    public CommandHelp(CommandRegistry registry) {
        this.registry = registry;
    }

    @Override
    public String getVerb() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "permet d'afficher toutes les commandes";
    }

    @Override
    public void execute(String[] args) {
        registry.printHelp();
    }
}
