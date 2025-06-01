public class CommandMove implements ICommand {
    private Worldmap world;

    public CommandMove(Worldmap world) {
        this.world = world;
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
                System.out.println("Commande invalide. Utilise : move north/south/east/west");
                return;
        }

        world.tryMovePlayerTo(row, col);
    }

    @Override
    public String getVerb() {
        return "move";
    }

    @Override
    public String getDescription() {
        return "Déplace le joueur dans la direction spécifiée";
    }
}
