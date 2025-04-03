import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/*
 * Cafe class that extends Building class
 * @author Sierra Zhang
 * @version April 1, 2025
 */

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Dr Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Neilson Library", "7 Neilson Dr Northampton, MA 01063", 6));
        myMap.addBuilding(new Building("Cutter House", "79 Elm St Northampton, MA 01063"));
        myMap.addBuilding(new Building("Wright Hall", "5 Chapin Way", 1));
        myMap.addBuilding(new Building("Campus Center", "100 Elm St Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Alumnae House", "33 Elm St Northampton, MA 01063"));
        myMap.addBuilding(new Building("Haynes House", "1 Mandelle Rd Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Hartfield Hall", "3 Neilson Drive Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Capen House", "26 Prospect St Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Stoddard Hall", "23 Elm St Northampton, MA 01063", 3));
        System.out.println(myMap);
        
        // Library Class
        Hashtable<String, Boolean> collection = new Hashtable<>();
        String title = "Think Java";
        String author = "Allen Downey and Chris Mayfield";
        collection.put(title+" by "+author, true);
        Library l = new Library("Neilson Library",collection);
        l.printCollection(true);
        
        // House Class
        ArrayList<String> resident = new ArrayList<String>(Arrays.asList("Apple", "Banna", "Watermelon"));
        House h  = new House("Cutter House", resident);
        h.moveOut("Apple");
        Hashtable<String, Integer> residentWithFloor = new Hashtable<String, Integer>();
        residentWithFloor.put("Javanica", 3);
        House house = new House("Capen House", residentWithFloor);
        house.isResident("Javanica", 3);

        //Cafe Class
        Cafe c = new Cafe("Campus Center", 150, 50, 44, 67);
        c.sellCoffee(100);
    }
    
}
