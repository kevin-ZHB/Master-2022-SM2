


public class Player extends Entity{

    private static final int INITIAL_LEVEL = 1;
    private static final int BASE_HEALTH = 17;
    private static final int LOWEST_HEALTH = 0;
    private static final int HEALTH_MULTIPLIER = 3;
    private static final int BASE_DAMAGE = 1;
    private static final int INITIAL_BONUS_DAMAGE = 0;

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int level;
    private int baseDamage;
    private int bonusDamage = 0;
    private int damage;

    // Constructor, getter and setter

    public Player() {
        setName(null);
        setLevel(INITIAL_LEVEL);
        setMaxHealth(this.level);
        setCurrentHealth(this.maxHealth);
        setBaseDamage(this.level);
        setBounsDamage(INITIAL_BONUS_DAMAGE);
        setDamage(this.baseDamage + this.bonusDamage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if(this.name!= null){
            super.setSymbol(name.substring(0, 1).toUpperCase());

        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int level) {
        this.maxHealth = level * HEALTH_MULTIPLIER + BASE_HEALTH;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLevel() {
        this.level = INITIAL_LEVEL;
    }

    public int getBaseDamage() {
        return this.baseDamage;
    }

    public void setBaseDamage(int level) {
        this.baseDamage = BASE_DAMAGE + level;
    }

    public void setBounsDamage(int INITIAL_BONUS_DAMAGE){
        this.bonusDamage = INITIAL_BONUS_DAMAGE;
    }

    public int getBonusDamage() {
        return this.bonusDamage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }

    // Decrease hp based on monster's attack
    public void battle(Monster monster) {
        this.currentHealth -= monster.getDamage();
    }

    // Check if the player's hp is low
    public boolean isHpLow() {
        return this.currentHealth <= LOWEST_HEALTH;
    }

    // Check if there is a player created;
    public boolean hasPlayer() {
        return this.name != null;
    }

    // Recover hp
    public void healthRecover() {
        this.currentHealth = this.maxHealth;
    }

    // Pick up damage perk and get 1 bonus damage;
    public void attackUp(){
        this.bonusDamage += 1;
        setDamage(this.baseDamage+ this.bonusDamage);
    }

    // Pick up warp stone and get level up;
    public void levelUp(){
        this.level += 1;
    }

    public void move(String direction){
        
    }
}
