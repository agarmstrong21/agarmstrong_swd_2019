/*
Name: Addison Armstrong
Name of Project: 22-7_RandomCircle_Easy
Name of Class: RandomCircle
Class Description: This is the RandomCircle Class. This will pop up a GUI with the Radius, Circumference, Diameter,
    and Area of a randomly generated circle.
*/

// Importing Java GUI and Random Tools.
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

// Creating the RandomCircle class that extends JPanel.
/** Creating the RandomCircle class that extends JPanel. This will pop up a GUI with the Radius, Circumference, Diameter,
        and Area of a randomly generated circle.*/
public class RandomCircle extends JPanel{

    // Initializing all the Private final variables of RandomCircle. This includes the Random Generator, the radius,
        // diameter, area, and circumference.
    private final Random rdm = new Random();
    private final double r = rdm.nextDouble()*100;
    private final double d = diameter(r);
    private final double a = area(r);
    private final double c = circumference(r);


    public RandomCircle(){
        // Creating the JFrame and its operations.
        JFrame f = new JFrame("Random Circle Generator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // Creating the JTextArea that contains all the information about the circle.
        JTextArea textarea = new JTextArea("Radius: " + r +
                "\nDiameter: " + d +
                "\nArea: " + a +
                "\nCircumference: " + c);

        // Setting this area to not editable
        textarea.setEditable(false);

        // Adding the circle and the TextArea to the JFrame. Setting the size, and visibility.
        f.add(this, BorderLayout.CENTER);
        f.add(textarea, BorderLayout.PAGE_END);
        f.setSize(400, 400);
        f.setVisible(true);
    }

    // Diameter Method
    private double diameter(double r){
        return 2*r;
    }

    // Area Method
    private double area(double r){
        return Math.PI * (r*r);
    }

    // Circumference Method
    private double circumference(double r){
        return Math.PI * diameter(r);
    }

    // Overridden Paint method that creates the circle when the class is called on.
    @Override
    public void paint(Graphics g){
        Shape circle = new Ellipse2D.Double(100.0,100.0,d,d);
        Graphics2D ga = (Graphics2D)g;
        ga.draw(circle);
    }
}
