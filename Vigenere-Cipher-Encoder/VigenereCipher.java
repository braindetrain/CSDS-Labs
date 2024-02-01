//Brian Tran
//9/17/2023
//Vigenere Cipher lab
//Program that implements Vigenere cipher encryption. The Vigenere cipher is a polyalphabetic substitution cipher that uses a keyword to shift letters in the plaintext to produce ciphertext.
import java.util.Scanner;

public class VigenereCipher
{
  public static void main(String[] args)
  {
    //initiate a scanner to take input
    Scanner scanner = new Scanner(System.in);

    //run until valid keyword
    while (true)
    {
      //prompt for keyword
      System.out.print("Enter the keyword: ");
      String keyword = scanner.nextLine();

      if (isValidKeyword(keyword))
      {
        //prompt for plaintext
        System.out.print("Enter the message: ");
        String message = scanner.nextLine();
        //encrypt message
        String encryptedMessage = encryptMessage(message, keyword);
        //return encrypted message
        System.out.println("Encrypted message: " + encryptedMessage);
        break;
      }
      //invalid keyword
      else
      {
        System.out.println("Keyword must contain only alphabetical characters");
      }
    }
    
    scanner.close();
  }
    
//Methods
  //check for valid keyword
  public static boolean isValidKeyword(String keyword)
  {
    for (char c: keyword.toCharArray())
      {
        if (!Character.isLetter(c))
        {
          return false;
        }
      }
      return true; 
  } 
  //encrypt message
  public static String encryptMessage(String message, String keyword)
  {
    String encryptedMessage = "";
    int keywordLength = keyword.length();
    int messageIndex = 0;
    //run for as long as the message
    for (char c: message.toCharArray())
      {
        //ignore non-alphabetical charqacters
        if (Character.isLetter(c))
        {
          //determine shift
          char keyChar = keyword.charAt(messageIndex % keywordLength);
          int shift = Character.toUpperCase(keyChar) - 'A';
          encryptedMessage += encryptChar(c, shift);
          messageIndex++;
        }
        else
        {
          encryptedMessage += c;
        }
      }
    return encryptedMessage;
  }

  public static String encryptChar(char c, int shift)
  {
    //if the character is uppercase subtract by 65, if lowercase subtract by 97 to get decimal values
    char base;
    if (Character.isLowerCase(c))
    {
      base = 'a';
    }
    else
    {
      base = 'A';
    }
    //shift the characters
    char encryptedChar = (char) (((c - base + shift) % 26 ) + base);
    String encryptedString = String.valueOf(encryptedChar);
    return encryptedString;
  }
}
  

    

