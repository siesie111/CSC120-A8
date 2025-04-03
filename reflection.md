Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?

The first method I decided to overload for each of the Library, Cafe, and House subclasses is the constructor. The original constructor contains a more full information, but sometimes will be overly complicated. The simpler constructors I created for each subclasses satisfy the use when users only want to check certain most frequent information like resident / collection / storage list. 

In the Cafe class, I wrote an overload method of sellCoffee(int count) to, instead of updating the storage, update the number of customers the Cafe sells coffee to, using the private int customerCount in the Cafe class. This is a useful method when the Cafe wants to record either or both the information about selling coffee related to storage or customer counts. 

In the House class, I include another constructor with House name and Hashtable of the residence list and the floor they live in. This constructor is used in another method I overload in the House class called isResident(String name, int floor). This method is useful when needing to check whether a person is a resident with not only the name but also the floor they live in, to serve as a double security and avoid repeated names. 

In the Library class, I overload the method printCollection, with an input parameter boolean isOrNotInStock, to help print the colleciton based on its input checkout status. If isOrNotInStock is true, the method will only print the colleciton in stock. If isOrNotInStock is false, the method will only print the collections that are not in stock. 

- What worked, what didn't, what advice would you give someone taking this course in the future?

Inhertance is very useful for organizing and remove redundancy of the codes, but implementing the technique of inheritance means we need to keep track of which is parent class, which is subclass, and what methods are we inheriting from the parent class, what methods are we overriding from the parent class, which methods are we overloading in the parent class, and if we use the super() correctly in the subclasses. The advice will be keep track of the methods we want to override or overload, and make sure they are in the corresponding sub / parent class.