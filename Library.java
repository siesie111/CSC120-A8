/* This is a stub for the Library class */

import java.util.Hashtable;

/*
 * Library class that extends Building class
 * @author Sierra Zhang
 * @version April 1, 2025
 */
public class Library extends Building{
  
    private Hashtable<String, Boolean> collection;
    private boolean elevator;

    /*
    * constructor for Library class
    * @param String name
    * @param String address
    * @param int nFloors
    * @param Hashtable<String, Boolean> collection
    * @param boolean elevator
    */
    public Library(String name, String address, int nFloors, Hashtable<String, Boolean> collection, boolean elevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.elevator = elevator;
      System.out.println("You have built a library: 📖");
    }

    /*
     * a simpler constructor when only want to use the info about Library and its collection
     * @param String name
     * @param Hashtable<String, Boolean> collection
     */
    public Library(String name, Hashtable<String, Boolean> collection){
      super(name);
      this.collection = new Hashtable<String, Boolean>();
    }

    /*
      * add the title of a new book to the collection list
      * @param String title
      */
    public void addTitle(String Title){
      collection.putIfAbsent(Title, true);
    }

    /*
      * remove the title of a book in the collection
      * @param String title
      * @return String title or RuntimeException
      */
    public String removeTitle(String title){
      if (collection.containsKey(title)){
        collection.remove(title);
        return title;
      }
      else{
        throw new RuntimeException(title + "is not in the collection of "+ name);
      }
    }

    /*
      * check out a book that is currently in the collection
      * @param String title
      */
    public void checkOut(String title){
      try{
        if (collection.containsKey(title)){
      collection.replace(title, false);
      }
      }
      catch (RuntimeException e){}
    }

    /*
      * return a book that is currently not in the collection
      * @param String title
      */
    public void returnBook(String title){
      try{
        if (!collection.containsKey(title)){
          collection.replace(title, true);
        }
      } catch (RuntimeException e){}
    }

    /*
      * check if a book exists in the collection using its title
      * @param title
      * @return true or false
      */
    public boolean containsTitle(String title){
      if (collection.containsKey(title)){
        return true;
      } else{
        return false;
      }
    }

    /*
      * check if a book is available in the collection by its title
      * @param String title
      * @return true or false
      */
    public boolean isAvailable(String title){
      if (collection.get(title) == true){
        return true;
      } else {
        return false;
      }
    }

    /*
      * print out the entire collection list with both String and Boolean
      */
    public void printCollection(){
      System.out.println("The collection contains: ");
      for (String book : collection.keySet()){
        System.out.println("Book: " + book + "Checkout Status: " + collection.get(book));
      }
    }

    /*
     * print only if the book is in stock or not, based on the input boolean
     * @param boolean isOrNotInStock
     */
    public void printCollection(boolean isOrNotInStock){
      System.out.println("The collection contains: ");
      for (String book : collection.keySet()){
        if (collection.get(book) == isOrNotInStock){
          System.out.println("Book: " + book);
        }
      }
    }

    /*
     * overriding the showOption() methods to print all available options for the building 
     */
    public void showOptions(){
      System.out.println("Available options for " + name + ": \n + addTitle(title) + \n + removeTitle(title) + \n + checkOut(title) + \n + returnBook(title) + \n + containsTitle(title) + \n + isAvailable(title) + \n + printCollection()");
    }

    /*
     * overriding the goToFloor() methods to use the elevator to move to non-adjacent floor
     */
    public void goToFloor(int n){
      try{
        if (this.elevator && n != activeFloor){
        super.goToFloor(n);
        }
      } catch (RuntimeException e){}
    }
    
    public static void main(String[] args) {
      Hashtable<String, Boolean> collection = new Hashtable<String, Boolean>();
      String title = "Think Java";
      String author = "Allen Downey and Chris Mayfield";
      collection.put(title+" by "+author, true);
      Library l = new Library("Neilson Library", "somewhere, MA 01063", 6, collection, true);
      l.printCollection();
    }
  
}