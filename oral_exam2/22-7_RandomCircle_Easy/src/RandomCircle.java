import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class RandomCircle extends JPanel{

    private final Random rdm = new Random();
    private final double r = rdm.nextDouble()*100;
    private final double d = diameter(r);
    private final double a = area(r);
    private final double c = circumference(r);


    public RandomCircle(){
        JFrame f = new JFrame("Random Circle Generator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());


        JTextArea textarea = new JTextArea("Radius: " + r +
                "\nDiameter: " + d +
                "\nArea: " + a +
                "\nCircumference: " + c);
        textarea.setEditable(false);
        f.add(this, BorderLayout.CENTER);
        f.add(textarea, BorderLayout.PAGE_END);
        f.setSize(400, 400);
        f.setVisible(true);
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

    @Override
    public void paint(Graphics g){
        Shape circle=new Ellipse2D.Double(100.0,100.0,d,d);
        Graphics2D ga=(Graphics2D)g;
        ga.draw(circle);
    }
}
