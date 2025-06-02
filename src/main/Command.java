public abstract class Command implements ICommand {
    private String verb;
    private String description;

    public Command(String verb, String description) {
        this.verb = verb;
        this.description = description;
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
    public abstract void execute(String[] args);
}
