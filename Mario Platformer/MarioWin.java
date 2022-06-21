import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MarioWin class for displaying and animating the Mario actor once the player has won the game
 * Subclass of Mario
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class MarioWin extends Mario
{
    // Instance variables
    private final GreenfootImage win = new GreenfootImage("mario-idle.gif"); // Greenfoot image for stationary Mario facing right

    /**
     * Constructor method for objects of class MarioWin
     */
    public MarioWin()
    {
        setImage(win); // Set the image to Mario win
        win.scale(45, 45); // Scale the image to 45 x 45 pixels
    }

    /**
     * Act - do whatever the MarioDead wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animateWin(); // Animate Mario's win
    }    

    /**
     * Animate Mario's win when prompted
     */
    private void animateWin()
    {
        movementCounter++; // Increment the movement counter
        if (movementCounter <= 45) // If the movement counter is less than 50
        {
            this.speed = 8; // Set Mario's speed to 8 
            moveUp(); // Move Mario up 
        }
        else if (checkGround()) // If Mario is on the ground
        {
            Levels L = (Levels)getWorld(); // Get the current level from the world
            L.setupLevel(-2); // Set up the win screen 
            Greenfoot.delay(200);
        }
        else if (movementCounter > 45) // If the movement counter is greater than 50
        {
            this.speed = 8; // Set Mario's speed to 8 
            moveDown(); // Move Mario down
        }
    } 
}
