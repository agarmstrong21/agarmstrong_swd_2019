/*
Name: Addison Armstrong
Name of Project: 23-10_BouncingBalls_Easy
Name of Class: BouncingBallDriver
Class Description: This is the driver class to start the Bouncing Ball GUI.
*/

// Importing Java Swing tools
import javax.swing.*;

/**
 * This is the BouncingBallDriver which starts the BouncingBall GUI
 */
public class BouncingBallDriver  {
    public static void main(String[] args){
        BouncingBall bouncingBall = new BouncingBall();
        bouncingBall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bouncingBall.setSize(400, 400);
        bouncingBall.setVisible(true);
    }
}
