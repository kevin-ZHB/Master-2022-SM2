

public class Entity {
    private int col;
    private int row;
    private String symbol;
    
    public Entity() {
    }

    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void moveUp(){
        this.row -= 1;
    }

    public void moveDown(){
        this.row += 1;
    }

    public void moveRight(){
        this.col += 1;
    }
    public void moveLeft(){
        this.col -= 1;
    }
    
    
}
