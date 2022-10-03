package Assignment_2;


public class Player {

    private static final int INITIAL_LEVEL = 1;
    private static final int BASE_HEALTH = 17;
    private static final int LOWEST_HEALTH = 0;
    private static final int HEALTH_MULTIPLIER = 3;
    private static final int BASE_DAMAGE = 1;

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int level = INITIAL_LEVEL;
    private int damage;

    // Constructor, getter and setter
    public Player(String name) {
        setLevel(INITIAL_LEVEL);
        setName(name);
        setMaxHealth(this.level);
        setCurrentHealth(this.maxHealth);
        setDamage(level);
    }

    public Player() {
        setName(null);
        setLevel(INITIAL_LEVEL);
        setMaxHealth(this.level);
        setCurrentHealth(this.maxHealth);
        setDamage(level);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.currentHealth = getMaxHealth();
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int level) {
        this.damage = BASE_DAMAGE + level;
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
}