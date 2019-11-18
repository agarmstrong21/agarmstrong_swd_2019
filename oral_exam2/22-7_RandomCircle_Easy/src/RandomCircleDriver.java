
import javax.swing.*;

public class RandomCircleDriver extends RandomCircle{
    public static void main(String[] args) {
        RandomCircle textFieldFrame = new RandomCircle();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(400,100);
        textFieldFrame.setVisible(true);
    }
}
