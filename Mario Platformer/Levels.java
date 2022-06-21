import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Levels class to set up levels
 * Subclass of World
 * 
 * @author Jerry Zhu
 * @version December 2020
 */

public class Levels extends World
{
    // Instance variables
    private Counter scoreCounter; // Score counter for number of points Mario has
    private Counter lifeCounter; // Life counter for Mario's remaining number of lives
    private Counter coinCounter; // Coin counter for number of coins Mario collected
    public int level; // The level in which Mario is currently at
    public int marioStartX; // The x position that Mario starts at
    public int marioStartY; // The y position that Mario starts at
    private boolean gameStart; // If the game has started yet
    public static GreenfootSound gfs; // Static GreenfootSound variable to keep track of music throughout the game

    /**
     * Constructor method for objects of class Levels
     */
    public Levels()
    {    
        super(1100, 590, 1, false); // Create a new world with 1100x590 cells with a cell size of 1x1 pixels
        Greenfoot.setSpeed(50); // Set greenfoot execution speed
        gameStart = false; // Set game start to false 
        scoreCounter = new Counter("Score:"); // New score counter object
        lifeCounter = new Counter("x"); // New life counter object
        coinCounter = new Counter("x"); // New coin counter object
        setupLevel(0); // Set up title screen world
        setPaintOrder(HUD.class, Counter.class, Mario.class, 
            MarioDead.class, Coin.class, Goomba.class, Ground.class, BgItem.class); // Set up default object paint order for each level
    }

    /**
     * Act - do whatever the Levels wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("1") && gameStart == false && level == 0){ // if user chooses easy mode and presses the 1 key
            playMainMusic(); // Play the main menu music before starting the first level
            Greenfoot.delay(150); // Wait for scenario and music to load
            gameStart = true; // Set game start to true 
            lifeCounter.setValue(9); // Set number of lives to 99
            setupLevel(1); // Start the game and set up first level
        }
        if (Greenfoot.isKeyDown("2") && gameStart == false && level == 0){ // If user chooses normal mode and presses the 2 key
            playMainMusic(); // Play the main menu music before starting the first level
            Greenfoot.delay(150); // Wait for scenario and music to load
            gameStart = true; // Set game start to true 
            lifeCounter.setValue(3); // Set number of lives to 3
            setupLevel(1); // Start the game and set up first level
        }
        if (Greenfoot.isKeyDown("3") && gameStart == false && level == 0){ // If user chooses hardcore mode and presses the 3 key
            playMainMusic(); // Play the main menu music before starting the first level
            Greenfoot.delay(150); // Wait for scenario and music to load
            gameStart = true; // Set game start to true 
            lifeCounter.setValue(1); // Set number of lives to 1
            setupLevel(1); // Start the game and set up first level
        }
        if (Greenfoot.isKeyDown("4") && gameStart == false && level == 0){ // If user chooses to view the instructions and presses the 4 key
            setupLevel(-3); // Set up the instructions screen6
        }
        if (Greenfoot.isKeyDown("b") && gameStart == false && level == -3){ // If user chooses to go back to title screen from instructions screen
            setupLevel(0); // Set up the title screen 
        }
        if (Greenfoot.isKeyDown("t") && gameStart == true && ((level == -1) || (level == -2))){ // If user chooses to restart the game after a win or loss
            setupLevel(0); // Set up the title screen 
            gameStart = false; // Set game start to false so variables and game can reset
            scoreCounter.setValue(0); // Reset score counter object
            lifeCounter.setValue(0); // Reset life counter object
            coinCounter.setValue(0); // Reset coin counter object
            started(); // Start the title screen music
        }
        if (Greenfoot.isKeyDown("e") && gameStart == true && ((level == -1) || (level == -2))){ // If user chooses to exit the game after a win or loss
            setupLevel(-4);
            Greenfoot.stop(); // Stop the game
        }
    }   
    
    /**
     * Play the title theme music when game starts and when prompted
     */
    public void started()
    {
        gfs = new GreenfootSound("titletheme.wav"); // Set the music to the title screen theme
        gfs.playLoop(); // Repeat the music and play it in a loop
    }
    
    /**
     * Play the main level music when prompted
     */
    private void playMainMusic()
    {
        gfs.stop(); // Stop the current Greenfoot music from playing
        gfs = new GreenfootSound("mariothemesong.wav"); // Set the music to the level Mario theme song
        gfs.playLoop(); // Repeat the music and play it in a loop
    }
    
    /**
     * Set up each level
     */
    public void setupLevel(int lvl)
    {
        removeObjects(getObjects(null)); // Remove all objects from the scren
        level = lvl; // Set level parameter to global level
        if (level == -1) // Set up lose screen
        {
            worldColorScreen(); // Set world background color to the screen color
            addObject(new LoseScreen(), 550, 295); // Add the lose screen to the world
        }
        else if (level == -2) // Set up win screen
        {
            worldColorScreen(); // Set world background color to the screen color
            addObject(new WinScreen(), 550, 295); // Add the win screen to the world
        }
        else if (level == -3) // Set up instructions screen
        {
            worldColorScreen(); // Set world background color to the screen color
            addObject(new Instructions(), 550, 300); // Add the instructions screen to the world
        }
        else if (level == 0) // Set up title screen
        {
            worldColorScreen(); // Set world background color to the screen color
            addObject(new TitleScreen(), 550, 295); // Add the title screen to the world
        }
        else if (level == -4) // Set up game end screen
        {
            worldColorScreen(); // Set world background color to the screen color
            addObject(new GameEnd(), 550, 295); // Add the title screen to the world
        }
        else if (level == 1) // Set up first level
        {
            marioStartX = 15; // Set Mario's starting X value
            marioStartY = 472; // Set Mario's starting Y value
            worldColorLevel(); // Set world background color to sky blue
            HUD(); // Set up counters and HUD images
            // Documentation: addObject(new Class(type), posX, posY)
            addObject(new Mario(), marioStartX, marioStartY); // Add player Mario to the screen
            //addObject(new BgItem(2), 440, 130); // Add flag object to the screen
            //addObject(new FlagPole(), 500, 311); // Add flag pole object to the screen
            addObject(new Goomba(), 1076, 471); // Add goomba enemy to the screen 
            addObject(new Ground(3), 650, 443); // Add left right moving platform object to the screen
            addObject(new BgItem(3), 178, 441); // Add bush object to the screen
            addObject(new BgItem(4), 349, 178); // Add cloud object to the screen
            addObject(new BgItem(4), 780, 178); // Add cloud object to the screen
            addObject(new Coin(), 577, 353); // Add coin object to the screen
            addObject(new Coin(), 494, 351); // Add coin object to the screen
            addObject(new Coin(), 455, 292); // Add coin object to the screen
            addObject(new Coin(), 535, 301); // Add coin object to the screen
            addObject(new Coin(), 606, 294); // Add coin object to the screen
            addObject(new Coin(), 539, 396); // Add coin object to the screen
            for (int x = 15; x < 351; x += 47) // Loop every x value for ground object
            {
                for (int y = 520; y <= 570; y += 47) // loop every y value for ground object
                {
                    addObject(new Ground(1), x, y); // add ground tile object to the screen
                }
            }
            for (int x = 800; x < 1100; x += 47) // Loop every x value for ground object
            {
                for (int y = 520; y <= 570; y += 47) // loop every y value for ground object
                {
                    addObject(new Ground(1), x, y); // add ground tile object to the screen
                }
            }
        }
        else if (level == 2) // Set up second level
        {
            marioStartX = 15; // Set Mario's starting X value
            marioStartY = 472; // Set Mario's starting Y value
            worldColorLevel(); // Set world background color to sky blue
            HUD(); // Set up counters and HUD images
            // Documentation: addObject(new Class(type), posX, posY)
            addObject(new Mario(), marioStartX, marioStartY); // Add player Mario to the screen
            addObject(new Goomba(), 341, 472); // Add goomba enemy to the screen 
            addObject(new Goomba(), 1081, 471); // Add goomba enemy to the screen 
            addObject(new Ground(5), 540, 443); // Add up down moving platform object to the screen
            addObject(new BgItem(3), 178, 441); // Add bush object to the screen
            addObject(new BgItem(4), 349, 178); // Add cloud object to the screen
            addObject(new BgItem(4), 780, 178); // Add cloud object to the screen
            addObject(new Coin(), 547, 395); // Add coin object to the screen
            addObject(new Coin(), 547, 300); // Add coin object to the screen  
            addObject(new Coin(), 547, 199); // Add coin object to the screen
            addObject(new Coin(), 547, 123); // Add coin object to the screen  
            for (int x = 15; x < 351; x += 47) // Loop every x value for ground object
            {
                for (int y = 520; y <= 570; y += 47) // Loop every y value for ground object
                {
                    addObject(new Ground(1), x, y); // add ground tile object to the screen
                }
            }
            for (int x = 800; x < 1100; x += 47) // Loop every x value for ground object
            {
                for (int y = 520; y <= 570; y += 47) // Loop every y value for ground object
                {
                    addObject(new Ground(1), x, y); // add ground tile object to the screen
                }
            }
        }
        else if (level == 3) // Set up third level
        {
            marioStartX = 15; // Set Mario's starting X value
            marioStartY = 472; // Set Mario's starting Y value
            worldColorLevel(); // Set world background color to sky blue
            HUD(); // Set up counters and HUD images
            // Documentation: addObject(new Class(type), posX, posY)
            addObject(new Mario(), marioStartX, marioStartY); // Add player Mario to the screen
            addObject(new Ground(3), 650, 443); // Add left right moving platform object to the screen
            addObject(new Goomba(), 1081, 471); // Add goomba enemy to the screen 
            addObject(new BgItem(4), 349, 178); // Add cloud object to the screen
            addObject(new BgItem(4), 780, 178); // Add cloud object to the screen
            addObject(new Coin(), 222, 459); // Add coin object to the screen
            addObject(new Coin(), 565, 374); // Add coin object to the screen
            addObject(new Coin(), 778, 384); // Add coin object to the screen
            for (int x = 15; x < 200; x += 47) // Loop every x value for ground object
            {
                for (int y = 520; y <= 570; y += 47) // Loop every y value for ground object
                {
                    addObject(new Ground(1), x, y); // add ground tile object to the screen
                }
            }   
            addObject(new Ground(1), 335, 521); // add ground tile object to the screen
            addObject(new Ground(1), 335, 566); // add ground tile object to the screen
            for (int x = 800; x < 1100; x += 47) // Loop every x value for ground object
            {
                for (int y = 520; y <= 570; y += 47) // Loop every y value for ground object
                {
                    addObject(new Ground(1), x, y); // add ground tile object to the screen
                }
            }
        }
        else if (level == 4)
        {
            marioStartX = 15; // Set Mario's starting X value
            marioStartY = 472; // Set Mario's starting Y value
            worldColorLevel(); // Set world background color to sky blue
            HUD(); // Set up counters and HUD images
            // Documentation: addObject(new Class(type), posX, posY)
            addObject(new Mario(), marioStartX, marioStartY); // Add player Mario to the screen
            addObject(new BgItem(1), 850, 252); // Add castle object to the screen
            addObject(new BgItem(2), 440, 130); // Add flag object to the screen
            addObject(new FlagPole(), 500, 311); // Add flag pole object to the screen
            addObject(new Coin(), 210, 470); // Add coin object to the screen
            addObject(new Coin(), 312, 470); // Add coin object to the screen
            addObject(new Coin(), 428, 470); // Add coin object to the screen
            for (int x = 15; x < 1100; x += 47) // Loop every x value for ground object
            {
                for (int y = 520; y <= 570; y += 47) // Loop every y value for ground object
                {
                    addObject( new Ground(1), x, y); // add ground tile object to the screen
                }
            }
        }
    }

    /**
     * Set up level backgroud color
     */
    public void worldColorLevel()
    {
        GreenfootImage background = getBackground(); // Get background object
        background.setColor(new Color(92, 148, 252)); // Set the color of the background to sky blue
        background.fill(); // Fill the world with the selected background color
    }

    /**
     * Set up screen background color
     */
    public void worldColorScreen()
    {
        GreenfootImage background = getBackground(); // Get background object
        background.setColor(new Color(255,255,255)); // Set the color of the background to white
        background.fill(); // Fill the world with the selected background color
    }

    /**
     * Getter method for scoreCounter
     */
    public Counter getScoreCounter()
    {
        return scoreCounter; // Get the value of scoreCounter
    }

    /**
     * Getter method for lifeCounter
     */
    public Counter getLifeCounter()
    {
        return lifeCounter; // Get the value of lifeCounter
    }

    /**
     * Getter method for coinCounter
     */
    public Counter getCoinCounter()
    {
        return coinCounter; // Get the value of coinCounter
    }

    /**
     * Set up level HUD images and counters
     */
    public void HUD()
    {
        addObject(coinCounter, 1041, 21); // Add coinCounter object to the screen
        addObject(scoreCounter, 1019, 51); // Add scoreCounter object to the screen
        addObject(lifeCounter, 67, 21); // Add lifeCounter object to the screen
        addObject(new HUD(1), 34, 21); // Add a HUD image object for the life counter
        addObject(new HUD(2), 1010, 21); // Add a HUD image object for the coin counter
    }
}
