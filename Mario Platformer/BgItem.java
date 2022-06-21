    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * BgItem class for displaying and layering all background images to the world
     * Subclass of Background
     * 
     * @author Jerry Zhu
     * @version December 2020
     */
    
    public class BgItem extends Background
    {
        // Instance variables
        private final GreenfootImage sBush = new GreenfootImage("bush-small-bg.gif"); // Greenfoot image of the bush object
        private final GreenfootImage Castle = new GreenfootImage("castle.gif"); // Greenfoot image of the castle object
        private final GreenfootImage lCloud = new GreenfootImage("cloud-large-bg.gif"); // Greenfoot image of the cloud object
        private final GreenfootImage Flag = new GreenfootImage("flag.gif"); // Greenfoot image of the flag object
        private final GreenfootImage Flagpole = new GreenfootImage("flagpole.gif");   // Greenfoot image of the castle object
        
        /**
         * Constructor method for objects of class BgItem
         */
        public BgItem(int selection)
        {
            this.selection = selection; // Set the selection instance variable to the parameter selection
            if (selection == 1) // If the selection variable is equal to 1 
            {
                setImage(Castle); // Set the background object to the castle image
                Castle.scale(500, 500); // Scales the image to 500 x 500 pixels
            }
            else if (selection == 2) // If the selection variable is equal to 2
            {
                setImage(Flag); // Set the background object to the flag image
                Flag.scale(100, 100); // Scales the image to 100 x 100 pixels
            }
            else if (selection == 3) // If the selection variable is equal to 3 
            {
                setImage(sBush); // Set the background object to the bush image
                sBush.scale(250, 110); // Scales the image to 250 x 110 pixels
            }
            else if (selection == 4) // If the selection variable is equal to 4 
            {
                setImage(lCloud); // Set the background object to the cloud image
                lCloud.scale(350, 150); // Scales the image to 350 x 150 pixels
            }
        }
        
        /**
         * Act - do whatever the BgItem wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act() 
        {
            // Do nothing
        }    
}
