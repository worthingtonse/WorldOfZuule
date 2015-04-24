import java.util.ArrayList;
import java.util.HashMap;
/**
 * Creates the game with rooms, equipment, treasure etc. 
 * 
 * @author Sean Worthington
 * @version 12/03/2014
 */
public class World
{
    // instance variables - replace the example below with your own
    private static Character player;
    private static ArrayList<Room> rooms;
    public HashMap<String, Equipment> items;
    //private HashMap < String, Room> roomLookup;//Name of a room to the door? Might not be needed. 
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
        
        /*INSTRUCTIONS TO STUDENTS
* 1. Draw a dungeon with about 10 rooms.
* 2. Create a name and description for each room.
* 2. Delete all the rooms below and add you own room name and description
* 3. Give each door a name. set doors on each room specifing the name of the door, where the door goes to and if the door is locked or not (True or False).
* 4.Add Eqipments such as keys. 
* 5.Add monsters to rooms. 
*/

 
        
        
        //Make rooms
        rooms = new ArrayList<Room>();
            Room entrance = new Room("near a door in the side of the hill that seems to have been there for awhile.\n You open the door and enter into a hall.");
            Room pit_room = new Room("in a room that has a large pit in the center.");
            Room corridor = new Room("in the corridor. There is an iron door to the north that is locked, stairs going down \n to a rotten wooden door to the east and a open hall to the south.");
            Room teleport = new Room("You are in a room with a teleporter located on the west wall.");
            Room teleporter = new Room("You are telported to room with four doors and a ladder going up and down.");
            Room fountain = new Room("in a large room with a fountain.");
            Room t_hall = new Room("in a hall that goes to a T. Stench comes from the west. Green glow from the east.");
            Room trap_room = new Room("A 20 x 20 room with an opening to the east that glows green and a trap door in the center of the room. There is a door to the West also.");
            Room treasure = new Room("in the tresure room. Mounds of gold fill the floor. \n There is ladder going up.");
            Room crypt = new Room("in a crypt. Four coffins are in the room.");
            Room landing_room = new Room("The floor glows green with magic symbols.");
            Room outside = new Room("You are outside!.");
        
        currentRoom = entrance;

    
        //Connect rooms via doors and specifiy if they are locked. 
        entrance.setDoor("East", pit_room, false);

        pit_room.setDoor("East", corridor, false);
        pit_room.setDoor("West", entrance, false);

        corridor.setDoor("Iron Door", t_hall, true);
        corridor.setDoor("Rotten Door", fountain, false);
        corridor.setDoor("South", teleport, false);
        corridor.setDoor("West", entrance, false);
        
        fountain.setDoor("West", corridor, false);

        teleport.setDoor("Teleport", teleporter, false);
        teleport.setDoor("North", corridor, false);
   
        t_hall.setDoor("East", trap_room, false);
        t_hall.setDoor("West", crypt, false);
        t_hall.setDoor("South", corridor, false);     

        crypt.setDoor("east", t_hall, false);
        
        trap_room.setDoor("West", t_hall, false);
        trap_room.setDoor("Trap Door", pit_room, false);
        trap_room.setDoor("East", landing_room, true);

        landing_room.setDoor("East", treasure, false);
        landing_room.setDoor("West", trap_room, false);
        
        treasure.setDoor("West", landing_room, false);
        treasure.setDoor("Up", outside, false);
        
        teleporter.setDoor("Treasure Room", treasure, false);
        teleporter.setDoor("Entrance", entrance, false);
        teleporter.setDoor("Fountain", fountain, false);
        teleporter.setDoor("Crypt", crypt, false);
        teleporter.setDoor("T Hall", t_hall, false);
        teleporter.setDoor("Pit Room", pit_room, false);        
        
        
        //Create items and equipment
        Equipment key = new Equipment("key", 1);
        Equipment rope = new Equipment("rope", 1);
        Equipment ironspike = new Equipment("Iron Spike", 1);
        
        //Add items to list of items in world
        items = new HashMap<String, Equipment>();  
       // items.put(key.getName().toLowerCase(), key);
      //  items.put(rope.getName().toLowerCase(), rope);
        
        //Add items to rooms
        pit_room.addItem( rope );
        fountain.addItem( key );
        t_hall.addItem( ironspike );
        
        //Create character
        Monster orc1 = new Monster("Grunge the Orc", "Half Dead Orc on the ground", "one I would kill you but this game does not allow combat. You will have to figure that out in a different lab!");
        corridor.addMonster(orc1);
       Monster bill = new Monster("Bill the Magician", "Magic user who is also a pyromaniac:", "one I am stuck in this magic circle. Here is a fireball spell to help  you on  your journey. To bad this program does not do magic.");
       landing_room.addMonster(bill);
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
    
 
