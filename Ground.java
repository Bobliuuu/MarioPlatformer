import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ground class for rendering and displaying the ground
 * Subclass of Mover
 * 
 * @author Jerry Zhu
 * @version 1
 */

public class Ground extends Mover
{
    // Instance variables
    private final GreenfootImage Stile = new GreenfootImage("stepping-tile.gif"); // Greenfoot image for stepping tile object
    private final GreenfootImage FPlatform = new GreenfootImage("floating-platform.gif"); // Greenfoot image for floating platform object
    private final GreenfootImage Block = new GreenfootImage("block.gif"); // Greenfoot image for block tile object
    
    /**
     * Constructor method for objects of class Ground
     */
    public Ground(int selection)
    {
        this.selection = selection; // Set the value of the selection instance variable to the parameter selection
        if(selection == 1) // If the value of selection is equal to 1
        {
            setImage(Stile); // Set the image to the stepping tile 
            Stile.scale(50, 50); // Scale the stepping tile to 50 x 50 pixels
        }
        else if ((selection == 2) || (selection == 3)){ // If the value of selection is equal to 2 or 3
            setImage(FPlatform); // Set the image to the floating platform
            FPlatform.scale(200, 35); // Scale the floating platform to 200 x 35 pixels
            this.speed = 2; // Set speed of moving platform to 2
        }
        else if (selection == 4) { // If the value of selection is equal to 4
            setImage(Block); // Set the image to the block tile
            Block.scale(30, 30); // Scale the block tile to 30 x 30 pixels
        } 
        else if  (selection == 5) // If the value of selection is equal to 5
        {
            setImage(FPlatform); // Set the image to the floating platform 
            FPlatform.scale(200, 35); // Scale the floating platform to 200 x 35 pixels
            this.speed = 2; // Set speed of moving platform to 2
        }
    }
   
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (selection == 1) // If the value of selection is equal to 1 
        {
            steppingTileCollisionDetection(); // Check collision for stepping tile with Mario object
        }
        else if (selection == 2) // If the value of selection is equal to 2
        {
            // Do nothing for stationary platforms
        }
        else if (selection == 3) // If the value of selection is equal to 3
        {
            movementCounter++; // Increment movement counter
            moveHFPlatform(); // Move the horizontal platform left and right
        }
        else if (selection == 4) // If the value of selection is equal to 4
        {
            // Do nothing for block tiles
        }
         else if  (selection == 5) // If the value of selection is equal to 5
        {
            movementCounter++; // Increment movement counter
            moveUpAndDown(); // Move the vertical platform up and down 
        }
    }    
    
    /**
     * Detect collision with stepping tile object and player Mario object
     */
    private void steppingTileCollisionDetection()
    {
        Actor MarioLeft = getOneObjectAtOffset(10, 0, Mario.class); // Check collision if Mario hits the tile on the left side
        Actor MarioRight = getOneObjectAtOffset(-10, 0, Mario.class); // Check collision if Mario hits the tile on the right side
        Actor MarioHead = getOneObjectAtOffset(0, 60, Mario.class); // Check collision if Mario is hitting the tile from the top (jumping into it)
        if (MarioLeft != null) // If Mario hits the tile on the left side
        {
            MarioLeft.setLocation(MarioLeft.getX() + 7, MarioLeft.getY()); // Set Mario's location to the right by 7 pixels and push the player away from the tile
        }
        else if (MarioRight != null) // If Mario hits the tile on the right side
        {
            MarioRight.setLocation(MarioRight.getX() - 7, MarioRight.getY()); // Set Mario's location to the left by 7 pixels and push the player away from the tile
        }
        else if (MarioHead!= null) // If Mario hits the tile from the top
        {
            MarioHead.setLocation(MarioHead.getX() , MarioHead.getY() + 10); // Set Mario's location below by 10 pixels and push the player away from the tile
        }
    }
}
