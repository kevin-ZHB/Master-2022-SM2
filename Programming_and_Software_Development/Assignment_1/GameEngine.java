package Programming_and_Software_Development.Assignment_1;

import java.util.Scanner;

public class GameEngine {

    private static final String ENTER_KEY = "";

    public static void main(String[] args) {

        // TODO: Some starter code has been provided below.
        // Edit this method as you find appropriate.

        // Creates an instance of the game engine.
        GameEngine gameEngine = new GameEngine();

        // Runs the main game loop.
        gameEngine.runGameLoop();

    }

    /*
     * Logic for running the main game loop.
     */
    private void runGameLoop() {

        // TODO: Implement your code here.

        // Initialize default Classes
        Player player = new Player();
        Monster monster = new Monster();
        World world = new World();

        displayMenuInfo(player, monster);

        Scanner stdin = new Scanner(System.in);
        String command = stdin.nextLine();

        // Response to different command
        while (!command.equals("exit")) {
            if (command.equals("help")) {
                displayHelpInfo();
                displayWaitingCommand();

            } else if (command.equals("commands")) {
                displayCommandsInfo();
                displayWaitingCommand();

            } else if (command.equals("player")) {
                displayPlayerInfo(player, stdin);
                returnToMenu(player, monster, stdin);

            } else if (command.equals("monster")) {
                displayMonsterInfo(monster, stdin);
                returnToMenu(player, monster, stdin);

            } else if (command.equals("start")) {

                if (!player.hasPlayer()) {
                    System.out.println("No player found, please create a player with 'player' first.");
                    returnToMenu(player, monster, stdin);

                } else if (!monster.hasMonster()) {
                    System.out.println("No monster found, please create a monster with 'monster' first.");
                    returnToMenu(player, monster, stdin);

                } else {

                    // Initialize all states
                    healthRecover(player, monster);
                    world.locationReset();
                    startGame(player, monster, world, stdin);
                    returnToMenu(player, monster, stdin);
                }
            }

            command = stdin.nextLine();
        }

        // Game exits
        System.out.println("Thank you for playing Rogue!");
        stdin.close();

    }

    /*
     * Displays the title text.
     */
    private void displayTitleText() {

        String titleText = " ____                        \n" +
                "|  _ \\ ___   __ _ _   _  ___ \n" +
                "| |_) / _ \\ / _` | | | |/ _ \\\n" +
                "|  _ < (_) | (_| | |_| |  __/\n" +
                "|_| \\_\\___/ \\__, |\\__,_|\\___|\n" +
                "COMP90041   |___/ Assignment ";

        System.out.println(titleText);
        System.out.println();

    }

    // Display all information in main menu
    private void displayMenuInfo(Player player, Monster monster) {
        String playerInfo, monsterInfo;

        if (!player.hasPlayer()) {
            playerInfo = "[None]";
        } else {
            playerInfo = player.getName() + " " + player.getCurrentHealth() + "/" + player.getMaxHealth();
        }

        if (!monster.hasMonster()) {
            monsterInfo = "[None]";
        } else {
            monsterInfo = monster.getName() + " " + monster.getCurrentHealth() + "/" + monster.getMaxHealth();
        }

        displayTitleText();
        System.out.println("Player: " + playerInfo + "  | Monster: " + monsterInfo);
        System.out.println();
        System.out.println("Please enter a command to continue.");
        System.out.println("Type 'help' to learn how to get started.");
        displayWaitingCommand();

    }

    // Display the waitting command
    private void displayWaitingCommand() {
        System.out.println();
        System.out.print("> ");
    }

    // Display displays some help text, showing some commands that can be run from
    // the main menu.
    private void displayHelpInfo() {
        System.out.println("Type 'commands' to list all available commands");
        System.out.println("Type 'start' to start a new game");
        System.out.println("Create a character, battle monsters, and find treasure!");

    }

    // Display a list of all the commands that can be run from the main menu.
    private void displayCommandsInfo() {
        String[] commands = { "help", "player", "monster", "start", "exit" };
        for (int i = 0; i < commands.length; i++) {
            System.out.println(commands[i]);
        }
    }

    // Allows the user to create a player character or shows some information about
    // the existing character
    private void displayPlayerInfo(Player player, Scanner stdin) {
        if (!player.hasPlayer()) {

            System.out.println("What is your character's name?");
            String name = stdin.nextLine();
            player.setName(name);
            System.out.println("Player '" + player.getName() + "' created.");
        } else {
            System.out.printf("%s (Lv. %d)%n", player.getName(), player.getLevel());
            System.out.printf("Damage: %d%n", player.getDamage());
            System.out.printf("Health: %d/%d%n", player.getCurrentHealth(), player.getMaxHealth());

        }
    }

    // Allows the user to create a monster
    private void displayMonsterInfo(Monster monster, Scanner stdin) {

        System.out.print("Monster name: ");
        String name = stdin.nextLine();
        monster.setName(name);

        System.out.print("Monster health: ");
        int maxHealth = Integer.parseInt(stdin.nextLine());
        monster.setMaxHealth(maxHealth);

        System.out.print("Monster damage: ");
        int damage = Integer.parseInt(stdin.nextLine());
        monster.setDamage(damage);

        System.out.printf("Monster '%s' created.%n", monster.getName());

    }

    // Display message when "home" is entered
    private void displayHomeInfo() {
        System.out.println("Returning home...");
    }

    // Dispaly message to return to main menu
    private void displayReturnMenu() {
        System.out.println();
        System.out.print("(Press enter key to return to main menu)");
    }

    // Display battle loop
    private void battleLoop(Player player, Monster monster) {

        System.out.println(player.getName() + " encountered a " + monster.getName());
        System.out.println();

        // Keep fighting until one's hp is low
        while (!player.isHpLow() && !monster.isHpLow()) {

            System.out.printf("%s %d/%d | %s %d/%d%n", player.getName(), player.getCurrentHealth(),
                    player.getMaxHealth(), monster.getName(), monster.getCurrentHealth(), monster.getMaxHealth());
            System.out.printf("%s attacks %s for %d damage.%n", player.getName(), monster.getName(),
                    player.getDamage());
            monster.battle(player);
            if (monster.isHpLow()) {
                System.out.println(player.getName() + " wins");
                break;
            }

            System.out.printf("%s attacks %s for %d damage.%n", monster.getName(), player.getName(),
                    monster.getDamage());
            player.battle(monster);
            if (player.isHpLow()) {
                System.out.println(monster.getName() + " wins");
                break;
            }

        }
    }

    // Method when game starts
    private void startGame(Player player, Monster monster, World world, Scanner stdin) {
        String direction;

        // Keep moving until player encountered a monster
        do {
            world.dispMap(player, monster);
            displayWaitingCommand();
            direction = stdin.nextLine();

            // Battle interrupts
            if (direction.equals("home")) {
                displayHomeInfo();
                break;
            }
            world.playerMove(direction);

        } while (!world.isEncountered());

        if (world.isEncountered()) {
            battleLoop(player, monster);
        }

    }

    // Method to recover health
    private void healthRecover(Player player, Monster monster) {
        player.healthRecover();
        monster.healthRecover();
    }

    
    // Method to return to the main menu
    private void returnToMenu(Player player, Monster monster, Scanner stdin) {

        displayReturnMenu();
        String enterkey = stdin.nextLine();
        while (!enterkey.contains(ENTER_KEY)) {
            enterkey = stdin.nextLine();
        }

        System.out.println();
        displayMenuInfo(player, monster);
    }
}
