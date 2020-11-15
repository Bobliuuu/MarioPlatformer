import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Mover
{
    private final GreenfootImage Coin1 = new GreenfootImage("coin-1.gif");
    private final GreenfootImage Coin2 = new GreenfootImage("coin-2.gif");
    private final GreenfootImage Coin3 = new GreenfootImage("coin-3.gif");
    
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animateCoin();
        checkCollision();
    }    
    private void animateCoin()
    {
        animationCounter++;
        if (animationCounter < 9)
        {
            setImage(Coin1);
            Coin1.scale(25, 30);
        }
        else if (animationCounter < 18)
        {
            setImage(Coin2);
            Coin2.scale(25, 30);
        }
        else if (animationCounter < 27)
        {
            setImage(Coin3);
            Coin3.scale(25, 30);
        }
        else if (animationCounter < 36)
        {
            setImage(Coin2);
            Coin2.scale(25, 30);
        }
        if (animationCounter > 36)
        {
            animationCounter = 0;
            setImage(Coin1);
        }
    }
    private void checkCollision()
    {
        Actor Mario = getOneIntersectingObject(Player.class);
        if (Mario != null)
        {
            getWorld().removeObject(this);
        }
    }
}
