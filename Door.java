 /**
 * World of Zuule
 * 
 * A "Door" represents an exit in room of the scenery of the game.
 */

public class Door 
{
    //Fields
    public String name;
    public Boolean isLocked;
    Room roomOnOtherSideOfDoor;

    //Constructors
    /**
     * Creates a new door or portal.
     * @param name is the name of the door.
     * @param isLocked true if the door is locked and false if the door is unlocked. 
     */
    public Door(String name,  Room roomOnOtherSideOfDoor, boolean isLocked ){
        this.name = name;
        this.isLocked = isLocked;
        this.roomOnOtherSideOfDoor = roomOnOtherSideOfDoor; //Door starts not connected to any rooms
        
    }//end constructor


    //Methods
    /**
     * Unlocks the door.
     */
    public void unlock(){
        isLocked = false;
    }//End Method unlock

  
    
}//end class Door
