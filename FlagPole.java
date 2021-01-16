import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Flagpole class for displaying and layering the flagpole image to the world
 * Subclass of Background
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class FlagPole extends Background
{
    // Instance variables
    private final GreenfootImage flagPole = new GreenfootImage("flagpole.gif"); // Greenfoot image of the flagpole object
    
    /**
     * Constructor method for objects of class CopyOfFlagPole
     */
    public FlagPole()
    {
        setImage(flagPole); // Set image to the flagpole 
    }  
    
    /**
     * Act - do whatever the TitleScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // Do nothing
    }
}
