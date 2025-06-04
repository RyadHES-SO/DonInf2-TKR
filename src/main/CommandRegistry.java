
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandRegistry {
    private Map<String, ICommand> commands = new HashMap<>();

    public void addCommand(String name, ICommand command) {
        commands.put(name, command);
    }

    public Set<String> getCommandVerbs() {
        return commands.keySet(); // commands est la Map interne
    }

    public Map<String, ICommand> getCommands() {
        return commands;
    }

    public void executeCommand(String input) {
        if (input == null || input.isBlank())
            return;

        String[] parts = input.trim().split("\\s+");
        String name = parts[0];
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, args.length);

        ICommand command = commands.get(name);
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Unknown command: " + name);
        }
    }

}
