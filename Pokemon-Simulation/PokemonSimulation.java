import java.util.ArrayList;

public class PokemonSimulation extends ConsoleProgram {
    PokemonImages images = new PokemonImages();

    public void run() {
        println("Welcome to the Pokemon Simulator!");
        println("Set up your Pokemon Trainer:");

        // Create the player's trainer
        PokemonTrainer playerTrainer = createTrainer();

        println("Your opponent will be a computer-controlled trainer.");

        // Create the computer trainer
        ComputerTrainer computerTrainer = new ComputerTrainer("Computer");

        // Simulate the battle between player and computer
        simulateBattle(playerTrainer, computerTrainer);
    }

    private PokemonTrainer createTrainer() {
        print("Trainer, what is your name? ");
        String trainerName = readLine("Enter your name: ");
        println("Hello " + trainerName + "!");

        // Create the trainer
        PokemonTrainer trainer = new PokemonTrainer(trainerName);

        // Choose the first Pokemon
        Pokemon pokemon1 = choosePokemon();
        trainer.addPokemon(pokemon1);

        // Choose the second Pokemon
        Pokemon pokemon2 = choosePokemon();
        trainer.addPokemon(pokemon2);

        return trainer;
    }

    private Pokemon choosePokemon() {
        println("Choose your pokemon");
        String pokemonName = readLine("Enter the name of your Pokemon: ");
        println("You chose: ");
        println(images.getPokemonImage(pokemonName));

        // Create the Pokemon
        Pokemon pokemon = new Pokemon(pokemonName);

        // Teach moves to the Pokemon
        teachMoves(pokemon);

        return pokemon;
    }

    private void teachMoves(Pokemon pokemon) {
        while (true) {
            String choice = readLine("Would you like to teach " + pokemon.getName() + " a new move? (yes/no): ").toLowerCase();

            if (choice.equals("yes")) {
                String moveName = readLine("Enter the name of the move: ");
                int moveDamage = readInt("How much damage does this move do? ");
                Move move = new Move(moveName, moveDamage);
                pokemon.learnMove(move);
                println(pokemon.getName() + " learned " + move.getName() + " (" + move.getDamage() + " Damage)!");
            } else if (choice.equals("no")) {
                if (pokemon.getMoves().isEmpty()) {
                    println(pokemon.getName() + " has no moves!");
                } else {
                    println(pokemon.getName() + " has learned all of their moves.");
                }
                break;
            } else {
                println("Invalid choice. Please enter 'yes' or 'no'.");
            }
        }
    }

    private void simulateBattle(PokemonTrainer trainer1, PokemonTrainer trainer2) {
        println("Let the battle begin!");

        Pokemon currentPokemon1 = trainer1.getNextPokemon();
        Pokemon currentPokemon2 = trainer2.getNextPokemon();

        while (true) {
            // Player's turn
            println();
            println(trainer1.getName() + "'s turn!");
            Move move1 = selectMove(trainer1, currentPokemon1);

            // Perform the attack
            println(currentPokemon1.getName() + " attacks " + currentPokemon2.getName() + " with " + move1.getName() + "!");
            int damage1 = move1.getDamage();
            currentPokemon2.takeDamage(damage1);

            // Check if the computer's Pokemon has fainted
            if (currentPokemon2.hasFainted()) {
                println(currentPokemon2.getName() + " has fainted!");
                // Check if the computer trainer has lost
                if (trainer2.hasLost()) {
                    println(trainer1.getName() + " wins the battle!");
                    break;
                } else {
                    // Switch to the next available Pokemon for the computer trainer
                    currentPokemon2 = trainer2.getNextPokemon();
                    println(trainer2.getName() + " sends out " + currentPokemon2.getName() + "!");
                }
            }

            // Computer Trainer's turn
            println();
            println(trainer2.getName() + "'s turn!");
            Move move2 = ((ComputerTrainer) trainer2).chooseRandomMove(); // Cast to ComputerTrainer

            // Perform the attack
            println(currentPokemon2.getName() + " attacks " + currentPokemon1.getName() + " with " + move2.getName() + "!");
            int damage2 = move2.getDamage();
            currentPokemon1.takeDamage(damage2);
            
            println();
            println(currentPokemon1.getName() + "'s Health: " + currentPokemon1.getHealth());
            println(currentPokemon2.getName() + "'s Health: " + currentPokemon2.getHealth());

            // Check if the player's Pokemon has fainted
            if (currentPokemon1.hasFainted()) {
                println(currentPokemon1.getName() + " has fainted!");
                // Check if the player has lost
                if (trainer1.hasLost()) {
                    println(trainer2.getName() + " wins the battle!");
                    break;
                } else {
                    // Switch to the next available Pokemon for the player
                    currentPokemon1 = trainer1.getNextPokemon();
                    println(trainer1.getName() + " sends out " + currentPokemon1.getName() + "!");
                }
            }
        }
    }

    private Move selectMove(PokemonTrainer trainer, Pokemon pokemon) {
        ArrayList<Move> moves = pokemon.getMoves();
        println(trainer.getName() + ", choose a move for " + pokemon.getName() + ":");
        for (int i = 0; i < moves.size(); i++) {
            println(i + 1 + ". " + moves.get(i).getName() + " (" + moves.get(i).getDamage() + " Damage)");
        }

        while (true) {
            int choice = readInt("Enter the number of the move: ");
            if (choice >= 1 && choice <= moves.size()) {
                return moves.get(choice - 1);
            } else {
                println("Invalid choice. Please select a valid move.");
            }
        }
    }

    public static void main(String[] args) {
        new PokemonSimulation().run();
    }
}
