/* This is a stub for the Cafe class */

/*
 * Cafe class that extends Building class
 * @author Sierra Zhang
 * @version April 1, 2025
 */

import java.util.Scanner;

public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
    private int customerCount = 0;

    /*
     * contructor for Cafe class
     * @param String name
     * @param String address
     * @param int nFloors
     * @param int nCoffeeOunces
     * @param int nSugarPackets
     * @param int nCreams
     * @param int nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /*
     * a simpler constructor for when only want to the check the storage in the Cafe
     * @param String name
     * @parm int nCoffeeOunces
     * @param int nSugarPackets
     * @param int nCreams
     * @param int nCups
     */
    public Cafe(String name, int nCofeeOunces, int nSugarPackets, int nCreams, int nCups){
        super(name);
        this.nCoffeeOunces = nCofeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /*
     * update the inventory when sell coffee
     * @param int size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        int coffee = 0;
        int sugar = 0;
        int cream = 0;
        int cup = 0;
        if (this.nCoffeeOunces - size >= 0){
            this.nCoffeeOunces -= size;
        } else{
            System.out.println("Please restock the Coffee Ounces, currently none in stock.");
            Scanner s = new Scanner(System.in);
            System.out.println("How much ounces of coffee do you want to restock: ");
            int amt = s.nextInt();
            coffee = amt;
            s.close();
        }
        if (this.nSugarPackets - nSugarPackets >= 0){
            this.nSugarPackets -= nSugarPackets;
        } else{
            System.out.println("Please restock the Sugar Packets, currently none in stock.");
            Scanner s = new Scanner(System.in);
            System.out.println("How much packets of sugar do you want to restock: ");
            int amt = s.nextInt();
            sugar = amt;
            s.close();
        }
        if (this.nCreams - nCreams >=0){
            this.nCreams -= nCreams;
        } else{
            System.out.println("Please restock the Creams, currently none in stock.");
            Scanner s = new Scanner(System.in);
            System.out.println("How much splashes of cream do you want to restock: ");
            int amt = s.nextInt();
            cream = amt;
            s.close();
        }
        if (this.nCups >0){
            this.nCups -= 1;
        }else {
            System.out.println("Please restock the Cups, currently none in stock");
            Scanner s = new Scanner(System.in);
            System.out.println("How much cups do you want to restock: ");
            int amt = s.nextInt();
            cup = amt;
            s.close();
        }
        restock(coffee, sugar, cream, cup);
    }

    /*
     * overload method for sellCoffee(), this is used to keep track of the number of customers the Cafe sell coffee to 
     * @param int count
     * @return int customer+count
     */
    public int sellCoffee(int count){
        return customerCount+count;
    }

    /*
     * restock the inventory when not enough 
     * @param int nCoffeeOunces
     * @param int nSugarPackets
     * @param int nCreams
     * @param int nCups
     */
    private void restock(int nCofeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /*
     * overriding the showOption() methods to print all available options for the building 
     */
    public void showOptions(){
        System.out.println("Available options at " + name + ": sellCoffee(size, sugar, cream) + \n + restock(coffee, sugar, cream, cup)");
    }
    
    public static void main(String[] args) {
        int nCoffeeOunces = 30;
        int nSugarPackets = 20;
        int nCreams = 13;
        int nCups = 24;
        Cafe c = new Cafe("CC", "123 St", nCups, nCoffeeOunces, nSugarPackets, nCreams, nCups);
        c.sellCoffee(140, 50, 32);
    }
    
}
