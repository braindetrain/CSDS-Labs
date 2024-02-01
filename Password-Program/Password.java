// Name and Date: Brian Tran, August 29 2023
//Project Description: This program is designed to create passwords and help users create strong passwords. It enforces password requirements and and ensures users to confirm their chosen password with ease. 
import java.util.Scanner;

public class Password {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int consecutiveFailures = 0;

    while (true) 
    {
      //Prompts user to enter password 
      System.out.print("Enter your password: ");
      String password = input.nextLine();

      //Checks if all the requirements are met 
      if (checkRequirements(password)) 
      {
        boolean passwordConfirmed = false;
        int maxConfirmAttempts = 3; 
        //Gives user 3 chances to enter the correct confirmed password
        for (int confirmAttempt = 0; confirmAttempt < maxConfirmAttempts; confirmAttempt++) {
          System.out.print("Confirm your password: ");
          String confirmPassword = input.nextLine();

          if (password.equals(confirmPassword)) 
          {
            System.out.println("Password successfully created!");
            passwordConfirmed = true;
            break;
          } 

          //if the first password and the confirmed password don't match, the user is prompted again
          else 
          {
            System.out.println("Passwords do not match. Please try again");
          }
        }

        if (passwordConfirmed) 
        {
          break;
        } 
        else 
        {
          System.out.println("Maximum confirmation attempts reached. Starting over");
          consecutiveFailures++;
        }
      } 
    }

    input.close();
  }
  
    public static boolean checkRequirements(String password)
      {  
        //checks password length, has to be greater than 8 
        if (password.length() < 8)
        {
          System.out.println("Password must be at least 8 characters long.");
          return false;
        }

        //checks if password contains spaces
        else if (password.contains(" "))
        {
          System.out.println("Password must not include any spaces");
          return false;
        }

        //checks if password contaisn at least one number, one uppercase letter, and one special character
        int numberCount = 0;
        int upperCount = 0;
        int specialCount = 0;
        for(int i = 0; i < password.length(); i++)
          {
            char c = password.charAt(i);
            if (Character.isDigit(c))
            {
              numberCount++;
            }
            else if (Character.isUpperCase(c))
            {
              upperCount++;
  
            }
            else if(!Character.isLetterOrDigit(c))
            {
              specialCount++;
            }
          }
        if (numberCount == 0)
        {
          System.out.println("Password must contain at least one number");
          return false;
        }

        if (upperCount == 0)
        {
          System.out.println("Password must contain at least one uppercase character");
            return false;
        }

        if (specialCount == 0)
        {
          System.out.println("Password must contain at least one special character");
          return false;
        }
                
  
        return true;
      }
  }
