import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel {

    JFrame f = new JFrame("TicTacToe");
    protected ArrayList<JButton> Buttons = new ArrayList(9);
    protected boolean p1turn = true;
    protected JButton PvCButton = new JButton("<html>Player<br/>vs.<br/>Computer</html>"),
            PvPButton = new JButton("<html>Player<br/>vs.<br/>Player</html>"),
            CvCButton = new JButton("<html>Computer<br/>vs.<br/>Computer</html>");
    protected JButton b1 = new JButton(), b2 = new JButton(), b3 = new JButton(), b4 = new JButton(), b5 = new JButton(),
            b6 = new JButton(), b7 = new JButton(), b8 = new JButton(), b9 = new JButton();
    protected JTextArea textarea = new JTextArea();

    protected ArrayList<Player> Players = new ArrayList(2);
    protected Player player1 = null;
    protected Player player2 = null;

    public Board(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(4,3));

        Buttons.add(b1);
        Buttons.add(b2);
        Buttons.add(b3);
        Buttons.add(b4);
        Buttons.add(b5);
        Buttons.add(b6);
        Buttons.add(b7);
        Buttons.add(b8);
        Buttons.add(b9);

        PvCHandler PvCHandler = new PvCHandler();
        PvPHandler PvPHandler = new PvPHandler();
        CvCHandler CvCHandler = new CvCHandler();
        PvCButton.addActionListener(PvCHandler);
        PvPButton.addActionListener(PvPHandler);
        CvCButton.addActionListener(CvCHandler);

        ButtonHandler ButtonHandler = new ButtonHandler();
        b1.addActionListener(ButtonHandler);
        b2.addActionListener(ButtonHandler);
        b3.addActionListener(ButtonHandler);
        b4.addActionListener(ButtonHandler);
        b5.addActionListener(ButtonHandler);
        b6.addActionListener(ButtonHandler);
        b7.addActionListener(ButtonHandler);
        b8.addActionListener(ButtonHandler);
        b9.addActionListener(ButtonHandler);

        f.add(PvCButton);
        f.add(PvPButton);
        f.add(CvCButton);
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
        f.setSize(450,600);
        f.setVisible(true);


    }

    private class PvCHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            PvCButton.setEnabled(false);
            PvPButton.setEnabled(false);
            CvCButton.setEnabled(false);
            player1 = new HumanPlayer();
            player2 = new ComputerPlayer();
        }

    }

    private class PvPHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            PvCButton.setEnabled(false);
            PvPButton.setEnabled(false);
            CvCButton.setEnabled(false);
            player1 = new HumanPlayer();
            player2 = new HumanPlayer();
        }

    }

    private class CvCHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            PvCButton.setEnabled(false);
            PvPButton.setEnabled(false);
            CvCButton.setEnabled(false);
            player1 = new ComputerPlayer();
            player2 = new ComputerPlayer();
        }

    }

    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            JButton temp = (JButton) event.getSource();
            if(p1turn){
                temp.setText("X");
                temp.setEnabled(false);
                p1turn = false;
            }else{
                temp.setText("0");
                temp.setEnabled(false);
                p1turn = true;
            }
            win();
        }
    }

    private void win(){
        ArrayList<JButton> winners = new ArrayList<>(3);
        if(b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText())){
            winners.add(b1);
            winners.add(b2);
            winners.add(b3);
        }
        for(int i = 0; i < 3; i ++){
            winners.get(i).setBackground(Color.GREEN);
        }
        if(winners.get(2) != null){
            for(int i = 0; i < Buttons.size(); i++){
                Buttons.get(i).setEnabled(false);
            }
            if(winners.get(2).getText().equals("X")){
                JOptionPane.showInputDialog("Player 1 Won!");
            }else{
                JOptionPane.showInputDialog("Player 2 Won!");
            }

        }

    }

}
