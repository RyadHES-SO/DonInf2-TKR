public class CommandMove extends Command {
    private Worldmap world;

    public CommandMove(Worldmap worldmap) {
        super("move", "Moves the player in the specified direction");
        this.world = worldmap;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage : move <north|south|east|west>");
            return;
        }

        String direction = args[0].toLowerCase();

        int row = world.getPlayerRow();
        int col = world.getPlayerColumn();

        switch (direction) {
            case "north":
                row -= 1;
                break;
            case "south":
                row += 1;
                break;
            case "east":
                col += 1;
                break;
            case "west":
                col -= 1;
                break;
            default:
                System.out.println("Invalid Commande! use : move north/south/east/west");
                return;
        }

        world.tryMovePlayerTo(row, col);
    }
}
