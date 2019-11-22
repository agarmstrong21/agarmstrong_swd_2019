import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class RandomCircle extends Frame{

//    private double d = 100.0;

//    public RandomCircle(){
//        super("Random Circle Generator");
//
//        Random rdm = new Random();
//        double radius = rdm.nextDouble()*10;
//        double d = diameter(radius);
//        double a = area(radius);
//        double c = circumference(radius);
//        this.diameter = d;
//        JTextField textField = new JTextField("Radius: " + radius +
//                "\nDiameter: " + d +
//                "\nArea: " + a +
//                "\nCircumference: " + c);
//        textField.setEditable(false);
//        add(textField);
//    }

    @Override
    public void paint(Graphics g){
        Shape circle=new Ellipse2D.Double(100.0,100.0,100,100);
        Graphics2D ga=(Graphics2D)g;
        ga.draw(circle);
    }

//    private double diameter(double r){
//        return 2*r;
//    }
//
//    private double area(double r){
//        return Math.PI * (r*r);
//    }
//
//    private double circumference(double r){
//        return Math.PI * diameter(r);
//    }
}
