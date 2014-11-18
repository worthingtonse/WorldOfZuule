 

/**
 * You can name you equipment anything that you want and then use the name
 * as a test. So if you create a key, you could say if(equipment1.name.equals("Key")
 * open door. 
 */

public class Equipment {

    private String name;
    private int weight;
    
    /**
     * Create a new Equipment.
     * @param name
     * @param weight
     */
    public Equipment(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Return a name of the item. 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Define the name of the item.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return a description of the item.     * 
     * @return the description
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Define the description of the item.
     * @param description the description to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

}
