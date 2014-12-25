
/**
 * This is a lame monster that only talks to you.
 * 
 * @Sean H. Worthington
 * @version 12/24/2014
 */
public class Monster
{
    // instance variables - replace the example below with your own
    public String name;
    String description;
    public String saying;
    boolean isAlive;

    /**
     * Constructor for objects of class Monster
     */
    public Monster( String name, String description, String saying)
    {
        this.name = name;
        this.description = description;
        this.saying = saying;
        isAlive = true;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getDialogue()
    {
        // put your code here
        return saying;
    }
}
