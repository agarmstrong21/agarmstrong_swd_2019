/*
Name: Addison Armstrong
Name of Project: 23-10_BouncingBalls
Name of Class: Ball
Class Description: This class contains the logic of the bouncing ball.
*/

// Importing the Java Swing and Mouse Event tools
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * This is the Ball class which extends JPanel and implements Runnable, this contains the logic of the BouncingBalls
 */
public class Ball extends JPanel implements Runnable {

    //
    public boolean moving;
    private int xVelocity = 10;
    private int yVelocity = 10;
    private int xPosition = 1;
    private int yPosition = 1;
    private final int radius = 50;

    @Override
    public void run() {

        // Creating and adding a new MouseListener
        MouseListener temp = new MouseListener() {
            /**
             * When mouse is clicked, switches the moving boolean to the opposite value.
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                moving = !moving;
            }

            // Unused MouseEvents methods
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        addMouseListener(temp);

        // Running the repaint and move methods until window is closed.
        while(true){
            repaint();
            move();
        }
    }

    /**
     * move method watches the position and moves the position of the ball. If the ball hits the wall, then the ball
     *      will move in the opposite direction, like negating the value of the velocity. But adding the velocity after
     *      100 ms. Only if the the moving boolean is true.
     */
    public void move(){
        // If moving boolean is true then...
        if(moving) {
            // Try catch to move the ball position
            try {
                // Waits for 100 ms
                Thread.sleep(100);

                // Adds the velocity to the current position
                xPosition += xVelocity;
                yPosition += yVelocity;

                // if ball hits the left or right walls, flips sign of velocity
                if(xPosition > this.getWidth() - radius) {
                    xVelocity = -xVelocity;
                } else if(xPosition < 0 ){
                    xVelocity = -xVelocity;
                }

                // if ball hits the top or bottom walls, flips sign of the velocity
                if(yPosition > this.getHeight() - radius){
                    yVelocity = -yVelocity;
                }else if(yPosition < 0 ){
                    yVelocity = -yVelocity;
                }
            }
            // If catch initiates, exits system.
            catch (InterruptedException e) {
                System.exit(1);
            }
        }
    }

    // Paints the circle in blue
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(xPosition,yPosition,radius,radius);
    }
}
