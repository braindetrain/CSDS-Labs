import java.util.ArrayList;

public class MadLib extends ConsoleProgram 
{
    // Private constants
    private static final char PLACEHOLDER_START_CHARACTER = '[';
    private static final char PLACEHOLDER_END_CHARACTER = ']';

    // File reader to get the template from the "madlib.txt" file
    private MadLibFileReader madLibFileReader = new MadLibFileReader();

    public void run() 
    {
        // Gets the contents of the file "madlib.txt" as a String
        String template = madLibFileReader.getMadLibTemplate();

        // Get the list of placeholders from the template
        ArrayList<String> placeholders = getPlaceholders(template);

        // Check if the placeholders are valid and not malformed
        if (placeholders == null) 
        {
            System.out.println("Template is malformed.");
            return;
        }
        else if (placeholders.isEmpty()) 
        {
            System.out.println("The template contains no placeholders.");
            return;
        }

        // Get replacement words from the user for each placeholder
        ArrayList<String> replacements = getReplacements(placeholders);

        // Generate the Mad Lib with replacements
        String madLib = replaceAllPlaceholders(template, placeholders, replacements);

        // Output the final Mad Lib
        System.out.println("Generated Mad Lib Story:");
        System.out.println(madLib);
    }

    private ArrayList<String> getPlaceholders(String template) 
    {
        ArrayList<String> placeholders = new ArrayList<>();

        // Initialize variables to track placeholder parsing state
        boolean insidePlaceholder = false;
        StringBuilder currentPlaceholder = new StringBuilder();

        // Loop through the characters in the template
        for (char c : template.toCharArray()) 
        {
            if (c == PLACEHOLDER_START_CHARACTER) 
            {
                if (insidePlaceholder) 
                {
                    // If already inside a placeholder, it's malformed
                    return null;
                }
                insidePlaceholder = true;
                currentPlaceholder = new StringBuilder();
                currentPlaceholder.append(c);
            } 
            else if (c == PLACEHOLDER_END_CHARACTER) 
            {
                if (insidePlaceholder)
                {
                    currentPlaceholder.append(c);
                    placeholders.add(currentPlaceholder.toString());
                    insidePlaceholder = false;
                } 
                else 
                {
                    // If there is a closing character without an opening character, it's malformed
                    return null;
                }
            } 
            else if (insidePlaceholder) 
            {
                currentPlaceholder.append(c);
            }
        }

        // If we're still inside a placeholder at the end, it's malformed
        if (insidePlaceholder) 
        {
            return null;
        }

        return placeholders;
    }

    private ArrayList<String> getReplacements(ArrayList<String> placeholders) {
        ArrayList<String> replacements = new ArrayList<>();

        for (String placeholder : placeholders) {
            // Extract the placeholder name without the brackets, e.g., "Adjective" from "[Adjective]"
            String placeholderName = placeholder.substring(1, placeholder.length() - 1);

            // Prompt the user to input a replacement word
            String userInput = readLine("Enter a " + placeholderName + ": ");

            // Add the user's input as a replacement
            replacements.add(userInput);
        }

        return replacements;
    }

    private String replaceAllPlaceholders(String template, ArrayList<String> placeholders, ArrayList<String> replacements) {
        String madLib = template;

        for (int i = 0; i < placeholders.size(); i++) {
            madLib = madLib.replace(placeholders.get(i), replacements.get(i));
        }

        return madLib;
    }
}
