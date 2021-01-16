import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mario class to manage the player's actions in the World
 * Subclass of Mover
 * 
 * @author Jerry Zhu
 * @version December 2020
 */

public class Mario extends Mover
{
    // Instance variables
    // Right facing images
    private final GreenfootImage idleRight = new GreenfootImage("mario-idle.gif"); // Greenfoot image of stationary Mario facing right
    private final GreenfootImage walk1Right = new GreenfootImage("mario-walk1.gif"); // Greenfoot image of the first Mario moving animation facing right
    private final GreenfootImage walk2Right = new GreenfootImage("mario-walk2.gif"); // Greenfoot image of the second Mario moving animation facing right
    private final GreenfootImage walk3Right = new GreenfootImage("mario-walk3.gif"); // Greenfoot image of the third Mario moving animation facing right
    private final GreenfootImage jumperRight = new GreenfootImage("mario-jump.gif"); // Greenfoot image of jumping Mario facing right
    // Left facing images 
    private final GreenfootImage idleLeft = new GreenfootImage(idleRight); // Greenfoot image of stationary Mario facing left
    private final GreenfootImage walk1Left = new GreenfootImage(walk1Right); // Greenfoot image of the first Mario moving animation facing left
    private final GreenfootImage walk2Left = new GreenfootImage(walk2Right); // Greenfoot image of the second Mario moving animation facing left
    private final GreenfootImage walk3Left = new GreenfootImage(walk3Right); // Greenfoot image of the third Mario moving animation facing left
    private final GreenfootImage jumperLeft = new GreenfootImage(jumperRight); // Greenfoot image of jumping Mario facing left
    // Other instance variables
    private boolean facingRight; // Boolean variable to determine if Mario is facing right
    private boolean isKeyPressed; // Detecting if any keys have been pressed
    private int verticalSpeed; // Vertical speed of Mario's jump or fall
    private int acceleration = 1; // Acceleration constant when moving
    private int marioBottomCentre; // Mario's centre position measured from the bottom of the player
    private int jumpDistance = 15; // The distance that Mario can jump
    private boolean isJumping; // Boolean variable to determine if Mario is jumping
    public static boolean isDead; // A static variable to determine if player Mario is dead
    public static boolean isWin;
    
    /**
     * Constructor method for objects of class Mario
     */
    public Mario()
    {
        this.speed = 7; // Set object speed to 7
        this.facingRight = true; // Set the value of facingRight to true, since Mario so the player will be facing right at the start of the level
        this.isJumping = false; // Set the value of isJumping is false, since Mario is not jumping at the start of the level
        this.isDead = false; // Set the value of isDead is false, since Mario is not dead at the start of the level
        this.isWin = false;
        setImage(idleRight); // Set Mario's starting image to the idle stationary object image
        idleRight.scale(38, 50); // Scale right stationary Mario image to 38 x 50 pixels
        walk1Right.scale(48, 50); // Scale first animation of walking right Mario image to 48 x 50 pixels
        walk2Right.scale(36, 50); // Scale second animation of walking right Mario image to 36 x 50 pixels
        walk3Right.scale(44, 50); // Scale third animation of walking right Mario image to 44 x 50 pixels
        idleLeft.scale(38, 50); // Scale left stationary Mario image to 38 x 50 pixels
        walk1Left.scale(48, 50); // Scale first animation of walking left Mario image to 48 x 50 pixels
        walk2Left.scale(36, 50); // Scale first animation of walking left Mario image to 36 x 50 pixels
        walk3Left.scale(44, 50); // Scale second animation of walking left Mario image to 44 x 50 pixels
        jumperRight.scale(48, 50); // Scale jumping right Mario image to 48 x 50 pixels
        jumperLeft.scale(48, 50); // Scale jumping left Mario image to 38 x 50 pixels
        idleLeft.mirrorHorizontally(); // Mirror idleLeft horizontally to idleRight
        walk1Left.mirrorHorizontally(); // Mirror first animation of walking left horizontally
        walk2Left.mirrorHorizontally(); // Mirror second animation of walking left horizontally
        walk3Left.mirrorHorizontally(); // Mirror third animation of walking left horizontally
        jumperLeft.mirrorHorizontally(); // Mirror jumping left Mario horizontally to jumping right
        marioBottomCentre = getImage().getHeight() / 2; // Set Mario's centre from the bottom to the middle of Mario's height
    }

    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isDead == false) // If Mario is not dead yet
        {
            if (checkWin()) // If Mario has won the game
            {
                playWin(); // Play the win animation
                return; // Return out of the act method to prevent any errors and any other checks
            }
            checkKeys(); // Check if any keys have been pressed and perform the neccesary actions
            boundary(); // Check if Mario has reached any boundaries of the World
            if(getWorld() != null && !checkGround()) // If the World exists and Mario is not on the ground object
            {
                fall(); // Fall from the world
            }
            else // Otherwise, Mario is on the ground and is not jumping
            {
                isJumping = false; // Set the value of isJumping to false to indicate that Mario isn't jumping
            }
        }
        else if (isDead == true) // If Mario is dead
        {
            Greenfoot.playSound("smb_pipe.wav"); // Play the death music
            playDead(); // Play the death animation
        }
    }
    
    /**
     * Check if the player has won the game
     */
    private boolean checkWin()
    {
        Actor win = getOneIntersectingObject(FlagPole.class); // Get the intersection of the player with the FlagPole ojbect
        if (win != null) // If the collision exists
        {
            return true; // Return true to indicate that the player has won
        }
        return false; // The player has not won, so return false
    }

    /**
     * Check if the player has reached any level restrictions
     */
    private void boundary()
    {
        Levels L = (Levels)getWorld(); // Get the current level the player is in
        if (getX() <= 21) // If the x position of the player is less than or equal to 21
        {
            setLocation(21, getY()); // Set the x position of the player to 21 
        }
        else if (getX() >= 1100) // If the x position of the player is greater than or equal to 1100
        {
            L.setupLevel(L.level + 1); // Set up the next level since the player has beaten the level
        }
    }

    /**
     * Checks if there are any keys pressed and performs the corresponding actions
     */
    private void checkKeys()
    {
        isKeyPressed = false; // Set initial value of isKeyPressed to be false
        if (Greenfoot.isKeyDown("right") && (Greenfoot.isKeyDown("left")))
        {
            // Do nothing to avoid movement in both directions
        }

        else if (Greenfoot.isKeyDown("right")) // If the right key is pressed
        {
            animationCounter++; // Increment the animation counter
            walkRight(); // Move Mario to the right
            isKeyPressed = true; // Set value of isKeyPressed to true 
            facingRight = true; // Set Mario's direction to facing right
        }
        else if (Greenfoot.isKeyDown("left")) // If the left key is pressed
        {
            animationCounter++; // Increment the animation counter
            walkLeft(); // Move Mario to the left
            isKeyPressed = true; // Set value of isKeyPressed to true 
            facingRight = false; // Set Mario's direction to facing left
        }
        if(Greenfoot.isKeyDown("up") && isJumping == false) // If the up key is pressed and Mario is not jumping 
        {
            isKeyPressed = true; // Set value of isKeyPressed to true 
            jump(); // Perform the jumping action
        }
        if (!isKeyPressed) // If no keys are pressed
        {
            // Do nothing if no keys are pressed
        }
    }
    
    /**
     * Perform the falling action when Mario isn't touching the ground
     */
    private void fall()
    {
        setLocation(getX(), getY() + verticalSpeed); // Set Mario's location below by verticalSpeed (fall down)
        verticalSpeed = verticalSpeed + acceleration; // Increment vertical speed by acceleration
        isJumping = true; // Since Mario is jumping, set the value of isJumping to true
        checkGround(); // Check if Mario is on the ground
        if (facingRight) // If Mario is facing to the right
        {
            setImage(jumperRight); // Set the image to Mario jumping facing right
        }
        else // If Mario is facing to the left
        {
            setImage(jumperLeft); // Set the image to Mario jumping facing left
        }
        if (getY() >= getWorld().getHeight() + 100) // If the player goes below the screen
        {
            isDead = true; // Set isDead to true to indicate the player has died
            playDead(); // Perform the player death action 
        }
    }

    /**
     * Check if Mario has reached the ground to ensure Mario does not sink into the ground when standing on it
     */
    public boolean checkGround()
    {
        if (getOneObjectAtOffset(-17, marioBottomCentre, Ground.class) == null && 
            getOneObjectAtOffset(17, marioBottomCentre, Ground.class) == null) // If Mario is not touching the ground
        {
            return false; // Return false to indicate Mario has not reached the ground
        }
        while (getOneObjectAtOffset (-17, marioBottomCentre - 1, Ground.class) != null || 
        getOneObjectAtOffset(17, marioBottomCentre - 1, Ground.class) != null) // If Mario is touching the ground 
        {
            setLocation(getX(), getY() - 1); // Push Mario away and above the block, and set location above
            verticalSpeed = 0; // Set the vertical speed of Mario's jump to 0
            return true; // Return true to indicate Mario has reached the ground
        }
        //verticalSpeed = 0; // Otherwise, set verical speed of Mario's jump to 0
        return true; // Return true to indicate Mario has reached the ground
    }
    
    /**
     * Perform the jump action when Mario is jumping
     */
    private void jump()
    {
        Greenfoot.playSound("smb_jump-small.wav"); // Play a short Mario jumping sound
        verticalSpeed = verticalSpeed - jumpDistance; // Decrement the vertical jump speed by the distance Mario needs to jump
        fall(); // Perform the fall action
    }

    /**
     * Performs dead mario animation
     */
    private void playDead()
    {
        Levels.gfs.stop();
        GreenfootSound gfs2 = new GreenfootSound("smb_mariodie.wav"); // Plays the Mario death sound  
        gfs2.play();
        Levels.gfs.playLoop();
        Levels L = (Levels)getWorld(); // Gets the current level that Mario is at from the World
        Counter lifeCounter = L.getLifeCounter(); // Gets the life counter from the current level
        lifeCounter.subtract(1); // Subtracts Mario's number of lives by 1
        if (lifeCounter.getValue() == 0) // IF Mario has no lives left
        {
            Greenfoot.delay(170);
            Levels.gfs.stop();
            GreenfootSound gfs3 = new GreenfootSound("gameover.wav"); // Plays the Mario win sound    
            gfs3.play();
            L.setupLevel(-1); // Set up the lose screen level
            Greenfoot.delay(200);
        }
        else // Otherwise, if Mario still has lives left
        {
            Greenfoot.delay(50); // Wait 50 miliseconds
            getWorld().addObject(new MarioDead(), getX(), getY()); // Add a Mario dead object to the screen
            getWorld().removeObject(this); // Remove the current player Mario object
            isDead = true; // Set isDead to true so Mario won't collect any coins in the death animation
        }
    }
    
    /**
     * Performs Mario win animation
     */
    private void playWin()
    {
        Levels.gfs.stop();
        GreenfootSound gfs2 = new GreenfootSound("smb_stage_clear.wav"); // Plays the Mario win sound    
        gfs2.play();
        Greenfoot.delay(50); // Delay 50 milliseconds
        isWin = true;
        getWorld().addObject(new MarioWin(), getX(), getY()); // Add a Mario win object to the screen
        getWorld().removeObject(this); // Remove the current player Mario object
    }
    
    /**
     * Moves Mario to the right and animates it
     */
    private void walkRight()
    {
        moveRight(); // Moves Mario object to the right
        if (animationCounter < 4) // If the animation counter is less than 4
        {
            setImage(idleRight); // Set the image to the stationary Mario facing right
        }
        else if (animationCounter < 8) // If the animation counter is less than 8
        {
            setImage(walk1Right); // Set the image to the first moving Mario animation facing right
        }
        else if (animationCounter < 12) // If the animation counter is less than 12
        {
            setImage(walk2Right); // Set the image to the second moving Mario animation facing right
        }
        else if (animationCounter < 16) // If the animation counter is less than 16
        {
            setImage(walk3Right); // Ste the image to the third moving mario animation facing right
        }
        else if (animationCounter >= 16) // Otherwise, if the animation counter is greater than or equal to 16
        {
            animationCounter = 0; // Set the animation counter to 0
            setImage(idleRight); // Set the image to the stationary Mario facing right
        }
    }

    /**
     * Moves Mario to the left and animates it
     */
    private void walkLeft()
    {
        moveLeft(); // Moves Mario object to the left
        if (animationCounter < 4) // If the animation counter is less than 4
        {
            setImage(idleLeft); // Set the image to the stationary Mario facing left
        }
        else if (animationCounter < 8) // If the animation counter is less than 8
        {
            setImage(walk1Left); // Set the image to the first moving Mario animation facing left
        }
        else if (animationCounter < 12) // If the animation counter is less than 12
        {
            setImage(walk2Left); // Set the image to the second moving Mario animation facing left
        }
        else if (animationCounter < 16) // If the animation counter is less than 16
        {
            setImage(walk3Left); // Set the image to the third moving Mario animation facing left
        }
        else if (animationCounter >= 16) // Otherwise, if the animation counter is greater than or equal to 16
        {
            animationCounter = 0; // Set the animation counter to 0
            setImage(idleLeft); // Set the image to the stationary Mario facing left
        }
    }
}
