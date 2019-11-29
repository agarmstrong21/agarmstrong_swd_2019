/*
Name: Addison Armstrong
Name of Project: S36_ThanksGiving_Hard
Name of Class: Food
Class Description: This is the Food class. This class creates all the food items used in the program. Each Food item
    contains their own weight and enjoyment.
Warnings: If you wish to use ManualInput class, you must run it in that class. Not here.
*/

// Creating the Food Class.
/** Creating the Food Class. This class creates all the Food item.*/
public class Food {

    // Food variables name, weight, and enjoyment.
    private String name = "";
    private double weight = 0;
    private double enjoyment = 0;


    // Constructor of Food, intakes the name, weight, and enjoyment.
    public Food(String name, double weight, double enjoyment){
        this.name = name;
        this.weight = weight;
        this.enjoyment = enjoyment;
    }

    // Getter and Setters of each variable.
    public double getEnjoyment() {
        return enjoyment;
    }

    public void setEnjoyment(double enjoyment) {
        this.enjoyment = enjoyment;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Print method to print like the txt file.
    public void print(){
          System.out.println(name + " - weight: " +  weight + ", enjoyment: " + enjoyment);
    }
}
