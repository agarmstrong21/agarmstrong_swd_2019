
import javax.swing.*;

public class RandomCircleDriver extends RandomCircle{
    public static void main(String[] args) {
        RandomCircle Frame = new RandomCircle();
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(400, 400);
        Frame.setVisible(true);
    }
}
