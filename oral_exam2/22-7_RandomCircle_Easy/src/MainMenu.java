import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainMenu extends JFrame{
    public MainMenu() {
        super("Main Menu");
        setLayout(new FlowLayout((FlowLayout.CENTER, 5, 5));

        JButton CompPlayerButton = new JButton("Computer Vs. Player");
        JButton PlayerPlayerButton = new JButton("Player Vs. Player");
        add(PlayerPlayerButton);
        add(CompPlayerButton);

        ButtonHandler buttonHandler = new ButtonHandler();
        PlayerPlayerButton.addActionListener(buttonHandler);
        CompPlayerButton.addActionListener(buttonHandler);
    }

    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){

        }
    }
}
