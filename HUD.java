import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * HUD class to display and update counters 
 * Subclass of Background
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class HUD extends Background
{
    private final GreenfootImage life = new GreenfootImage("life.gif"); // Greenfoot image of the life counter object
    private final GreenfootImage coin = new GreenfootImage("new_coin1.gif"); // Greenfoot image of the coin counter object
    
    /**
     * Constructor method for objects of class HUD
     */
    public HUD(int selection)
    {
        this.selection = selection; // Set the value of the selection instance variable equal to the parameter selection
        if (selection == 1) // If the value of selection is equal to 1
        {
            setImage(life); // Set the image to the life counter
            life.scale(35, 35); // Scale the life counter to 35 x 35 pixels
        }
        else if (selection == 2) // If the value of selection is equal to 2
        {
            setImage(coin); // Set the image to the coin counter
            coin.scale(35, 35); // Scale the coin counter to 35 x 35 pixels
        }
    }
    
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animationCounter++; // Increment animation counter
    } 
}
