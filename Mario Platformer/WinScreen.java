import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * WinScreen class to display win screen when prompted
 * Subclass of Screen
 * 
 * @author Jerry Zhu 
 * @version December 2020
 */
public class WinScreen extends Screen
{
    // Instance variables
    private final GreenfootImage winScreen = new GreenfootImage("winscreen.gif"); // Greenfoot image of win screen object
    
    /**
     * Constructor for objects of class WinScreen
     */
    public WinScreen()
    {
        setImage(winScreen); // Set image to win screen
    }   
    
    /**
     * Act - do whatever the WinScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Do nothing
    }   
}
