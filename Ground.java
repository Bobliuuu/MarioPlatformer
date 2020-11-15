import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Mover
{
    private final GreenfootImage Stile = new GreenfootImage("stepping-tile.gif");
    private final GreenfootImage FPlatform = new GreenfootImage("floating-platform.gif");
    private final GreenfootImage Block = new GreenfootImage("block.gif");
    
    /**
     * Ground constructor
     */
    public Ground(int selection)
    {
        this.selection = selection;
        if(selection == 1)
        {
            setImage(Stile);
            Stile.scale(50,50);
        }
        else if ((selection == 2) || (selection == 3)){  
            setImage(FPlatform);
            FPlatform.scale(200, 35);  
            this.speed = 2;
        }
        else if (selection == 4) { 
            setImage(Block);
            Block.scale(30,30);  
        } 
        else if  (selection == 5)
        {
            setImage(FPlatform);
            FPlatform.scale(200,35);  
            this.speed = 2;
        }
    }
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (selection == 1)
        {
            steppingTileCollisionDetection();
        }
        else if (selection == 2)
        {
            HFPlatformCollisionDetection();
        }
        else if (selection == 3)
        {
            HFPlatformCollisionDetection();
            movementCounter++;
            moveHFPlatform();
        }
        else if (selection == 4)
        {
            
        }
    }
    private void steppingTileCollisionDetection()
    {
        Actor MarioLeft = getOneObjectAtOffset(27, 0, Player.class);
        Actor MarioRight = getOneObjectAtOffset(-27, 0, Player.class);
        Actor MarioHead = getOneObjectAtOffset(0, 50, Player.class);
        if (MarioLeft != null)
        {
            MarioLeft.setLocation(MarioLeft.getX() + 7, MarioLeft.getY());
            return;
        }
        else if (MarioRight != null)
        {
            MarioRight.setLocation(MarioRight.getX() - 7, MarioRight.getY());
            return;
        }
        else if (MarioHead != null)
        {
            MarioHead.setLocation(MarioHead.getX(), MarioHead.getY() + 10);
            return;
        }
    }
    private void HFPlatformCollisionDetection()
    {
        Actor MarioLeft = getOneObjectAtOffset(100, 0, Player.class);
        Actor MarioRight = getOneObjectAtOffset(-102, 0, Player.class);
        Actor MarioHeadLeft = getOneObjectAtOffset(-45, 35, Player.class);
        Actor MarioHeadMid = getOneObjectAtOffset(0, 35, Player.class);
        Actor MarioHeadRight = getOneObjectAtOffset(45, 35, Player.class);
        Actor MarioHeadRight2 = getOneObjectAtOffset(75, 35, Player.class);
        Actor MarioHeadLeft2 = getOneObjectAtOffset(-75, 35, Player.class);
        if (MarioLeft != null)
        {
            MarioLeft.setLocation(MarioLeft.getX() + 7, MarioLeft.getY());
            return;
        }
        else if (MarioRight != null)
        {
            MarioRight.setLocation(MarioRight.getX() - 7, MarioRight.getY());
            return;
        }
        else if (MarioHeadLeft2 != null)
        {
            MarioHeadLeft2.setLocation(MarioHeadLeft2.getX(), MarioHeadLeft2.getY() + 10);
            return;
        }
        else if (MarioHeadLeft != null)
        {
            MarioHeadLeft.setLocation(MarioHeadLeft.getX(), MarioHeadLeft.getY() + 10);
            return;
        }
        else if (MarioHeadMid != null)
        {
            MarioHeadMid.setLocation(MarioHeadMid.getX(), MarioHeadMid.getY() + 10);
            return;
        }
        else if (MarioHeadRight != null)
        {
            MarioHeadRight.setLocation(MarioHeadRight.getX(), MarioHeadRight.getY() + 10);
            return;
        }
        else if (MarioHeadRight2 != null)
        {
            MarioHeadRight2.setLocation(MarioHeadRight2.getX(), MarioHeadRight2.getY() + 10);
            return;
        }
    }
}
