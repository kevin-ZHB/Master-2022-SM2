package Programming_and_Software_Development.Assignment_1;

public class World {

    private static final int EAST_EDGE = 5;
    private static final int WEST_EDGE = 0;
    private static final int SOUTH_EDGE = 3;
    private static final int NORTH_EDGE = 0;
    private static final int BASE_MOVE = 1;

    private static final int INITIAL_PLAYER_ROW = 1;
    private static final int INITIAL_PLAYER_COL = 1;
    private static final int INITIAL_MONSTER_ROW = 2;
    private static final int INITIAL_MONSTER_COL = 4;

    private int playerRow;
    private int playerCol;
    private int monsterRow;
    private int monsterCol;

    // Constructor, getter and setter
    public World() {
        setPlayerRow(INITIAL_PLAYER_ROW);
        setPlayerCol(INITIAL_PLAYER_COL);
        setMonsterRow(INITIAL_MONSTER_ROW);
        setMonsterCol(INITIAL_MONSTER_COL);
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public void setPlayerRow(int playerRow) {
        this.playerRow = playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public void setPlayerCol(int playerCol) {
        this.playerCol = playerCol;
    }

    public int getMonsterRow() {
        return monsterRow;
    }

    public void setMonsterRow(int monsterRow) {
        this.monsterRow = monsterRow;
    }

    public int getMonsterCol() {
        return monsterCol;
    }

    public void setMonsterCol(int monsterCol) {
        this.monsterCol = monsterCol;
    }

    // Apply each movement of player if valid
    public void playerMove(String direction) {
        switch (direction) {
            case "w":
                if (this.playerRow - BASE_MOVE >= NORTH_EDGE) {
                    this.playerRow -= BASE_MOVE;
                }
                break;

            case "a":
                if (this.playerCol - BASE_MOVE >= WEST_EDGE) {
                    this.playerCol -= BASE_MOVE;
                }
                break;

            case "s":
                if (this.playerRow + BASE_MOVE <= SOUTH_EDGE) {
                    this.playerRow += BASE_MOVE;
                }
                break;

            case "d":
                if (this.playerRow - BASE_MOVE <= NORTH_EDGE) {
                    this.playerCol += BASE_MOVE;
                }
                break;

            default:
                break;
        }

    }

    // Check if the player encontered a monster
    public boolean isEncountered() {

        // Using "==" to compare two integers in the range of 0 to 6.
        return ((this.playerCol == this.monsterCol) && (this.playerRow == this.monsterRow));
    }

    // Display the world map
    public void dispMap(Player player, Monster monster) {
        for (int row = 0; row <= SOUTH_EDGE; row++) {
            for (int col = 0; col <= EAST_EDGE; col++) {
                if (row == this.monsterRow && col == this.monsterCol) {
                    System.out.print(monster.getName().substring(0, 1).toLowerCase());
                } else if (row == this.playerRow && col == this.playerCol) {
                    System.out.print(player.getName().substring(0, 1).toUpperCase());
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();

        }
    }

    // Re-initialize locations
    public void locationReset() {
        setPlayerRow(INITIAL_PLAYER_ROW);
        setPlayerCol(INITIAL_PLAYER_COL);
        setMonsterRow(INITIAL_MONSTER_ROW);
        setMonsterCol(INITIAL_MONSTER_COL);
    }
}
