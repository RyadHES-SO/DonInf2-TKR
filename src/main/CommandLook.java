public class CommandLook extends Command {
    private CommandRegistry registry;

    public CommandLook(CommandRegistry registry) {
        super("look", "Permet d'examiner l'environnement.");
    }

    @Override
    public void execute(String[] args) {
        registry.printHelp();
    }

}
