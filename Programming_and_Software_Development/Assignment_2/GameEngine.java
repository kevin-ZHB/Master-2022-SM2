import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class GameEngine {

    private static final String ENTER_KEY = "";
    private static final String PLAYER_DATA = "player.dat";
    private static final String WORLD_FILE_SUFFIX = ".dat";

    public static void main(String[] args) {

        // Creates an instance of the game engine.
        GameEngine gameEngine = new GameEngine();

        // Runs the main game loop.
        gameEngine.runGameLoop();

    }

    /*
     * Logic for running the main game loop.
     */
    private void runGameLoop() {

        // Initialize default Classes
        Player player = new Player();
        Monster monster = new Monster();
        ArrayList<Monster> monsters = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        Map map = new Map();
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
                monsters.add(monster);
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
                    map.locationReset(player, monster);
                    map.setMapInfo();
                    startGame(player, monsters, world, map, stdin);
                    returnToMenu(player, monster, stdin);
                }
            } else if (command.contains("start")) {
                if (!player.hasPlayer()) {
                    System.out.println("No player found, please create a player with 'player' first.");
                    returnToMenu(player, monster, stdin);

                } else{
                    String filename = command.substring(6)+WORLD_FILE_SUFFIX;
                    try{
                        loadWorld(filename, map, player, monsters, items);
                        worldLoop(world,map,player, monsters, items, stdin);
                        returnToMenu(player, monster, stdin);
                    } catch (GameLevelNotFoundException e){
                        System.out.println("load world failed");
                    } 
                }

            } else if (command.equals("save")){
                savePlayer(player);
                
            } else if (command.equals("load")){
                loadPlayer(player);
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
    private void startGame(Player player, ArrayList<Monster> monsters, World world, Map map, Scanner stdin) {
        String direction;

        // Keep moving until player encountered a monster
        ArrayList <Monster> encounterList = world.monsterEncountered(player, monsters);
        do {
            map.render(player, monsters);
            map.dispMap();
            displayWaitingCommand();
            direction = stdin.nextLine();

            // Battle interrupts
            if (direction.equals("home")) {
                displayHomeInfo();
                break;
            }
            world.playerMove(direction, player, map);
            encounterList = world.monsterEncountered(player, monsters);

        } while (encounterList.size() == 0) ;

        if (encounterList.size() != 0) {
            for(int i=0; i< encounterList.size(); i++){
                Monster monster = encounterList.get(i);
                battleLoop(player, monster);
            }
            
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

    private void loadWorld(String file, Map map,Player player, ArrayList<Monster> monsters, ArrayList<Item> items) throws GameLevelNotFoundException{
        
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(file));
            
        } catch(Exception e){
            throw new GameLevelNotFoundException();
        } 
        map.setNumCol(Integer.parseInt(inputStream.next()));
        map.setNumRow(Integer.parseInt(inputStream.next()));
        inputStream.nextLine();

        ArrayList<StringBuilder> mapInfo = new ArrayList<>();
        for(int i =0; i< map.getNumRow(); i++){
            StringBuilder row = new StringBuilder();
            row.append(inputStream.nextLine());
            mapInfo.add(row);            
        }
        map.setMapInfo(mapInfo);

        while(inputStream.hasNextLine()){
            String entity = inputStream.next();
            
            if(entity.charAt(0) == 'p'){
                player.setCol(Integer.parseInt(inputStream.next()));
                player.setRow(Integer.parseInt(inputStream.next()));
            
            } else if(entity.charAt(0) == 'm'){
                Monster monster = new Monster();
                monster.setCol(Integer.parseInt(inputStream.next()));
                monster.setRow(Integer.parseInt(inputStream.next()));
                monster.setName(inputStream.next());
                monster.setMaxHealth(Integer.parseInt(inputStream.next()));
                monster.setDamage(Integer.parseInt(inputStream.next()));
                monsters.add(monster);
            }else if (entity.charAt(0) == 'i'){
                Item item = new Item();
                item.setCol(Integer.parseInt(inputStream.next()));
                item.setRow(Integer.parseInt(inputStream.next()));
                item.setSymbol(inputStream.next());
                item.setMessage();
                items.add(item);
            }
        }

        inputStream.close();
        
    }

    private void savePlayer(Player player){
        PrintWriter outputStream = null;
        if(player.hasPlayer()){
            try{
                outputStream = new PrintWriter(new FileOutputStream(PLAYER_DATA));
                outputStream.print(player.getName()+" ");
                outputStream.print(player.getLevel());
    
            } catch (FileNotFoundException e){
                System.out.println("Error");
            }
            outputStream.close();
            System.out.println("Player data loaded.");
            displayWaitingCommand();

        }else{
            System.out.println("No player data to save.");
            displayWaitingCommand();

        }
        
        
        
        
    }

    private void loadPlayer(Player player){
    
        Scanner inputStream = null;
        try{
            inputStream = new Scanner(new FileInputStream(PLAYER_DATA));
            player.setName(inputStream.next());
            player.setLevel(Integer.parseInt(inputStream.next()));
        } catch (FileNotFoundException e){
            System.out.println("No player data found");
            displayWaitingCommand();
        } catch(Exception e){
            System.out.println("load player failed");
            System.exit(1);
        }
        inputStream.close();
        System.out.println("Player data loaded.");
        displayWaitingCommand();
    
        
        
    }
    
    private void worldLoop(World world, Map map, Player player, ArrayList<Monster> monsters, ArrayList<Item> items, Scanner stdin){
        String command;
        
        
        do{
            map.render(player, monsters, items);
            player.healthRecover();
            map.dispMap();
            displayWaitingCommand();
            command = stdin.nextLine();

            if (command.equals("home")) {
                displayHomeInfo();
                break;
            }
            for(int i=0; i<monsters.size(); i++){
                Monster monster = monsters.get(i);
                world.monsterMove(monster, player, map);
            }
            
            world.playerMove(command, player, map);
            ArrayList <Monster> encounterList = world.monsterEncountered(player, monsters);
            if(encounterList.size() != 0 ){
                for(int i=0; i< encounterList.size(); i++){
                    Monster monster = encounterList.get(i);
                    battleLoop(player, monster);
                    System.out.println();
                    if(player.isHpLow()){
                        displayHomeInfo();
                        break;
                    }else if (monster.isHpLow()){
                        monsters.remove(monster);
                    }

                }
            }

            boolean finish = world.pickItem(player, items);
            if(finish){
                break;
            }

        }while(!player.isHpLow());


        
    }
}

