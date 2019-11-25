import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    private ArrayList<JButton> Button = new ArrayList(9);

    public Board(){
        JFrame f = new JFrame("TicTacToe");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(3,3));

        JButton b1 = new JButton(), b2 = new JButton(), b3 = new JButton(), b4 = new JButton(), b5 = new JButton(),
                b6 = new JButton(), b7 = new JButton(), b8 = new JButton(), b9 = new JButton();
        Button.add(b1);
        Button.add(b2);
        Button.add(b3);
        Button.add(b4);
        Button.add(b5);
        Button.add(b6);
        Button.add(b7);
        Button.add(b8);
        Button.add(b9);


        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.pack();
        f.setSize(400,400);
        f.setVisible(true);
    }

}
