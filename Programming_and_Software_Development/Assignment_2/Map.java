import java.util.Arrays;
import java.util.ArrayList;

public class Map {

    // Define constants for default map size and locations
    private static final int WEST_EDGE = 0;
    private static final int NORTH_EDGE = 0;

    private static final int DEFAULT_WIDTH = 6;
    private static final int DEFAULT_LENGHT = 4;

    private static final int INITIAL_PLAYER_ROW = 1;
    private static final int INITIAL_PLAYER_COL = 1;
    private static final int INITIAL_MONSTER_ROW = 2;
    private static final int INITIAL_MONSTER_COL = 4;

    // Define constants for terrain
    private static final String[] TERRAIN = { "#", "~" };
    private static final String GROUND = ".";

    private ArrayList<StringBuilder> mapInfo;
    private ArrayList<StringBuilder> mapToShow;

    private int numRow;
    private int numCol;

    public Map() {
        setNumCol(DEFAULT_WIDTH);
        setNumRow(DEFAULT_LENGHT);
        setMapToShow();

    }

    // Setters and getters

    // Setter for loaded world
    public void setMapInfo(ArrayList<StringBuilder> mapInfo) {
        this.mapInfo = mapInfo;

    }

    // Setter for default world
    public void setMapInfo() {
        ArrayList<StringBuilder> defaultMap = new ArrayList<>(this.numRow);

        for (int i = 0; i < this.numRow; i++) {
            StringBuilder mapRow = new StringBuilder();
            for (int j = 0; j < this.numCol; j++) {
                mapRow.append(GROUND);
            }
            defaultMap.add(mapRow);
        }
        this.mapInfo = new ArrayList<StringBuilder>(defaultMap);

    }

    public void setMapToShow() {
        this.mapToShow = new ArrayList<>();
    }

    public int getNumRow() {
        return numRow;
    }

    public void setNumRow(int numRow) {
        this.numRow = numRow;
    }

    public int getNumCol() {
        return numCol;
    }

    public void setNumCol(int numCol) {
        this.numCol = numCol;
    }

    // Render method for default world
    public void render(Player player, ArrayList<Monster> monsters) {
        mapDeepCopy();

        replaceSymbol(player);
        for (int i = 0; i < monsters.size(); i++) {
            replaceSymbol(monsters.get(i));
        }

    }

    // Render method for loaded world
    public void render(Player player, ArrayList<Monster> monsters, ArrayList<Item> items) {
        mapDeepCopy();

        replaceSymbol(player);

        for (int i = 0; i < monsters.size(); i++) {
            Monster monster = monsters.get(i);
            replaceSymbol(monster);
        }

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            replaceSymbol(item);

        }
    }

    // Method to replace symbol when rendering
    public void replaceSymbol(Entity entity) {
        StringBuilder mapRow = this.mapToShow.get(entity.getRow());
        mapRow.replace(entity.getCol(), entity.getCol() + 1, entity.getSymbol());
        this.mapToShow.set(entity.getRow(), mapRow);
    }

    // Method to check if the movement is valid
    public boolean isValid(int col, int row) {
        boolean valid = true;
        StringBuilder mapRow = this.mapInfo.get(row);
        String goal = mapRow.substring(col, col + 1);

        if (Arrays.asList(TERRAIN).contains(goal)) {
            return false;
        } else if (col >= numCol || col < WEST_EDGE) {
            return false;
        } else if (row >= numRow || row < NORTH_EDGE) {
            return false;
        }

        return valid;

    }

    // Method to reset locations for default world
    public void locationReset(Player player, Monster monster) {
        player.setCol(INITIAL_PLAYER_COL);
        player.setRow(INITIAL_PLAYER_ROW);
        monster.setCol(INITIAL_MONSTER_COL);
        monster.setRow(INITIAL_MONSTER_ROW);
    }

    // Method to deep copy map info to help display map
    public void mapDeepCopy() {
        setMapToShow();
        for (int i = 0; i < this.mapInfo.size(); i++) {
            StringBuilder newBuilder = new StringBuilder(this.mapInfo.get(i));
            this.mapToShow.add(newBuilder);
        }
    }

    // Method to display map
    public void dispMap() {
        for (int i = 0; i < this.mapToShow.size(); i++) {
            System.out.println(this.mapToShow.get(i));
        }
    }

}
