class Main {
  public static void main(String[] args) {
    try{
      SongQueue.main(args);
    }
    catch(Exception e){
      System.out.println("Something went wrong");
      e.printStackTrace();
    }
  }
}
