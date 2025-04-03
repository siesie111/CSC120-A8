/* This is a stub for the House class */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/*
 * House class that extends Building class
 * @author Sierra Zhang
 * @version April 1, 2025
 */
public class House extends Building {

  private ArrayList<String> resident; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean elevator;
  private Hashtable<String, Integer> residentWithFloor;

  /*
   * constructor for House class
   * @param String name
   * @param String address
   * @param int nFloors
   * @param ArrayList<String> residents
   * @param boolean hasDiningRoom
   */
  public House(String name, String address, int nFloors, ArrayList<String> resident, boolean hasDiningRoom, boolean elevator) {
    super(name, address, nFloors);
    this.resident = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.elevator = elevator;
    System.out.println("You have built a house: 🏠");
  }

  /*
   * a simpler constructor for when only need to use the info of the House and its resident list
   * @param String name
   * @param ArrayList<String> resident
   */
  public House(String name, ArrayList<String> resident){
    super(name);
    this.resident = new ArrayList<String>();
  }

  /*
   * this constructor includes the info of the resident in each house with the floor they live, which is handy when need to look at specific floor
   * @param String name
   * @param Hashtable<String, Integer> residientWithFloor
   */
  public House(String name, Hashtable<String, Integer> residientWithFloor){
    super(name);
    this.residentWithFloor = new Hashtable<String, Integer>();
  }

  /*
   * accessor for hasDiningRoom
   * @return boolean hasDiningRoom
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  /*
   * accessor for ArrayList<String> residents that returns the number of elements in this ArrayList
   * @return int residents.size()
   */
  public int nResidents(){
    return resident.size();
  }

  /*
   * add a resident to the ArrayList<String> residents
   * @param String name
   */
  public void moveIn(String name){
    try {
      if (!resident.contains(name)){
        resident.add(name);
      }
    } catch (RuntimeException e) {}
  }

  /*
   * remove a resident from the ArrayList<String> residents
   * @param String name
   * @return String name
   */
  public String moveOut(String name){
    try {
      if (resident.contains(name)){
        resident.remove(name);
      }
    } catch (RuntimeException e) {}
    return name;
  }

  /*
   * check if a person is in the residence list
   * @param String person
   * @return boolean true or false
   */
  public boolean isResident(String person){
    if (resident.contains(person)){
      return true;
    }
    else {
      return false;
    }
  }

  /*
   * this method override the isResident(String person) with the use of Hashtable, which helps to identify whether a person is a resident by checking not only the name but also the floor they live in
   * @param String name
   * @param int floor
   */
  public boolean isResident(String person, int floor){
    if (residentWithFloor.contains(floor) && residentWithFloor.containsKey(person)){
      return true;
    }
    else {
      return false;
    }
  }

  /*
  * overriding the showOption() methods to print all available options for the building 
  */
  public void showOptions(){
    System.out.println("Available options at " + name + ": \n + moveIn() + \n + moveOut() + \n + isResident(person)");
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
    ArrayList<String> resident = new ArrayList<String>(Arrays.asList("Apple", "Banna", "Watermelon"));
    House h = new House("Cutter House", "71 Elm Street, MA 01063", 3, resident, true, true);
  }

}