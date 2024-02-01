import java.util.ArrayList;
import java.util.List;

public class Pokemon 
{
    private static final int MAX_HEALTH = 100;
    private static final int MAX_NUM_MOVES = 4;
    
    private String name;
    private int health;
    private List<Move> moves;
    private String image; // New instance variable to store the ASCII art image
    
    public Pokemon(String name) 
    {
        this(name, null); // Calls the new constructor with a default null image
    }
    
    public Pokemon(String name, String image) 
    {
        this.name = name;
        this.health = MAX_HEALTH;
        this.moves = new ArrayList<>();
        this.image = getPokemonImage(name); // Set the image when using the new constructor
    }
    
    public String getName() 
    {
        return name;
    }
    
    public int getHealth() 
    {
        return health;
    }
    
    public boolean hasFainted() 
    {
        return health <= 0;
    }
    
    public boolean canLearnMoreMoves(Move move) 
    {
        return moves.size() < MAX_NUM_MOVES;
    }
    
    public boolean learnMove(Move move) 
    {
        if (!canLearnMoreMoves(move)) 
        {
            return false;
        }
        moves.add(move);
        return true;
    }
    
    public void forgetMove(Move move) 
    {
        for (int i = 0; i < moves.size(); i++) 
        {
            Move knownMove = moves.get(i);
            if (knownMove.equals(move))
            {
                moves.remove(i);
                return;
            }
        }
    }
    
    public void setImage(String image) 
    {
        this.image = image;
    }
    
    public String getImage() 
    {
        return image;
    }
    
    public ArrayList<Move> getMoves()
    {
        return new ArrayList<>(moves);
    }
    
    public boolean knowsMove(Move move)
    {
        return moves.contains(move);
    }
    
    public boolean knowsMove(String moveName)
    {
        for (Move move : moves)
        {
            if (move.getName().equals(moveName))
            {
                return true;
            }
        }
        return false;
    }
    
    public void takeDamage(int damage)
    {
        health -= damage;
        if (health < 0)
        {
            health = 0;
        }
    }
    public boolean attack(Pokemon opponent, Move move)
    {
        if (knowsMove(move))
        {
            int damage = move.getDamage();
            opponent.takeDamage(damage);
            return true;
        }
        return false;
    }
    
    public boolean attack(Pokemon opponent, String moveName)
    {
        for (Move move : moves)
        {
            if (move.getName().equals(moveName))
            {
                return attack(opponent, move);
            }
        }
        return false;
    }
    
    private String getPokemonImage(String name) 
    {
        PokemonImages images = new PokemonImages();
        return images.getPokemonImage(name);
    }

    public String toString()
    {
        // Include the image if it's not null
        if (image != null) 
        {
            return image + "\n" + name + " (Health: " + health + " / " + MAX_HEALTH + ")";
        } else
        {
            return name + " (Health: " + health + " / " + MAX_HEALTH + ")";
        }
    }
}
