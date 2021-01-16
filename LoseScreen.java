import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LoseScreen class to display lose screen when prompted
 * Subclass of Screen
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class LoseScreen extends Screen
{
    // Instance variables
    private final GreenfootImage loseScreen = new GreenfootImage("losescreen.gif"); // Greenfoot image for lose screen object
    
    /**
     * Constructors for objects of type LoseScreen
     */
    public LoseScreen()
    {
        setImage(loseScreen); // Set image to lose screen
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
