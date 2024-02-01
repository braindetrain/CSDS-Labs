import java.util.Objects;

public class Move {
    // Private constants
    private static final int MAX_DAMAGE = 25;
    private String name;
    private int damage; 
    
    // Constructor
    public Move(String name, int damage) 
    {
        this.name = name;
        if (damage > MAX_DAMAGE) 
        {
            this.damage = MAX_DAMAGE;
        } 
        else 
        {
            this.damage = damage;
        }
    }
    
    // Getter methods
    public String getName() 
    {
        return name;
    }
    
    public int getDamage() 
    {
        return damage;
    }
    
    // toString method
    public String toString() 
    {
        return name + "(" + damage + " Damage)";
    }
}
