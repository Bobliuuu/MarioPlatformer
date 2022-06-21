import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Counter class to track and count statistics such as remaining lives, number of coins and amount of points
 * Subclass of Background
 * 
 * @author Jerry Zhu
 * @version December 2020 
 */

public class Counter extends Background  
{  
    // Instance Variables
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0); // Final transparent background color for counter object
    public int value; // Value of the counter object
    private Color textColor = Color.WHITE; // Color of counter text
    protected int target; // Target value of counter object
    private String prefix; // Prefix text for counter object
    
    /**
     * Constructor for objects of class Counter
     */
    public Counter()  
    {  
        value = 0; // Set starting value to 0
        target = 0; // Set target value to 0
        this.prefix = prefix; // Set prefix string to prefix variable
        updateImage(); // Update the image with the instance variables initialized
        GreenfootImage image = getImage(); // Get the image corresponding to the object and set it to the image variable with type GreenfootImage
        Font font = image.getFont(); // Get the font corresponding to the image and set it to the font variable with type Font
    }  
    
    /**
     * Overloaded constructor for object of class Counter
     */
    public Counter(String text)  
    {  
        prefix = text; // Sets prefix text to the variable text
        updateImage(); // Updates the image with the 
    } 
    
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (value < target) { // If the current value is less than the target value
            value++; // Increment the current value
            updateImage(); // Update the image with the new adjusted value
        }
        else if (value > target) { // if the current value is greater than the target value
            value--; // Decrement the current value
            updateImage(); // Update the image with the new adjusted value
        }
    }

    /**
     * Updates the image using the instance variables
     */
    private void updateImage()  
    {  
        int fontSize = 24; // Sets the font size to 24 
        // Documentation: newGreenfootImage(text, fontSize, textColor, backgroundColor)
        setImage(new GreenfootImage(prefix + " " + value, fontSize, textColor, TRANSPARENT)); // Display counter image to the screen
    }  

    /**
     * Updates the text color of the image
     */
    public void setTextColor(Color color) 
    {  
        textColor = color; // Sets the textColor to the parameter color
        updateImage(); // Updates the image with the adjusted text color
    }  
    
    /**
     * Updates the prefix text of the image
     */
    public void setPrefix(String text)  
    {  
        prefix = text; // Sets the prefix text to the parameter text
        updateImage(); // Updates the image with the adjusted prefix 
    }

    /**
     * Increases the target value of the counter object
     */
    public void add(int score)  
    {  
        target += score; // Increments target by the parameter score
        updateImage(); // Updates the image with the adjusted target value
    } 
    
    /**
     * Decreases the target value of the counter object
     */
    public void subtract(int score)  
    {  
        target -= score; // Decrements target by the parameter score
        updateImage(); // Updates the image with the adjusted target value
    } 

    /**
     * Setter method for the values of the counter object
     * Immediately updates the image text value
     */
    public void setValue(int newValue)  
    {  
        target = newValue; // Sets the target value to the parameter newValue
        value = newValue; // Sets the value to the parameter newvalue
        updateImage(); // Updates the image with the adjusted values
    }
    
    /**
     * Getter method for the target value of the counter object
     */
    public int getValue()  
    {  
        return target; // Returns the value of the target instance variable
    }  
} 