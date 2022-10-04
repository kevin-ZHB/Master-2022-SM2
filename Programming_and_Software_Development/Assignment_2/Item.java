
public class Item extends Entity{

    private static final String HEAL_MESSAGE = "Healed!";
    private static final String HEAL_SYMBOL = "+";

    private static final String DAMAGE_PERK_MESSAGE = "Attack up!";
    private static final String DAMAGE_PERK_SYMBOL = "^";

    private static final String WARP_STONE_MESSAGE = "World complete! (You leveled up!)!";
    private static final String  WARP_STONE_SYMBOL = "@";


    private String message;
    
    public Item(){
    }

    public String getMessage() {
        return message;
    }

    public void setMessage() {
        if(super.getSymbol().equals(HEAL_SYMBOL)){
            this.message = HEAL_MESSAGE;
        }else if(super.getSymbol().equals(DAMAGE_PERK_SYMBOL)){
            this.message = DAMAGE_PERK_MESSAGE;
        }else if(super.getSymbol().equals(WARP_STONE_SYMBOL)){
            this.message = WARP_STONE_MESSAGE;
        }
    }
    
    
}
