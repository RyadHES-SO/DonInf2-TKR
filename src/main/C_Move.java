package main;

public class C_Move {
    private Worldmap world;

    public C_Move(Worldmap world) {
        this.world = world;
    }

    public void execute(String direction) {
        int row = world.getPlayerRow();
        int col = world.getPlayerColumn();

        direction = direction.toLowerCase();

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
}
