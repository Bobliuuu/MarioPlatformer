import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Background superclass for all background objects in the World
 * Subclass of Actor
 * All background objects will inherit the methods of Background
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class Background extends Actor
{
    // Instance variables
    protected int selection; // Selection type for each object
    protected int animationCounter; // Animation frame counter for when to change actor images
    
    /** 
     * Constructor for objects of class Background
     */
    public Background()
    {
        // Empty constructor since no instance variables need to be initialized
    }
    
    /**
     * Act - do whatever the Background wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Do nothing
    }    
}
