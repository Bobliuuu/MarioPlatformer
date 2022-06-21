import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameEnd screen to display the game end screen when prompted
 * Subclass of Screen
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class GameEnd extends Screen
{
    // Instance variables
    private final GreenfootImage gameEndScreen = new GreenfootImage("gameend.gif"); // Greenfoot image of the instructiosn screen
    
    /**
     * Constructor method for objects of class Instructions
     */
    public GameEnd()
    {
        setImage(gameEndScreen); // Set the image to the instructions screen
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
