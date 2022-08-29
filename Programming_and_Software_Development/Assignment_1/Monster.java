package Programming_and_Software_Development.Assignment_1;

public class Monster {

    private static final int LOWEST_HEALTH = 0;

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int damage;

    // Constuctor
    public Monster(String name, int maxHealth, int damage) {
        setName(name);
        setMaxHealth(maxHealth);
        setDamage(damage);
    }

    public Monster() {
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

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        setCurrentHealth(maxHealth);
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    // Decrease hp based on player's attack
    public void battle(Player player) {
        this.currentHealth -= player.getDamage();
    }

    // Check if hp is low
    public boolean isHpLow() {
        return this.currentHealth <= LOWEST_HEALTH;
    }

    // Check if there is a monster created
    public boolean hasMonster() {
        return this.name != null;
    }

    // Recover hp
    public void healthRecover() {
        this.currentHealth = this.maxHealth;
    }

}
