import greenfoot.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Mover
{
    private final GreenfootImage idleRight = new GreenfootImage("mario-idle.gif");
    private final GreenfootImage walk1Right = new GreenfootImage("mario-walk1.gif");
    private final GreenfootImage walk2Right = new GreenfootImage("mario-walk2.gif");
    private final GreenfootImage walk3Right = new GreenfootImage("mario-walk3.gif");
    private final GreenfootImage jumpRight = new GreenfootImage("mario-jump.gif");
    
    private final GreenfootImage idleLeft = new GreenfootImage(idleRight);
    private final GreenfootImage walk1Left = new GreenfootImage(walk1Right);
    private final GreenfootImage walk2Left = new GreenfootImage(walk2Right);
    private final GreenfootImage walk3Left = new GreenfootImage(walk3Right);
    private final GreenfootImage jumpLeft = new GreenfootImage(jumpRight);

    private boolean facingRight;
    private boolean isKeyPressed;

    private int verticalSpeed;
    private int acceleration = 1;
    private int marioBottomCentre;
    private int jumpDistance = 17;
    private boolean isJumping;
    public static boolean isDead;
    
    public Player()
    {
        this.speed = 7;
        this.facingRight = true;

        setImage(idleRight);
        
        idleRight.scale(38,50);
        walk1Right.scale(48,50);
        walk2Right.scale(36,50);
        walk3Right.scale(44,50);
        jumpRight.scale(48,50); 

        idleLeft.scale(38,50);
        walk1Left.scale(48,50);
        walk2Left.scale(36,50);
        walk3Left.scale(44,50);
        jumpLeft.scale(48,50);

        idleLeft.mirrorHorizontally();
        walk1Left.mirrorHorizontally();
        walk2Left.mirrorHorizontally();
        walk3Left.mirrorHorizontally();
        jumpLeft.mirrorHorizontally();
        
        marioBottomCentre = getImage().getHeight() / 2;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        boundary();
        if (getWorld() != null && !checkGround())
        {
            fall();
        }
        else 
        {
            isJumping = false;
        }
    }   
    private void boundary()
    {
        Levels L = (Levels) getWorld();
        if (getX() <= 20)
        {
            setLocation(20, getY());
        }
        else if (L.level == 4 && getX() >= 980)
        {
            setLocation(980, getY());
        }
        else if (getX() >= 1000)
        {
            L.setUpLevel(L.level + 1);
        }
    }
    private void checkKeys()
    {
        isKeyPressed = false;
        if (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("left"))
        {
            stopWalking();
        }
        
        else if (Greenfoot.isKeyDown("right"))
        {
            animationCounter++;    
            walkRight();
            isKeyPressed = true;
            facingRight = true;
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            animationCounter++;
            walkLeft();
            isKeyPressed = true;
            facingRight = false;
        }
        if (Greenfoot.isKeyDown("up") && isJumping == false)
        {
            isKeyPressed = true;
            jump();
        }
        if (!isKeyPressed)
        {
            stopWalking();
        }
    }
    
    private void walkRight()
    {
        moveRight();
        if (animationCounter < 4)
        {
            setImage(idleRight);
        }
        else if (animationCounter < 8)
        {
            setImage(walk1Right);
        }
        else if (animationCounter < 12)
        {
            setImage(walk2Right);
        }
        else if (animationCounter < 16)
        {
            setImage(walk3Right);
            animationCounter = 0;
            return;
        }
    }
    
    private void walkLeft()
    {
        moveLeft();
        if (animationCounter < 4)
        {
            setImage(idleLeft);
        }
        else if (animationCounter < 8)
        {
            setImage(walk1Left);
        }
        else if (animationCounter < 12)
        {
            setImage(walk2Left);
        }
        else if (animationCounter < 16)
        {
            setImage(walk3Left);
            animationCounter = 0;
            return;
        }
    }
    
    public void stopWalking()
    {
         if (facingRight)
         {
             setImage(idleRight);
         }
         else
         {
             setImage(idleLeft);
         }
    }
    
    private void fall()
    {
        setLocation(getX(), getY() + verticalSpeed);
        verticalSpeed += acceleration;
        isJumping = true;
        checkGround();
        if (facingRight)
        {
            setImage(jumpRight);
        }
        else 
        {
            setImage(jumpLeft);
        }
        if (getY() >= getWorld().getHeight() + 125)
        {
            Levels L = (Levels)getWorld();
            L.setUpLevel(L.level);
        }
    }
    
    private boolean checkGround()
    {
        if (getOneObjectAtOffset(-17, marioBottomCentre, Ground.class) == null && getOneObjectAtOffset(17, marioBottomCentre - 1, Ground.class) == null)
        {
            return false;
        }
        while (getOneObjectAtOffset(-17, marioBottomCentre - 1, Ground.class) != null || getOneObjectAtOffset(17, marioBottomCentre - 1, Ground.class) != null)
        {
            setLocation(getX(), getY() - 1);
            verticalSpeed = 0;
            return true;
        }
        verticalSpeed = 0;
        return true;
    }
    
    private void jump()
    {
        verticalSpeed = verticalSpeed - jumpDistance;
        fall();
    }
}
