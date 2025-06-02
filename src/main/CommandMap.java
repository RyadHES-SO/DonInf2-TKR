import utils.Array2Dprinter;
import utils.IPrintable;

public class CommandMap extends Command {

    private Worldmap worldmap;

    public CommandMap(Worldmap worldmap) {
        super("map", "Affiche la carte du monde");
        this.worldmap = worldmap;
    }

    @Override
    public void execute(String[] args) {
        IPrintable[][] map = worldmap.getMap();
        int playerRow = worldmap.getPlayerRow();
        int playerCol = worldmap.getPlayerColumn();

        String printedMap = Array2Dprinter.print2DArray(map, playerRow, playerCol);
        System.out.println(printedMap);
    }
}
