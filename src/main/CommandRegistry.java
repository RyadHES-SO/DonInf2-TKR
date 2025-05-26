package main;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private Map<String, ICommand> commands = new HashMap<>();

    public void addCommand(String name, ICommand command) {
        commands.put(name, command);
    }

    public void executeCommand(String input) {
        if (input == null || input.isBlank()) return;

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

    public void printHelp() {
        System.out.println("Available commands:");
        for (String name : commands.keySet()) {
            System.out.println("- " + name);
        }
    }

    
}
