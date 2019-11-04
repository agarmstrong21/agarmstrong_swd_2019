import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    public MainMenu() {
        super("Main Menu");
        setLayout(new FlowLayout((FlowLayout.CENTER), 5, 5));

        JButton CompPlayerButton = new JButton("Computer Vs. Player");
        JButton PlayerPlayerButton = new JButton("Player Vs. Player");
        add(PlayerPlayerButton);
        add(CompPlayerButton);

        PPBHandler ppbHandler = new PPBHandler();
        CPBHandler cpbHandler = new CPBHandler();
        PlayerPlayerButton.addActionListener(ppbHandler);
        CompPlayerButton.addActionListener(cpbHandler);
    }

    private class PPBHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            RandomCircle textFieldFrame = new RandomCircle();
            textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            textFieldFrame.setSize(400,100);
            textFieldFrame.setVisible(true);
        }
    }

    private class CPBHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){

        }
    }
}
