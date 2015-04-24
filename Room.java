import java.util.ArrayList;
import java.util.HashMap;

/** 
 * A room can hold monsters, items, treasure and Characters.
 * It is connected to other room via door objects.
 * 
 * @Author Sean H. Worthington
 * @version 12/03/2014
 */
public class Room{

    //fields
    public String description;
    public ArrayList<Door> doors;
    public  Monster monster ;
    public Equipment item;   
    //private ArrayList<Monster> monsters;
    //private ArrayList<Purse> treasure;

    //constructors
    public Room(String description)
    {
        this.description = description;
        doors = new ArrayList<Door>();
    }

    //methods
    /**
     * Gives the room a door that will connect to other room. 
     * @param direction Describes the door or the direction it goes
     * @param opensTo The room the door connects to.
     * @param isLocked true if unlooked false if locked. 
     */
    public void setDoor(String direction, Room opensTo, boolean isLocked)
    {
        Door door = new Door(direction, opensTo, isLocked);
        getDoors().add(door);
    }

    /**
     * @return The short description of the room (the one that was defined in
     *         the constructor).
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Return a description of the room in the form: You are in the kitchen.
     * Exits: north west
     * 
     * @return A long description of this room
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" ;//+ getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * 
     * @return Details of the room's exits.
     */
    private String getExitString() {
        String returnString = "Exits:";
        for(Door door : getDoors()) {
            returnString += " " + door.name;
            returnString += ", ";
        }
        return returnString.substring(0, returnString.lastIndexOf(","));//gets rid of last comma
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * 
     * @param direction
     *            The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) {

        Room r = this;
        for(Door d: doors )
        {
            if( d.name.equalsIgnoreCase( direction ) )
            {
                r =  d.roomOnOtherSideOfDoor;
            }//end if

        }//end for
        return r;
    }//end getExit

    /**
     * Get the Door of the room
     */
    public Door getDoor(String doorName){
        for (Door door : getDoors()){
            if (door.name.equals(doorName)){
                return door;
            }
        }
        return null;
    }

    /**
     * Add a character to the room
     * @param person
     */
    public void addMonster(Monster monster) {
        this.monster = monster;
    }

    /**
     * Add a item to the room 
     * @param item
     */
    public void addItem(Equipment item) {
        this.item = item;
    }

    /**
     * Take the item of room.
     * @return item of the room
     */
    public Equipment takeItem() {
        Equipment res = item;
        item = null;
        return res;
    }

    /**
     * @return the doors
     */
    public ArrayList<Door> getDoors() {
        return doors;
    }

    /**
     * @return the available commands based on the contents of the room. 
     */
    public String[] getCommands() {

        ArrayList<String> commandList = new ArrayList<String>();

        for( int i =0 ; i < doors.size(); i++ )
        {
            commandList.add("go " + doors.get(i).name ) ;
            if( doors.get(i).isLocked )
            { 
                commandList.add("unlock " + doors.get(i).name) ;
            }
        }

        //Get go commands
        if( item != null )
        { 
            commandList.add("take " + item.getName());
        }//number of items in the room

        commandList.add("quit");
        commandList.add("restart");
        String[] returnCommands = new String[ commandList.size() ];
        return commandList.toArray(returnCommands);
    }

    /**
     * 
     * @return the character of the room
     */
    public Monster getMonster() {
        return this.monster;
    }    

    /**
     * 
     * @return the item of the room
     */
    public Equipment getItem() {
        return this.item;
    } 
}//end room