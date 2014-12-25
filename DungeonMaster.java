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

        System.out.println("Thank you for playing Zuule. Goodbye.");
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

        System.out.println("Auto generate character?");
        boolean quickGenerate = reader.readBoolean();

        if( quickGenerate){
            player1 = new Character( "The Player", Vocation.DRUID );
            return;
        }//end if auto generate

        //Make Dice
        Dice d6_1 = new Dice(6);
        Dice d6_2 = new Dice(6);
        Dice d6_3 = new Dice(6);

        DiceCup theDiceCup = new DiceCup();

        theDiceCup.diceList.add(d6_1);
        theDiceCup.diceList.add(d6_2);
        theDiceCup.diceList.add(d6_3);

        int STR;
        int DEX;
        int CON;
        int WIS;
        int INT;
        int CHA;

        boolean reroll = true;

        while( reroll )
        {
            theDiceCup.shakeDiceCup();
            STR = theDiceCup.totalDice();
            theDiceCup.shakeDiceCup();
            DEX = theDiceCup.totalDice();
            theDiceCup.shakeDiceCup();
            CON = theDiceCup.totalDice();
            theDiceCup.shakeDiceCup();
            WIS = theDiceCup.totalDice();
            theDiceCup.shakeDiceCup();
            INT = theDiceCup.totalDice();
            theDiceCup.shakeDiceCup();
            CHA = theDiceCup.totalDice();
            System.out.println("Your Scores are:");

            System.out.println("Your Attributes are,");
            System.out.println("STR: " + STR);
            System.out.println("INT: " + INT);
            System.out.println("WIS: " + WIS);
            System.out.println("DEX: " + DEX);
            System.out.println("CON: " + CON);
            System.out.println("CHA: " + CHA);
            System.out.println("1: Reroll");
            System.out.println("2: Continue");

            int likes = reader.readInt(1,2);

            if ( likes == 1)
            {
                continue;//Goes back to the start of the while loop
            }
            else
            {
                reroll = false;
            }//end if continue

        }// end while re roll

        System.out.println("Pick your class....\n" + 
            "1.) Fighter. \n" + 
            "2.) Cleric. \n" + 
            "3.) Thief. \n" +
            "5.) Magic User. \n" + 
            "6.) Druid. \n"); 
        int charClass = reader.readInt(1,5);
        
          System.out.println("What do you want to name your character?");
    String name = reader.readString();

        switch(charClass)
        { 
            case 1:
            player1 = new Character(name, Vocation.FIGHTER );
            break;

            case 2:
            player1 = new Character(name, Vocation.CLERIC);
            break;

            case 3:
            player1 = new Character(name,Vocation.THIEF );
            break;

            case 4:
            player1 = new Character(name, Vocation.MAGIC_USER );
            break;

            case 5:
            player1 = new Character(name, Vocation.DRUID );
            break;
        }//end switch

   
  

    //Make the player the slow way

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

}//end make character

    
public static void play() {

boolean restart = false;

while( ! restart )
{
String[] commandsAvailable = world1.currentRoom.getCommands();

reader.setPrompt(Arrays.toString( commandsAvailable ) + "> ");

System.out.println( world1.currentRoom.getLongDescription() );

String commandRecieved = reader.readString( commandsAvailable );

String firstWord = "help";//set it to help just in case they leave it blank
String lastWords = null;
if( commandRecieved.contains(" "))
{
firstWord = commandRecieved.substring(0, commandRecieved.indexOf(" ")); 
lastWords = commandRecieved.substring( commandRecieved.indexOf(" "), commandRecieved.length()); 
}//end if command recieved has a space in it

switch( firstWord.toLowerCase() )
{
case "help":
executeHelp( commandsAvailable );
break;
case "restart":
System.out.println("Restarting game.");
restart = true;
break;
case "quit":
System.exit(0);
break;
case "go":
executeGo( lastWords.trim() );//pass second word
break;
case "take":
executeTake( lastWords.trim() );//pass second word
break;
case "use":
executeUse( lastWords.trim() );//pass second word
break;
case "unlock":
executeUnlock( lastWords.trim() );//pass second word
break;
default:
System.out.println("Command failed. Try again.");
break;

}
}
}

public static void executeUnlock( String direction )
{
if(world1.currentRoom.getDoor(direction).isLocked) 
{
if(world1.items.get("key")==null) {
System.out.println("Sorry but you don't have a key. You will need to take one.");
}
else 
{
world1.currentRoom.getDoor(direction).isLocked = false;
System.out.println("You have unlocked the door.");

}
}
}

public static void executeHelp( String[] commands)
{
System.out.println( wrap( world1.getCurrentRoom().getLongDescription() ) );
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
Room nextRoom = world1.currentRoom.getExit( direction );

if( world1.currentRoom.getDoor(direction).isLocked) 
{
if( world1.items.get("Key") == null) 
{
System.out.println("Sorry but the door is locked ! You will need to use a key.");
}
else 
{
System.out.println("You have to open the door to get out of there!");

}
}
else 
{
world1.currentRoom = nextRoom;
//Check if there are Character in the room
//
Monster roomMonster = world1.currentRoom.getMonster(); 
if(roomMonster != null ) 
{
System.out.println(  wrap("\nThere is a person in this Room...\n" + roomMonster.name +". "+ roomMonster.description + ": " + roomMonster.getDialogue()));
roomMonster.isAlive = true;
}

// System.out.println(world1.currentRoom.getLongDescription());
}
}

public static void executeUse(String item)
{
System.out.println( "use not working yet" );
if(world1.items.get("Key")==null) {
System.out.println("Sorry but the door is locked ! Use the unlock command if you have a key.");
}
else 
{
System.out.println("You have to open the door to get out of there!");

}

}

/**
 * This method wraps long text in the console so that it is easier to read
 */
private static String wrap(String longString) {
int MAX_WIDTH = 80;
String[] splittedString = longString.split(" ");
String resultString = "";
String lineString = "";

for (int i = 0; i < splittedString.length; i++) {
if (lineString.isEmpty()) {
lineString += splittedString[i];
} else if (lineString.length() + splittedString[i].length() < MAX_WIDTH) {
lineString += splittedString[i] + " ";
} else {
resultString += lineString + "\n";
lineString = " ";
}
}

if(!lineString.isEmpty()){
resultString += lineString + "\n";
}

return resultString;
}

}//Endworld1