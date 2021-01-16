import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TitleScreen class to display title screen when prompted
 * Subclass of Screen
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class TitleScreen extends Screen
{
    // Instance variables
    private final GreenfootImage titleScreen = new GreenfootImage("titlescreen.gif"); // Greenfoot image for title screen object
    
    /**
     * Constructors for objects of type LoseScreen
     */
    public TitleScreen()
    {
        setImage(titleScreen); // Set image to title screen
    }
    
    /**
     * Act - do whatever the TitleScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //  Do nothing
    }    
}
