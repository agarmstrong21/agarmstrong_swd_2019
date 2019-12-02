/*
Name: Addison Armstrong
Name of Project: 23-10_BouncingBalls
Name of Class: BouncingBall
Class Description: This class starts the ExecutorServices and the ball class to start the bouncing ball
    in the GUI.
*/

// Importing Java Swing and Executor tools
import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This Class creates the GUI and starts the ExecutorService to start a thread for the ball.
 */
public class BouncingBall extends JFrame{
    public BouncingBall() {
        super("Bouncing Ball"); // Names the Window
        Ball b = new Ball(); // Creates and starts the ball class
        add(b); // adds the new Ball

        // Creates and executes the thread and Ball.
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(b);
        executorService.shutdown();
    }
}
