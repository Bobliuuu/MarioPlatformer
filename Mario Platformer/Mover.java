import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mover superclass for each moving actor
 * Subclass of Actor
 * All moving objects will inherit methods of Mover
 * 
 * @author Jerry Zhu
 * @version December 2020
 */

public class Mover extends Actor
{
    // Instance variables
    protected int speed; // Speed of the object's movement
    protected int animationCounter; // Animation frame counter for when to change actor images
    protected int selection; // Selection type for each object
    protected int movementCounter; // Movement counter for how much object has moved
    
    /** 
     * Constructor for objects of class Mover
     */
    public Mover()
    {
        // Empty constructor since no instance variables need to be initialized
    }
    
    /**
     * Act - do whatever the Mover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Do nothing
    }
    
    // Documentation: setLocation(posX, posY)
    /**
     * Move the object to the right
     */
    protected void moveRight()
    {
        setLocation(getX() + speed, getY()); // Set the object's location to the right by speed
    }
    
    /**
     * Move the object to the left
     */
    protected void moveLeft()
    {
        setLocation(getX() - speed, getY()); // Set the object's location to the left by speed
    }
    
    /**
     * Move the object up
     */
    protected void moveUp()
    {
        setLocation(getX(), getY() - speed); // Set the object's location above by speed
    }
    
    /**
     * Move the object down
     */
    protected void moveDown()
    {
        setLocation(getX(), getY() + speed); // Set the object's location down by speed
    } 
    
    /**
     * Moving the goomba object
     */
    protected void moveGoomba()
    {
        if (movementCounter <= 250) // If the movement counter is less than or equal to 250 
        {
            moveLeft(); // Move the object to the left
        }
        else if (movementCounter <= 500) // If the movement counter is less than 500
        {
            moveRight(); // Move the object to the right
        }
        movementCounter++; // Increment the movement counter at every iteration
        if (movementCounter >= 500) // If the movement counter is greater or equal to 500
        {
            movementCounter = 0; // Reset movement counter to 0
        }
    }
    
    /**
     * Moving player Mario up and down (jumping)
     */
    protected void moveUpAndDown()
    {
        if (movementCounter <= 150) // If movement counter is less than or equal to 150
        {
            setLocation(getX() - 1, getY()); // Set the location of the player below by one pixel
            Actor Mario = getOneIntersectingObject(Mario.class); // Get the intersection with the player Mario
            setLocation(getX() + 1, getY()); // Set the location of the player above by one pixel
            moveUp(); // Move the player up
            if (Mario != null) // If the collision with the player exists
            {
                Mario.setLocation(Mario.getX(), Mario.getY() - speed); // Set the location of the player below by speed (move down)
            }
        }
        else if (movementCounter <= 300) // If movement counter is less than or equal to 300
        {
            setLocation(getX() - 1, getY()); // Set location of the player below by one pixel
            Actor Mario = getOneIntersectingObject(Mario.class); // Get the intersection with the player Mario
            setLocation(getX() + 1, getY()); // Set location of the player above by one pixel
            moveDown(); // Move the player down
            if (Mario != null) // If the collision with the player exists
            {
                Mario.setLocation(Mario.getX(), Mario.getY() + speed); // Set the location of the player above by speed (move up)
            }
        }
        movementCounter++; // Increment the movement counter at every iteration
        if (movementCounter >= 300) // If the value of the movement counter is more than 300
        {
            movementCounter = 0; // Reset movement counter to 0
        }
    }
    
    /**
     * Moving the horizontal platforms
     */
    protected void moveHFPlatform()
    {
        if (movementCounter <= 150) // If the movement counter is less than or equal to 150
        {
            setLocation(getX(), getY() - 1); // Set location of the player below by one pixel
            Actor MarioCollision = getOneIntersectingObject(Mario.class);
            setLocation(getX(), getY() + 1); // Set location of the player above by one pixel
            moveLeft(); // Move the player to the left
            if (MarioCollision != null && Mario.isDead == false) // If the collision with the player exists and Mario is not dead
            {
                MarioCollision.setLocation(MarioCollision.getX() - speed, MarioCollision.getY()); // Set the location of the player to the left by speed (move left)
            }
        }
        else if (movementCounter <= 300) // If the movement counter is less than or equal to 150
        {
            setLocation(getX(), getY() - 1); // Set location of the player below by one pixel
            Actor MarioCollision = getOneIntersectingObject(Mario.class); // Get the intersection with the player Mario
            setLocation(getX(),getY() + 1); // Set location of the player above by one pixel
            moveRight(); // Move the player to the right
            if (MarioCollision != null && Mario.isDead == false) // If the collision with the player exists and Mario is not dead
            {
                MarioCollision.setLocation(MarioCollision.getX() + speed, MarioCollision.getY()); // Set the location of the player to the right by speed (move right)
            }
        }
        movementCounter++; // Increment the movement counter at every iteration
        if (movementCounter >= 300) // If the value of the movement counter is more than 300
        {
            movementCounter = 0; // Reset movement counter to 0
        }
    }
}
