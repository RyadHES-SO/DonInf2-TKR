public class Command implements ICommand {
    private String verb;
    private String description;
    private ICommand action;

    public Command(String verb, String description, ICommand action) {
        this.verb = verb;
        this.description = description;
        this.action = action;
    }
    @Override
    public String getVerb() {
        return verb;
    }

    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void execute(String[] args) {
        action.execute(args);
    }
}

