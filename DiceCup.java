import java.util.*;

/**
 * Write a description of class DiceCup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiceCup
{
    // instance variables - replace the example below with your own
    public ArrayList<Dice> diceList;

    /**
     * Constructor for objects of class DiceCup
     */
    public DiceCup()
    {
        // initialise instance variables
        diceList = new ArrayList<Dice>();

    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void shakeDiceCup()
    {
        for (Dice d : diceList)
        {
          d.roll(); 
        }
    }
    
    public int totalDice()
    {
       int total = 0;
      for (Dice d : diceList)
      {
          total += d.faceValue; 
      }
    return total;
    }//end total dice
}
