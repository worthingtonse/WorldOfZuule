 import java.util.Random;
/**
 * This is a character in a game
 * 
 * @ Michael Nielsen, Kristonda Pryor
 * @ 10/22/14
 */
public class Character
{
    //Fields
    public String characterName;
    public Vocation charClass;
    public int STR; //strength
    public int INT; //intelligence
    public int WIS; //wisdom
    public int DEX; //dexterity
    public int CON; //constitution
    public int CHA; //character
    public int attackBonus;
    public int damageBonus;
    public int armorBonus;
    public int gp = 0; //gold pieces
    public int exp = 0; //experience
    public int hp; //hit points
    public int ac; //armor class
    //public ArrayList<Weapon> weapons;
    //public Purse purse;
    //public Backpack backpack;
    //public Armor armor;
    public int maxDamage;
    
    //Constructors
    public Character(String characterName,  Vocation charClass )
    {
       
        this.charClass = charClass;
        
        /**
         * Number of STRength points
         * given based on a random roll of 3 6-sided dye.
         */
        STR = roll3D6();
        
        /**
         * Number of INTelligence points
         * given based on a random roll of 3 6-sided dye.
         */
        INT = roll3D6();
        
        /**
         * Number of WISdom points 
         * given based on a random roll of 3 6-sided dye.
         */
        WIS = roll3D6();
        
         /**
         * Number of DEXterity points 
         * given based on a random roll of 3 6-sided dye.
         */
        DEX = roll3D6();
     
         /**
         * Number of CONstitution  points 
         * given based on a random roll of 3 6-sided dye.
         */
        CON = roll3D6();
       
         /**
         * Number of CHArisma points 
         * given based on a random roll of 3 6-sided dye.
          */;
        CHA = roll3D6();
        
        /**
         * Number of points given 
         * for attack bonus by calling on the "findMod" method.<!-- -->
         * Influences DEXterity.
         */
        attackBonus = findMod(DEX) ;
        
         /**
         * Number of points given 
         * for damage bonus by calling on the "findMod" method.<!-- -->
         * Influences STRength.
         */
        damageBonus = findMod(STR);
     
         /**
         * Number of points given 
         * for armor bonus by calling on the "findMod" method.<!-- -->
         * Influences DEXterity.
         */
        armorBonus = findMod(DEX);
   
        /**
         * Number of hit points given
         * by calling on "classHP" method and based on specific range.
         */
        hp = classHP();
        
        /**
        * Number of initial armor class.
        */
        ac = 10;
  
        /**
        * maximum damage the player can do to an enemy.
        */
        maxDamage = 1;//fists
        /**
        * What the character will say if spoken too.
        */
      
    }//end constructor

    //Methods
    public int classHP()
    {
        /**
         * Class method which determines number of hp given
         * to each character based on specific range.
         */
        switch(charClass)
        {
            case FIGHTER:
            hp = (int) (Math.random() * (10-1)) +1;
            break;

            case CLERIC:
            hp = (int) (Math.random() * (8-1)) +1;
            break;

            case DRUID:
            hp = (int) (Math.random() * (8-1)) +1;
            break;

            case THIEF:
            hp = (int) (Math.random() * (6-1)) +1;
            break;

            case MAGIC_USER:
            hp = (int) (Math.random() * (4-1)) +1;
            break;

        }
        return hp;
    }

    public int rollAttack()
    {
        /**
         * Class method which determines number of attack bonus
         * points given based on random dice roll between 1 and 20.
         */
        Random random2 = new Random();
        int atk = random2.nextInt(20) +1 + attackBonus;
        return atk;
    }//end method rollAttack
    public int rollDamage()
    {
        /**
         * Class method which determines number of damage bonus
         * points given based on random dice roll between 1 and 6.
         */
        Random random3 = new Random();
        int dam = random3.nextInt(maxDamage) +1 + damageBonus;
        return dam;

    }// end rollDamage
    public void reduceHP(int lessHP)
    {
        /**
         * Class method which reduces a players hp.
         */
        hp -= lessHP;
    }//end reduceHP
    public void addGold(int moreGold)
    {
        /**
         * Class method which increases a players gold.
         */
        gp += moreGold;
    }//end addGold
    public void reduceGold(int reduceGold)
    {
        /**
         * Class method which reduces a players gold.
         */
        gp -= reduceGold;
    }//end reduceGold
    public void addExp(int moreExp)
    {
        /**
         * Class method which increases a players experience.
         */
        exp += moreExp;
    }// end addExp
    
    
    /**
     * @return the name of character
     */
    public String getName() 
    {
        return characterName;
    }

    /**
     * Define the name of character
     * @param name
     *           the name to set
     */
    public void setName(String name) {
        characterName = name;
    }

 
    public int roll3D6()
    {
        /**
         * Class method to be called on by method requiring a roll
         * of 3 6-sided dice and their total.
         */
        Random random1 = new Random();
        int r = random1.nextInt(6) +1;
        r += random1.nextInt(6) +1;
        r += random1.nextInt(6) +1;
        return r;
    }//end methood roll3D6
    private int findMod(int score)
    {
        /**
         * Class method to be called on by method requiring any
         * modification of specific character attributes and 
         * given points.
         */
        int r = 0;
        switch (score)
        {
            case 1: r= -5; break;
            case 2:
            case 3: r= -4; break;
            case 4:
            case 5: r= -3; break;
            case 6:
            case 7: r= -2; break;
            case 8:
            case 9: r= -1; break;
            case 10:
            case 11: r= 0; break;
            case 12:
            case 13: r= 1; break;
            case 14:
            case 15: r= 2; break;
            case 16:
            case 17: r= 3; break;
            case 18: r= 4; break;

        }
        return r;

    }//end method findMod
   
     
    public void reportStats()
    {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║  Your characters name is: " + characterName);
        
        switch( charClass )
        {
         case FIGHTER:
         System.out.println("║  Class: Fighter");
         break;
         case CLERIC:
         System.out.println("║  Class: Cleric");
         break;
         case THIEF:
         System.out.println("║  Class: Thief");
         break;
         case MAGIC_USER:
         System.out.println("║  Class: Magic Users");
         break;
         case DRUID:
         System.out.println("║  Class: Druid");
         break;
        }
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║");
        System.out.println("║  STR: " + STR + "    INT: " + INT +"  WIS: " + WIS  );
        System.out.println("║  CON: " + CON + "    DEX: " + DEX +"  CHA: " + CHA);
        System.out.println("║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║  Attack Bonus: " + attackBonus + "    Damage Bonus: " + damageBonus +"    Armor Bonus: " + armorBonus);
        System.out.println("║  Gold Pieces: " + gp + "    Experience Points: " + exp + "    Hit Points: " + hp );
        System.out.println("║  Armor Class: " + ac);
        System.out.println("╚═════════════════════════════════════╝");
    }
    
}//end class
