///name: Brian Tran    date: 2/22/24
//first program on queues.
import java.io.*;
import java.util.*;
public class SongQueue
{
  private static Scanner keyboard;
  private static Queue<String> songQueue = new LinkedList<>();
  
  public static void main(String[] args) throws Exception
  {
    keyboard = new Scanner(System.in);
    
    fillPlayList();
    printSongList();
    
    String prompt = "\tAdd song (A), Play song (P), Delete song (D), Quit (Q):  ";
    System.out.print(prompt);
    
    String str = keyboard.nextLine().toUpperCase();
    //process input until user quits
    while(!str.equals("Q"))
    { 
      processRequest( str );
      System.out.print(prompt);
      str = keyboard.nextLine().toUpperCase();
    } 

    //user quits, display goodbye message 
    System.out.println();
    System.out.println("No more music for you today.  Goodbye!");
    keyboard.close();
  }
  //fills the queue with songs
  public static void fillPlayList()throws IOException
  {
    Scanner inFile = new Scanner (new File("songs.txt"));
    while (inFile.hasNext())
      {
        String song = inFile.nextLine();
        songQueue.offer(song);
      }
    inFile.close();
  }

  //do the requested action
  public static void processRequest(String str)
  {
    if (str.equals("A"))
      add();
    else if (str.equals("P"))
      play();
    else if (str.equals("D"))
    {
      delete();
    }
    else
      System.out.println("Invalid input.");
  }

  //add a song to the end of the queue
  public static void add()
  {
    System.out.print("Enter song to add: ");
    String song = keyboard.nextLine();
    songQueue.offer(song);
    System.out.println(song + " has been added to the queue.");
  }

  //play the next song from the queue
  public static void play()
  {
    if (!songQueue.isEmpty())
    {
      String song = songQueue.poll();
      System.out.println("Now playing: " + song);
    }
    else
    {
      System.out.println("Queue is empty.");
    }
  }

  //delete the next song in the queue
  public static void delete()
  {
    if (!songQueue.isEmpty())
    {
      String removedSong = songQueue.poll();
      System.out.println(removedSong + " has been deleted from the queue.");
    }
    else
    {
      System.out.println("Queue is empty.");
    }
  }

  //print the current song list in the queue 
  public static void printSongList()
  {
    if (!songQueue.isEmpty())
    {
      System.out.println("Current Song Queue:");
      for (String song : songQueue)
        {
          System.out.println(song);
        }
    }
    else
    {
      System.out.println("Queue is empty.");
    }
  }
}
