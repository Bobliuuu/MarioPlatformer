import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instructions class to display instructions when prompted
 * Subclass of Screen
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class Instructions extends Screen
{
    // Instance variables
    private final GreenfootImage instructionsScreen = new GreenfootImage("instructionsscreen.gif"); // Greenfoot image of the instructiosn screen
    
    /**
     * Constructor method for objects of class Instructions
     */
    public Instructions()
    {
        setImage(instructionsScreen); // Set the image to the instructions screen
    }
    
    /**
     * Act - do whatever the Instructions wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Do nothing
    } 
}
