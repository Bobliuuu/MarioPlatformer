import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DeadGoomba class to display and animate the dead goomba
 * Subclass of Goomba
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class GoombaDead extends Goomba
{
    /**
     * Constructor for objects of class GoombaDead
     */
    public GoombaDead()
    {
        // Empty constructor since no instance variables need to be initialized
    }
    
    /**
     * Act - do whatever the GoombaDead wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(gDead); // Set image to the dead goomba
        animateDeath(); // Animate the death of the goomba enemy
    } 
    
    /**
     * Animate the death of the enemy goomba object
     */
    private void animateDeath()
    {
        Levels L = (Levels)getWorld(); // Get the current level from the World 
        Counter scoreCounter = L.getScoreCounter(); // Get the score counter object from the current level
        scoreCounter.add(10); // Add 10 points to the score counter for jumping on a goomba
        Greenfoot.playSound("smb_stomp.wav"); // Play a sound to indicate a goomba enemy has been killed
        this.speed = 3; // Set speed of the goomba to 3
        moveDown(); // Move the goomba down 
        getWorld().removeObject(this); // Remove this goomba object from the World
    }
}
