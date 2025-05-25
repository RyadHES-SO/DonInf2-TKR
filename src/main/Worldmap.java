package main;

public class Worldmap {
    private Location[][] worldmap;
    private int playerRow;
    private int playerColumn;

    public Worldmap(int rows, int columns) {
        worldmap = new Location[rows][columns];
        playerRow = 0;
        playerColumn = 0;
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerColumn() {
        return playerColumn;
    }

    // Ajoute une vraie Location à une case précise
    public void addLocation(Location location, int row, int column) {
        if (isInBounds(row, column)) {
            worldmap[row][column] = location;
        }
    }

    // Récupère la Location à une position
    public Location getLocation(int row, int column) {
        if (isInBounds(row, column)) {
            return worldmap[row][column];
        }
        return null;
    }

    // Donne la position actuelle du joueur
    public int[] getPosition(Player player) {
        return new int[] { playerRow, playerColumn };
    }

    // Donne la Location actuelle du joueur
    public Location getPlayerLocation() {
        return worldmap[playerRow][playerColumn];
    }

    // Définit la position du joueur
    public void setPlayerLocation(int row, int column) {
        if (isInBounds(row, column) && worldmap[row][column].getState()) {
            playerRow = row;
            playerColumn = column;
        } else {
            System.out.println("Impossible d'accéder à cette position (verrouillée ou hors limites).");
        }
    }

    private boolean isInBounds(int row, int column) {
        return row >= 0 && row < worldmap.length && column >= 0 && column < worldmap[0].length;
    }

    public boolean tryMovePlayerTo(int newRow, int newColumn) {
    if (isInBounds(newRow, newColumn)) {
        Location next = worldmap[newRow][newColumn];
        if (next.getState()) {
            playerRow = newRow;
            playerColumn = newColumn;
            System.out.println("Tu te déplaces vers : " + next.getName());
            System.out.println(next.getDescription());
            return true;
        } else {
            System.out.println("Cette zone est verrouillée.");
        }
    } else {
        System.out.println("Impossible d'aller dans cette direction.");
    }
    return false;
}
}
