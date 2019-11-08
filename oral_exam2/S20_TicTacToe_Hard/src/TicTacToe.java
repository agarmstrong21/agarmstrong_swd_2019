import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class TicTacToe extends JFrame {

    private final boolean CompPlayer;

    public TicTacToe(boolean CompPlayer){
        this.CompPlayer = CompPlayer;
        setLayout(new GridLayout(0,2));

        ArrayList<JButton> buttonArr = new ArrayList<>();

        JButton Button1 = new JButton("");
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

        buttonArr.add(Button1);
        buttonArr.add(Button2);
        buttonArr.add(Button3);
        buttonArr.add(Button4);
        buttonArr.add(Button5);
        buttonArr.add(Button6);
        buttonArr.add(Button7);
        buttonArr.add(Button8);
        buttonArr.add(Button9);
    }

    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){

        }
    }
}
