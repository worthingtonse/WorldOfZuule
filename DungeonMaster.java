import java.util.Arrays;

public class DungeonMaster {
    private static CinReader reader = new CinReader();
    private static int numberOfMoves;
    private static int limitOfMoves;
    private static World world1;
    private static Character player1;
    
    public static void main(String[] args) {
                
        System.out.println(".__      __            .__       .___         _____  __________           .__          ");
        System.out.println("/  \\    /  \\___________|  |    __| _/   _____/ ____\\ \\____    /__ __ __ __|  |   ____  ");
        System.out.println("\\   \\/\\/   /  _ \\_  __ \\  |   / __ |   /  _ \\   __\\    /     /|  |  \\  |  \\  | _/ __ \\ ");
        System.out.println(" \\        (  <_> )  | \\/  |__/ /_/ |  (  <_> )  |     /     /_|  |  /  |  /  |_\\  ___/ ");
        System.out.println("  \\__/\\  / \\____/|__|  |____/\\____ |   \\____/|__|    /_______ \\____/|____/|____/\\___  >");
        System.out.println("       \\/                         \\/                         \\/                     \\/");
                
        
        boolean play_again = true;// Allows the player to play several times
        
         while (play_again)
         {
            printWelcome();
            makeCharacter();
            player1.reportStats();

           //Make the world
            world1 = new World(player1);
             
           //Start the game. 
             play();
                 
         }//End While
          
        System.out.println("Thank you for playing Zuul. Goodbye.");
    }//End main
    
    
    /**
     * Print out the opening message for the player. 
     */
    private static void printWelcome() {
        
        System.out.println("This is your world.");
        System.out.println("You are the creator. You can do anything you like.");
        System.out.println("When you are programming you have complete freedom. Total power.");
        System.out.println("Let's build some worlds! Everyday is a good day when you code.");
        System.out.println("This one is called Zuule.");

    }
    
    /**
     * Make the main character that the player will use in the game
     */
    private static void makeCharacter()
    {
        
        System.out.println("Type help if you need help.");
        System.out.println();
        System.out.println("What do you want to name your character?");
        String name = reader.readString();
        System.out.println("What is your character's slogan?");
        String saying = reader.readString();
      
        System.out.println("Pick your class....\n" + 
            "1.) Fighter. \n" + 
            "2.) Cleric. \n" + 
            "3.) Thief. \n" +
            "5.) Magic User. \n" + 
            "6.) Druid. \n"); 
        int charClass = reader.readInt(1,3);
        switch(charClass)
        { 
            case 1:
            player1 = new Character(name,"The Player", CharacterClass.FIGHTER, saying );
            break;

            case 2:
            player1 = new Character(name,"The Player", CharacterClass.CLERIC, saying );
            break;

            case 3:
            player1 = new Character(name, "The Player",CharacterClass.THIEF, saying );
            break;
            
            case 4:
            player1 = new Character(name,"The Player", CharacterClass.MAGIC_USER, saying );
            break;

            case 5:
            player1 = new Character(name, "The Player", CharacterClass.DRUID, saying );
            break;
        }//end switch
             
             //Make the player
        
        System.out.println("Pick your weapon....\n" + 
            "1.) Long Sword. \n" + 
            "2.) Battle Axe. \n" + 
            "3.) Double Daggers. \n");
        int Wep = reader.readInt(1,3);
        switch(Wep)
        { 
            case 1:
            player1.maxDamage = 10;
            break;

            case 2:
            player1.maxDamage = 12;
            player1.attackBonus = player1.attackBonus - 2;
            break;

            case 3:
            player1.maxDamage = 8;
            player1.attackBonus = player1.attackBonus + 2;
            break;
        }//end switch
        System.out.println("\n");
        System.out.println("Pick your Magic....\n" + 
            "1.) Electric Burst \n" + 
            "2.) Fire Blast \n" + 
            "3.) Heal Self \n");
        int Mag = reader.readInt(1,3);
        switch(Mag)
        {
            case 1:
            //not used
            break;

            case 2:
            //not used
            break;

            case 3:
            //not used
            break;
        }//end switch
        System.out.println("\n");
        System.out.println("Pick your Armor....\n" + 
            "1.) Light Armor (+2 to A.C.)\n" + 
            "2.) Medium Armor (+4 to A.C. -2 to Initative Bonus) \n" + 
            "3.) Heavy Armor (+6 to A.C. -4 to Initative Bonus\n");
        int Armor = reader.readInt(1,3);
        switch(Armor)
        {
            case 1:
            player1.ac = player1.ac + 2;
            break;

            case 2:
            player1.ac = player1.ac + 4;
            
            //player1.inititive = player.inititive -2;
            break;

            case 3:
            player1.ac = player1.ac + 4;
            //player1.inititive = player.inititive -4;
            break;
        }//end switch
        System.out.println("\n");
        System.out.println("Pick your Ability....\n" + 
            "1.) Improved Initative (+4 to Initative Bonus) \n" + 
            "2.) Combat Expertise (+2 to To Hit Bonus)  \n" + 
            "3.) Evasive (+2 to A.C.) \n");
        int Feat = reader.readInt(1,3);
        switch(Feat)
        {
            case 1:
            //player1.inititive = player.inititive -2;
            break;

            case 2:
            player1.attackBonus = player1.attackBonus + 2;
            break;

            case 3:
            player1.ac = player1.ac + 2;
            break;
        }//end switch
             
    }
 

    
    public static void play() {

        boolean finished = false;

        while( ! finished )
        {
            String[] commands =world1.currentRoom.getCommands();
            
            reader.setPrompt(Arrays.toString( commands ) + "> ");
            System.out.println(world1.currentRoom.getLongDescription());
            String command = reader.readString(commands);
            String[] commandTokkens = command.split(" ");//splits command using spaces
            String word1 = commandTokkens[0];
       
            switch( word1.toLowerCase() )
            {
             case "help":
                executeHelp(commands);
             break;
             case "restart":
                System.out.println("Restarting game.");
                finished = true;
             break;
             case "quit":
                 System.exit(0);
             break;
             case "go":
                executeGo(commandTokkens[1]);//pass second word
             break;
             case "take":
                 executeTake(commandTokkens[1]);//pass second word
             break;
             case "use":
                 executeUse(commandTokkens[1]);//pass second word
             break;
             case "unlock":
                 executeUnlock(commandTokkens[1]);//pass second word
             break;
             default:
              System.out.println("Command failed. Try again.");
             break;
            
            }
        }
    }
    
    public static void executeUnlock( String direction )
    {
        if(world1.currentRoom.getDoor(direction).isLocked()) 
        {
            if(world1.items.get("key")==null) {
                System.out.println("Sorry but you don't have a key. You will need to take one.");
            }
            else 
            {
                world1.currentRoom.getDoor(direction).setLock(false);
                System.out.println("You have unlocked the door.");

            }
        }
    }
    
    public static void executeHelp( String[] commands)
    {
        System.out.println(world1.getCurrentRoom().getLongDescription());
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println( Arrays.toString( commands ) );
    }
    
    public static void executeTake(String item)
    {
        
            System.out.println("You've just found " +world1.getCurrentRoom().item.getName()  + " ! :) ");
            System.out.println( world1.getCurrentRoom().item.getName());
           world1.addItem(world1.getCurrentRoom().takeItem());
        }
      
    
    public static void executeGo( String direction )
    {
        // Try to leave current room.
        Room nextRoom =world1.currentRoom.getExit( direction );

        if(world1.currentRoom.getDoor(direction).isLocked()) 
        {
            if(world1.items.get("Key")==null) {
                System.out.println("Sorry but the door is locked ! You will need to use a key.");
            }
            else 
            {
                System.out.println("You have to open the door to get out of there!");

            }
        }
        else 
        {
            setCurrentRoom(nextRoom);
            //Check if there are Character in the room
            //
            Character person =world1.currentRoom.getCharacter(); 
            if(person != null && !person.hasSpoken()) {
                System.out.println("\nThere is a person in this Room...\n" + person.getName()+". "+ person.getDescription()+ ": " + person.getDialogue());
                person.setHasSpoken(true);
            }
            
           // System.out.println(world1.currentRoom.getLongDescription());
        }
    }
    
    public static void executeUse(String item)
    {
       System.out.println( "use not working yet");
       if(world1.items.get("Key")==null) {
                System.out.println("Sorry but the door is locked ! Use the unlock command if you have a key.");
            }
            else 
            {
                System.out.println("You have to open the door to get out of there!");

            }
  
    }
    
    
    public static void setCurrentRoom(Room room)
    {
       world1.currentRoom = room;
    }
 
}//Endworld1