import java.util.Random;
/**
 * Write a description of class Dice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dice
{
    // instance variables - replace the example below with your own
    public int sides;
    public int faceValue;

    /**
     * Constructor for objects of class Dice
     */
    public Dice( int sides )
    {
        // initialise instance variables
        this.sides = sides;
        roll();
    }

    /**
     * Changes the face value of the dice to a random number between 1 and sides;
     */
    public void roll()
    {
        Random random1 = new Random();
        // put your code here
        faceValue = random1.nextInt(sides) + 1;
    }//end roll
}
