import javax.swing.*;
import java.util.Random;

public class RandomCircle extends JFrame{

    public RandomCircle(){
        super("Random Circle Generator");

        Random rdm = new Random();
        double radius = rdm.nextDouble();
        double d = diameter(radius);
        double a = area(radius);
        double c = circumference(radius);
        JTextField textField = new JTextField("Radius: " + radius +
                "\nDiameter: " + d +
                "\nArea: " + a +
                "\nCircumference: " + c);
        textField.setEditable(false);
        add(textField);
    }

    private double diameter(double r){
        return 2*r;
    }

    private double area(double r){
        return Math.PI * (r*r);
    }

    private double circumference(double r){
        return Math.PI * diameter(r);
    }
}
