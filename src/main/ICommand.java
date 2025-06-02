public interface ICommand {
    void execute(String[] args);

    public String getVerb();

    public String getDescription();
    
}