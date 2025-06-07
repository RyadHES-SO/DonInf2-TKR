
public class CommandInspect extends Command {
    private Player player;

    // Constructeur : on appelle super avec verb et description
    public CommandInspect(Player player) {
        super("inspect", "Inspect an item and get its description");
        this.player = player;
    }

    @Override
    public void execute(String[] args) {
        // Ici tu mets ton code d'inspection,
        // par exemple args[0] = "letter" ou "key"
    }
}
