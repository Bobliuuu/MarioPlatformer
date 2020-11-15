import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{
    public int level;
    public int marioStartX;
    public int marioStartY;
    
    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Levels()
    {   
        // Create a new world with 1000x590 cells with a cell size of 1x1 pixels.
        super(1000, 590, 1, false); 
        Greenfoot.setSpeed(50);
        Greenfoot.start();
        setUpLevel(1);
        setPaintOrder(HUD.class, Counter.class, Transition.class, Player.class, PlayerDead.class, Coin.class, Goomba.class, Ground.class, BgItem.class);
    }
    public void setUpLevel(int lvl)
    {
        removeObjects(getObjects(null));
        level = lvl;
        if (level == 1)
        {
            marioStartX = 75;
            marioStartY = 470;
            worldColorLevel();
            addObject(new Player(), marioStartX, marioStartY);
            
            for (int x = 15; x <= 300; x += 47)
            {
                for (int y = 520; y <= 570; y += 47)
                {
                    addObject(new Ground(1), x, y);
                }
            }
            for (int x = 700; x <= 1200; x += 47)
            {
                for (int y = 520; y <= 570; y += 47)
                {
                    addObject(new Ground(1), x, y);
                }
            }
            addObject(new Ground(3), 300, 400);
            addObject(new Ground(3), 700, 400);
        }
        else if (level == 2)
        {
            marioStartX = 75;
            marioStartY = 400;
            worldColorLevel();
            addObject(new Player(), marioStartX, marioStartY);
        }
        else if (level == 3)
        {
            marioStartX = 75;
            marioStartY = 400;
            worldColorLevel();
            addObject(new Player(), marioStartX, marioStartY);
        }
        else if (level == 4)
        {
            marioStartX = 75;
            marioStartY = 400;
            worldColorLevel();
            addObject(new Player(), marioStartX, marioStartY);
        }
        else if (level == -1)
        {
            GreenfootImage background = getBackground();
            background.setColor(new Color(0, 0, 0));
            background.fill();
        }
    }
    public void worldColorLevel()
    {
        GreenfootImage background = getBackground();
        background.setColor(new Color(92, 148, 252));
        background.fill();
    }
}
