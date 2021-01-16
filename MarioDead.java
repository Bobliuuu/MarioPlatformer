import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MarioDead class for displaying and animating the dead Mario actor
 * Subclass of Mario
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class MarioDead extends Mario
{
    // Instance variables
    private final GreenfootImage dead = new GreenfootImage("mario-dead.gif"); // Greenfoot image of the dead mario object

    /**
     * Constructor method for objects of class MarioDead
     */
    public MarioDead()
    {
        setImage(dead); // Set the image to dead Mario
        dead.scale(45, 45); // Scale the image to 45 x 45 pixels
    }

    /**
     * Act - do whatever the MarioDead wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animateDeath(); // Animate Mario's death
    }    

    /**
     * Animate Mario's death when prompted
     */
    private void animateDeath()
    {
        movementCounter++; // Increment the movement counter
        if (movementCounter <= 50) // If the movement counter is less than 50
        {
            this.speed = 8; // Set Mario's speed to 8 
            moveUp(); // Move Mario up 
        }
        else if (getY() >= getWorld().getHeight() + 100) // If Mario is below the screen
        {
            Levels L = (Levels)getWorld(); // Get the current level from the World
            L.setupLevel(L.level); // Reset the current world for Mario to try again
        }
        
        else if (movementCounter > 50) // If the movement counter is greater than 50
        {
            this.speed = 8; // Set Mario's speed to 8
            moveDown(); // Move Mario down
        }
    }
}
