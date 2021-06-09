package sample;

public class Bar implements Comparable<Bar>{

    // Creates a new bar.
    public Bar(String name, String category, int value){}
    // Returns the name of this bar.
    public String getName(){return "a";}
    // Returns the category of this bar.
    public String getCategory(){return "a";}
    // Returns the value of this bar.
    public int getValue(){return 0;}
    // Compares two bars by value.
    public int compareTo(Bar other){return 0;}
    //Feel free to add other necessary method
}
