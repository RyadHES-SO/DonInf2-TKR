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

    public void addLocation(Location location, int row, int column) {
        if (isInBounds(row, column)) {
            worldmap[row][column] = location;
        }
    }

    public Location getLocation(int row, int column) {
        if (isInBounds(row, column)) {
            return worldmap[row][column];
        }
        return null;
    }

    public Location getPlayerLocation() {
        return worldmap[playerRow][playerColumn];
    }

    public void setPlayerLocation(int row, int column) {
        if (isInBounds(row, column) && worldmap[row][column] != null && worldmap[row][column].getState()) {
            playerRow = row;
            playerColumn = column;
            System.out.println("You are now at: " + worldmap[row][column].getName());
            System.out.println(worldmap[row][column].getDescription());
        } else {
            System.out.println("Cannot move to this location (locked or out of bounds).");
        }
    }

    private boolean isInBounds(int row, int column) {
        return row >= 0 && row < worldmap.length && column >= 0 && column < worldmap[0].length;
    }

    public boolean tryMovePlayerTo(int newRow, int newColumn) {
        if (isInBounds(newRow, newColumn)) {
            Location next = worldmap[newRow][newColumn];
            if (next != null && next.getState()) {
                playerRow = newRow;
                playerColumn = newColumn;
                System.out.println("You move to: " + next.getName());
                System.out.println(next.getDescription());
                return true;
            } else {
                System.out.println("This area is locked.");
            }
        } else {
            System.out.println("Cannot move in that direction.");
        }
        return false;
    }

    // Displays the map with [P] as the player position
    public void displayMap() {
        for (int i = 0; i < worldmap.length; i++) {
            for (int j = 0; j < worldmap[i].length; j++) {
                if (i == playerRow && j == playerColumn) {
                    System.out.print("[P]");
                } else if (worldmap[i][j] == null) {
                    System.out.print("[ ]");
                } else if (!worldmap[i][j].getState()) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}
