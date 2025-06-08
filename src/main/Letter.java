import java.util.Scanner;

public class Letter extends Item {
    private Riddle riddle;
    private Key rewardKey;

    public Letter(String name, String description, Riddle riddle, Key rewardKey) {
        super(name, description);
        this.riddle = riddle;
        this.rewardKey = rewardKey;
    }

    public boolean use(Scanner scanner, Player player) {
        System.out.println("You read the letter. It says:");
        System.out.println("Riddle: \"" + riddle.getQuestion() + "\"");

        while (true) {
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (riddle.checkAnswer(userAnswer)) {
                System.out.println("Correct! You solved the riddle.");
                player.getInventory().addItem(rewardKey);
                System.out.println("You received a key: " + rewardKey.getName());
                return true;
            } else {
                System.out.println("That's not correct. Try again.");
            }
        }
    }
}
