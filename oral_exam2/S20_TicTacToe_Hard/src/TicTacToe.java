import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToe extends JFrame {

    private final boolean CompPlayer;

    public TicTacToe(boolean CompPlayer){
        this.CompPlayer = CompPlayer;
        setLayout(new GridLayout(0,2));

        JButton Button1 = new JButton("");
        Button1.set;
        JButton Button2 = new JButton("");
        JButton Button3 = new JButton("");
        JButton Button4 = new JButton("");
        JButton Button5 = new JButton("");
        JButton Button6 = new JButton("");
        JButton Button7 = new JButton("");
        JButton Button8 = new JButton("");
        JButton Button9 = new JButton("");
        add(Button1);
        add(Button2);
        add(Button3);
        add(Button4);
        add(Button5);
        add(Button6);
        add(Button7);
        add(Button8);
        add(Button9);

        ButtonHandler Buttons = new ButtonHandler();

    }

    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){

        }
    }
}
