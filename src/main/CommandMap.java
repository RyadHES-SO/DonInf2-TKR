import utils.Array2Dprinter;
import utils.IPrintable;

public class CommandMap extends Command {

    private Worldmap worldmap;

    public CommandMap(Worldmap worldmap) {
        super("map", "Display the world map");
        this.worldmap = worldmap;
    }

    @Override
    public void execute(String[] args) {
        IPrintable[][] map = worldmap.getMap();
        int playerRow = worldmap.getPlayerRow();
        int playerCol = worldmap.getPlayerColumn();

        System.out.println(Array2Dprinter.print2DArray(map, playerRow, playerCol));
    }
}
