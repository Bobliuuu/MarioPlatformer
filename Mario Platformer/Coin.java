import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Coin class to manage and display all coins
 * Subclass of Background
 * 
 * @author Jerry Zhu
 * @version December 2020
 */
public class Coin extends Background
{
    // Instance variables
    private final GreenfootImage Coin1 = new GreenfootImage("new_coin1.gif"); // Greenfoot image of the first coin animation
    private final GreenfootImage Coin2 = new GreenfootImage("new_coin2.gif"); // Greenfoot image of the second coin animation
    private final GreenfootImage Coin3 = new GreenfootImage("new_coin3.gif"); // Greenfoot image of the third coin animation
    
    /**
     * Constructor method for objects of class Coin
     */
    public Coin()
    {
        setImage(Coin1); // Set image to first coin animation
        Coin1.scale(35, 35); // Scale the coin to 35 x 35 pixels
    }
    
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animateCoin(); // Animate the coin object
        checkCollision(); // Check for collision with the player
    }
    
    /**
     * Animate the coin object by rotating the images displayed to the World
     */
    private void animateCoin()
    {
        animationCounter++; // Increment the animation counter
        // Animation order: 1, 2, 3, 2
        if (animationCounter < 9) // If the animation counter is less than 9
        {
            setImage(Coin1); // Set image to first coin animation
            Coin1.scale(35, 35); // Scale the coin to 35 x 35 pixels
        }
        else if (animationCounter < 18) // If the animation counter is less than 18
        {
            setImage(Coin2); // Set image to second coin animation
            Coin2.scale(35, 35); // Scale the coin to 35 x 35 pixels
        }
        else if (animationCounter < 27) // If the animation counter is less than 27
        {
            setImage(Coin3); // Set image to third coin animation
            Coin3.scale(35, 35); // Scale the coin to 35 x 35 pixels
        }
        else if (animationCounter < 36) // If the animation counter is less than 36
        {
            setImage(Coin2); // Set image to second coin animation
            Coin2.scale(35, 35); // Scale the coin to 35 x 35 pixels
        }
        if (animationCounter >= 36) // If the animation counter is greater than or equal to 36
        {
            animationCounter = 0; // Reset animation counter to 9
            setImage(Coin1); // Set image to first coin animation
            Coin1.scale(35, 35); // Scale the coin to 35 x 35 pixels
        }
        
    }
    
    /**
     * If Mario collides with the coin, remove the coin object from the World
     */
    private void checkCollision()
    {
        Actor MarioCollision = getOneIntersectingObject(Mario.class); // Get the intersection of the coin with the player Mario
        if (MarioCollision != null && Mario.isDead == false && Mario.isWin == false) // If the collision with Mario exists
        {
            Greenfoot.playSound("smb_coin.wav"); // Play a sound to indicate a coin has been picked up
            Levels L = (Levels)getWorld(); // Get the current level displayed in the world
            Counter scoreCounter = L.getScoreCounter(); // Get the score counter of the current level
            scoreCounter.add(5); // Add 5 to the score counter variable
            Counter coinCounter = L.getCoinCounter(); // Get the coin counter of the current level
            coinCounter.add(1); // Add 1 o the coin counter variable
            getWorld().removeObject(this); // Remove this coin object from the world
        }
    }
}

