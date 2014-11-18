import java.util.ArrayList;
import java.util.HashMap;
/**
 * Creates the game with rooms, equipment, treasure etc. 
 * 
 * @author Sean Worthington
 * @version 11/17/2014
 */
public class World
{
    // instance variables - replace the example below with your own
    private static Character player;
    private static ArrayList<Room> rooms;
    public HashMap<String, Equipment> items;
    private ArrayList<Door> doors;
    public Room currentRoom;

    /**
     * Constructor for objects of class Game
     * @param mainCharacter The character that will enter the world and act as an avatar 
     * for the user.
     *
     */
    public World( Character mainCharacter )
    {
        this.player = player;
        
        //Make rooms
        rooms = new ArrayList<Room>();
            Room entrance = new Room("near a door in the side of the hill that seems to have been there for awhile.\n You open the door and enter into a hall.");
            Room pit_room = new Room("in a room that has a large pit in the center. There is a rope.");
            Room corridor = new Room("in the corridor. There is an iron door to the north that is locked, stairs going down \n to a rotten wooden door to the east and a open hall to the south.");
            Room teleport = new Room("You are in a room with a teleporter located on the west wall.");
            Room teleporter = new Room("You are telported to room with four doors and a ladder going up and down.");
            Room fountain = new Room("in a large room with a fountain. There is a key in the fountain.");
            Room t_hall = new Room("in a hall that goes to a T. Stench comes from the west. Green glow from the east.");
            Room trap_room = new Room("Empty Room with a opening to the east.");
            Room treasure = new Room("in the tresure room. Mounds of gold fill the floor. \n There is ladder going up.");
            Room crypt = new Room("in a crypt. Four coffins are in the room.");
            Room landing_room = new Room("The floor glows green with magic symbols.");
            Room outside = new Room("You are outside!.");
        
        currentRoom = entrance;
        
        //Make doors
        doors = new ArrayList<Door>();
            Door north = new Door("North");
            Door east = new Door("East");
            Door west = new Door("West");
            Door south = new Door("South");
            Door up = new Door("Up");
            Door down = new Door("Down");
            Door iron = new Door("Iron");
            Door rotten = new Door("Rotten");
                //add each door to doors collection
                doors.add(north);
                doors.add(east);
                doors.add(south);
                doors.add(west);
                doors.add(up);
                doors.add(down);
                doors.add(iron);
                doors.add(rotten);
    
        //Connect rooms via doors and specifiy if they are locked. 
        entrance.setDoor("east", pit_room, false);

        pit_room.setDoor("east", corridor, false);
        pit_room.setDoor("west", entrance, false);

        corridor.setDoor("iron", t_hall, true);
        corridor.setDoor("rotten", fountain, false);
        corridor.setDoor("south", teleport, false);
        corridor.setDoor("west", entrance, false);
        
        fountain.setDoor("west", corridor, false);

        teleport.setDoor("west", teleporter, false);
        teleport.setDoor("north", corridor, false);
   
        t_hall.setDoor("east", trap_room, false);
        t_hall.setDoor("west", crypt, false);
        t_hall.setDoor("south", corridor, false);     

        crypt.setDoor("east", t_hall, false);
        
        trap_room.setDoor("west", t_hall, false);
        trap_room.setDoor("east", landing_room, true);

        landing_room.setDoor("east", treasure, false);
        landing_room.setDoor("west", trap_room, false);
        
        treasure.setDoor("west", landing_room, false);
        treasure.setDoor("up", outside, false);
        
        teleporter.setDoor("west", treasure, false);
        teleporter.setDoor("east", entrance, false);
        teleporter.setDoor("up", fountain, false);
        teleporter.setDoor("down", crypt, false);
        teleporter.setDoor("north", t_hall, false);
        teleporter.setDoor("south", pit_room, false);        
        
        
        //Create items and equipment
        Equipment key = new Equipment("key", 1);
        Equipment rope = new Equipment("rope", 1);
        
        //Add items to list of items in world
        items = new HashMap<String, Equipment>();  
        items.put(key.getName().toLowerCase(), key);
        items.put(rope.getName().toLowerCase(), rope);
        
        //Add items to rooms
        pit_room.addItem(items.get("rope"));
        fountain.addItem(items.get("key"));
        
        //Create character
        Character orc1 = new Character("Grunge the Orc", "Half Dead Orc on the ground", CharacterClass.FIGHTER, "I'd kill you but the ghouls tore me up something.");
        corridor.addCharacter(orc1);
       
    }//End constructor

        //Methdods
        
     /**
     * @return the rooms
     */
    public static ArrayList<Room> getRooms() {
        return rooms;
    }//end get rooms

    public Room getCurrentRoom()
    {
     return currentRoom;
    }//end get current room
    /**
     * This subsitues for a player backpack and allows you to give the player an item that they can take 
     * with them on their journey.
     * @param item The thing you want to give the player such as a key or rope. 
     */
    public void addItem( Equipment item) 
    {
        items.put(item.getName().toLowerCase(), item);
    }//end add item
   
}//end class
    
 
