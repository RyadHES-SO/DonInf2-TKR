public class CommandHelp implements ICommand {

    private CommandRegistry registry;

    public CommandHelp(CommandRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void execute(String[] args) {
        registry.printHelp();
    }
}

