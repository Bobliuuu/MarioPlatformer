import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mover extends Actor
{
    protected int speed;
    protected int animationCounter;
    protected int selection;
    protected int movementCounter;
    
    /**
     * Moves an object to the right. 
     */
    protected void moveRight()
    {
        setLocation(getX() + speed, getY());
    }
    
    /**
     * Moves an object to the right. 
     */
    protected void moveLeft()
    {
        setLocation(getX() - speed, getY());
    }
    
    protected void moveHFPlatform()
    {
        if (movementCounter <= 150)
        {
            moveLeft();
        }
        else if (movementCounter <= 300)
        {
            moveRight();
        }
        movementCounter++;
        if (movementCounter >= 300)
        {
            movementCounter = 0;
        }
    }
}
