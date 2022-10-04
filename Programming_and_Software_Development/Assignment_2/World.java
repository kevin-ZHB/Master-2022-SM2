

import java.util.ArrayList;

public class World {

    

    private static final String HEAL = "+";
    private static final String DAMAGE_PERK = "^";
    private static final String WARP_STONE = "@";
    private static final int BASE_MOVE = 1;
    private static final int NEAR_DISTANCE = 2;


    // Constructor, getter and setter
    public World() {
        
    }

    

    // Apply each movement of player if valid
    public void playerMove(String direction, Player player, Map map) {
        
        int playerRow = player.getRow();
        int playerCol = player.getCol();
        
        switch (direction) {
            case "w":
                if (map.isValid(playerCol, playerRow - BASE_MOVE)) {
                    player.moveUp();
                }
                break;

            case "a":
                if (map.isValid(playerCol - BASE_MOVE, playerRow)) {
                    player.moveLeft();
                }
                break;

            case "s":
                if (map.isValid(playerCol, playerRow + BASE_MOVE)) {
                   player.moveDown();
                }
                break;

            case "d":
                if (map.isValid(playerCol + BASE_MOVE, playerRow)) {
                    player.moveRight();
                }
                break;

            default:
                break;
        }

    }

    // Applay each movement of monster
    public void monsterMove(Monster monster, Player player, Map map){
        
        int monsterCol = monster.getCol();
        int monsterRow = monster.getRow();
        int playerCol = player.getCol();
        int playerRow = player.getRow();
        
        if (nearPlayer(monster, player)){
            
            if(monsterCol < playerCol && map.isValid(monsterCol + BASE_MOVE, monsterRow)){
                monster.moveRight();
            
            }else if(monsterCol > playerCol && map.isValid(monsterCol - BASE_MOVE, monsterRow)){
                monster.moveLeft();
            
            }else{
                
                if(monsterRow < playerRow && map.isValid(monsterCol, monsterRow + BASE_MOVE)){
                    monster.moveDown();
                
                }else if(monsterRow > playerRow && map.isValid(monsterCol, monsterRow - BASE_MOVE)){
                    monster.moveUp();
                
                }
            }
        }
    }

    // Check if the player encontered a monster
    public ArrayList<Monster> monsterEncountered(Player player, ArrayList<Monster> monsters) {
        
        ArrayList<Monster> encounteredList = new ArrayList<>();
        
        Monster[] monsterArray = monsters.toArray(new Monster[monsters.size()]);
        for (Monster monster: monsterArray){
            if (monster.getCol() == player.getCol() && monster.getRow() == player.getRow()){
                encounteredList.add(monster);
            }
        }
        return encounteredList;
    }

    public boolean nearPlayer(Monster monster, Player player){
        int playerCol = player.getCol();
        int playerRow = player.getRow();
        int monsterCol = monster.getCol();
        int monsterRow = monster.getRow();

        if( monsterCol - NEAR_DISTANCE <= playerCol && playerCol <= monsterCol + NEAR_DISTANCE) {
            if( monsterRow - NEAR_DISTANCE <= playerRow && playerRow <= monsterRow + NEAR_DISTANCE) {
                return true;
            }
        }
        return false;
    }

    public boolean pickItem(Player player, ArrayList<Item> items){
        int playerCol = player.getCol();
        int playerRow = player.getRow();
        
        for(int i = 0; i < items.size();i++){
            Item item = items.get(i);
            int itemCol = item.getCol();
            int itemRow = item.getRow();
            
            if(playerCol == itemCol && playerRow == itemRow){
                switch(item.getSymbol()){
                    case HEAL:
                        player.healthRecover();
                        System.out.println(item.getMessage());
                        items.remove(item);
                        return false;
                        
                    case DAMAGE_PERK:
                        player.attackUp();
                        System.out.println(item.getMessage());
                        items.remove(item);


                        return false;
                    case WARP_STONE:
                        player.levelUp();
                        System.out.println(item.getMessage());

                        return true;


                }
            }
            
        }
        return false;
    }
}

