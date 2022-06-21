
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Goomba class for displaying and updating the enemy Goomba 
 * Subclass of Mover
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class Goomba extends Mover
{
    // Instance variables
    private final GreenfootImage gWalk1 = new GreenfootImage("goomba-walk1.gif"); // Greenfoot image for first goomba animation
    private final GreenfootImage gWalk2 = new GreenfootImage("goomba-walk2.gif"); // Greenfoot image for second goomba animation
    protected final GreenfootImage gDead = new GreenfootImage("goomba-dead.gif"); // Greenfoot image for the dead goomba object
    
    /**
     * Constructor method for objects of class Goomba
     */
    public Goomba()
    {
        this.speed = 1; // Set the goomba's speed to 1
        setImage(gWalk1); // Set image to the first goomba animation
        gWalk1.scale(38, 50); // Scale the first goomba animation image to 38 x 50 pixels
        gWalk2.scale(38, 50); // Scale the second goomba animation image to 38 x 50 pixels
    }
    
    /**
     * Act - do whatever the Goomba wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveGoomba(); // Move the enemy goomba object 
        animateGoomba(); // Animate the goomba's movement
        collisionDetection(); // Check for collision with the player Mario
    }
    
    /**
     * Animates the goomba's walk for each frame
     */
    private void animateGoomba()
    {
        animationCounter++; // Increments animation counter
        if (animationCounter < 7) // If value of animation counter is less than 7
        {
            setImage(gWalk1); // Set object image to the first goomba animation
        }
        else if (animationCounter < 14) // If value of animation counter is less than 14
        {
            setImage(gWalk2); // Set object image to the second goomba animation
        }
        else if (animationCounter > 21) // If value of animation counter is less than 21
        {
            animationCounter = 0; // Reset animation counter to 9
            setImage(gWalk1); // Set object image to the first goomba animation
        }
    }
    
    /**
     * Detect collisions with the Goomba and Mario class
     */
    private void collisionDetection()
    {
        if (getOneObjectAtOffset(-19, -50, Mario.class) != null || getOneObjectAtOffset(19, -50, Mario.class) != null) // If the collision exists above the goomba
        {
            getWorld().addObject(new GoombaDead(), getX(), getY() + 9); // Add a dead goomba to the screen to the right of the current goomba obejct
            getWorld().removeObject(this); // Remove the current goomba object
        }
        else if (getOneObjectAtOffset(-19, 10, Mario.class) != null || 
                 getOneObjectAtOffset(19, 10,Mario.class) != null) // If the collision exists to the left or the right of the goomba
        {
            Mario.isDead = true; // Set the variable isDead of the Mario class to true to indicate that player Mario has died
        }
    }
}
