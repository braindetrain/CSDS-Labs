import java.util.Random;
import java.util.ArrayList;

public class ComputerTrainer extends PokemonTrainer {

    // Private constants
    private static final String[] POKEMON_NAMES = {"Pikachu", "Bulbasaur", "Charmander", "Squirtle"};
    private static final String[] MOVE_NAMES = {"Tailwhip", "Bodyslam", "Splash", "Shock"};
    private static final int MAX_DAMAGE = 25;
    private static final int MAX_MOVES = 4;

    private int pokemonCount; // To keep track of the number of Pokemon

    private PokemonImages images = new PokemonImages();

    // Constructor
    public ComputerTrainer(String name) {
        super(name);
        pokemonCount = 0; // Initialize the count to zero
        // Add 2 randomly generated Pokemon to the ComputerTrainer
        addRandomPokemon();
        addRandomPokemon();
    }

    // Adds a randomly generated Pokemon to the ComputerTrainer's collection.
    // A ComputerTrainer can only have 2 Pokemon.
    // Returns true if the Pokemon was successfully added, false if there's no room.
    public boolean addRandomPokemon() {
        if (pokemonCount < 2) {
            Random rand = new Random();
            String randomPokemonName = POKEMON_NAMES[rand.nextInt(POKEMON_NAMES.length)];
            Pokemon randomPokemon = new Pokemon(randomPokemonName);

            // Teach random moves to the Pokemon
            for (int i = 0; i < MAX_MOVES; i++) {
                String randomMoveName = MOVE_NAMES[rand.nextInt(MOVE_NAMES.length)];
                int randomMoveDamage = rand.nextInt(MAX_DAMAGE) + 1; // Damage between 1 and MAX_DAMAGE
                randomPokemon.learnMove(new Move(randomMoveName, randomMoveDamage));
            }

            addPokemon(randomPokemon);
            pokemonCount++; // Increment the count
            return true;
        } else {
            return false; // No room for another Pokemon
        }
    }

    // Returns a Move randomly chosen from the set of Moves that this trainer's current Pokemon knows.
    // If all Pokemon have fainted, returns null.
    public Move chooseRandomMove() {
        Pokemon currentBattlingPokemon = getNextPokemon();

        if (currentBattlingPokemon != null) {
            ArrayList<Move> moves = currentBattlingPokemon.getMoves();
            if (!moves.isEmpty()) {
                Random rand = new Random();
                int randomMoveIndex = rand.nextInt(moves.size());
                return moves.get(randomMoveIndex);
            }
        }

        return null; // No available moves or all Pokemon have fainted
    }
}
