/** 
 * lab 2 package 
 */ 
package KI35.Kliuchar.lab2; 
 
import java.io.*;
import java.time.LocalDateTime; 
 
/** 
 * Class <code>TV</code> implements TV
 */ 
public class TV {
    private Screen screen;
    private Sound sound;
    private RemoteControl remoteControl;
    private boolean isOn;
    private int currentChannel;
    private FileWriter logWriter;
    private BufferedWriter logBuffer;
    /** 
     * Constructor 
     * @throws IOException 
     */ 
    public TV() throws IOException 
    { 
        this.screen = new Screen();
        this.sound = new Sound();
        this.remoteControl = new RemoteControl();
        this.isOn = false;
        this.currentChannel = 1;
        String fileName = "tv_log_" + LocalDateTime.now().toString().replace(":", "_") + ".txt";
        logWriter = new FileWriter(fileName);
        logBuffer = new BufferedWriter(logWriter);
    }
    /** 
     * Constructor 
     * @param <code>resource</code> screen sound remoteControl 
     * @throws IOException 
     */ 
    	public TV(Screen screen, Sound sound, RemoteControl remoteControl) throws IOException {
        this.screen = screen;
        this.sound = sound;
        this.remoteControl = remoteControl;
        this.isOn = false;
        this.currentChannel = 1;
        String fileName = "tv_log_" + LocalDateTime.now().toString().replace(":", "_") + ".txt";
        logWriter = new FileWriter(fileName);
        logBuffer = new BufferedWriter(logWriter);

    }
    private void log(String message) throws IOException {
        logBuffer.write(LocalDateTime.now() + ": " + message + "\n");
        logBuffer.flush();
    }
    class Screen {
    	
        private int sizeX;
        private int sizeY;
        private String type;   
        /**
        * Constructor
         * @return 
        */
        public Screen()
        {
        sizeX=3;
        sizeY=5;
        }
        /**
        * Constructor
        * @param <code>sizeX</code> The X coordinate value
        * @param <code>sizeY</code> The Y coordinate value
        */

        public Screen(int X,int Y)
        {
        sizeX= X;
        sizeY= Y;
        }
        public void setSizeX(int size) {
            this.sizeX = size;
        }
        public void setSizeY(int size) {
            this.sizeX = size;
        }
        public void setScreenType(String a)
        {
        type=a;
        }
        public int getSizeX() {
            return sizeX;
        }
        public int getSizeY() {
            return sizeY;
        }
        public String getScreenType() {
            return type;
        }
    }

    class Sound {
        private int volume;
        private String type;
        private int svolume;

        /**
         * Constructor
          * @return 
         */
         public Sound()
         {
             type= "type";
             volume= 100;
             svolume=0;
         }
         /**
         * Constructor
         * @param <code>type1</code> The type
         * @param <code>Y</code> The volume
         */

         public Sound(String type1,int Y)
         {
         type= type1;
         volume= Y;
         svolume=0;
         }
        public void setVolume(int size) {
            this.volume = size;
        }
        public void setSoundType(String a)
        {
        type=a;
        }
        public void setSVolume(int size) {
            this.svolume = size;
        }
        public int getVolume() {
            return volume;
        }
        public String getSoundType() {
            return type;
        }
        public int getSVolume() {
            return svolume;
        }
    }

    class RemoteControl {
        private int distance;
        private int percObstacles;
        
        /**
         * Constructor
          * @return 
         */
         public RemoteControl()
         {
             distance = 100;
             percObstacles = 0;
         }
         /**
         * Constructor
         * @param <code>i1</code> Off or on
         * @param <code>d</code> The distance from the signal output to the input
         * @param <code>p</code> Obstacle percentage
         */

         public RemoteControl( int d, int p)
         {
             distance = d;
             percObstacles = p;
         }
        public void setDistance(int a)
        {
        	distance=a;
        }
        public void setpercObstacles(int a)
        {
        	percObstacles=a;
        }
        public int getDistance() {
        	 return distance;  
        }
        public int getpercObstacles() {
       	 return percObstacles;  
       }
    }      
        /**
        * Method implements turning the TV on or off
        * @param <code>xPos</code> The X coordinate of the mouse position
        * @param <code>yPos</code> The Y coordinate of the mouse position
        */
    public void powerOnOff() {
        try {
	            log("Power button pressed");
	    	if(isOn==true) {
	    		isOn=false;
	    		System.out.println("TV off");
	    	}
	    	else {
	    		isOn=true;
	        System.out.println("TV on");
	    	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    	}
    /**
     * Changes the current channel to the specified one.
     *
     * @param newChannel The new channel number to switch to.
     */
    public void changeChannel(int newChannel) {
    	 try {
        if (isOn && newChannel > 0 && newChannel <= 1000) { 
            currentChannel = newChannel;
            System.out.println("Switched to channel " + newChannel);
            log("Switched to channel " + newChannel);
        } else {  
            if (!isOn) {
                System.out.println("TV is off. Cannot change channel.");
                log("TV is off. Cannot change channel.");
            } else if (newChannel <= 0) {
                System.out.println("Invalid channel number. Must be positive.");
                log("Invalid channel number. Must be positive.");
            } else {
                System.out.println("Channel number out of range. Max channel is 1000.");
                log("Channel number out of range. Max channel is 1000.");
            }
        }
    } 
    catch (IOException e) {
        e.printStackTrace();
    }

}
    /**
     * Decreases the volume by the specified amount.
     *
     * @param decrement The amount to decrease the volume by.
     */
    public void decreaseVolume(int decrement) {
    	try {
        if (isOn) {
            int currentVolume = sound.getVolume();
            if (currentVolume != 0) {
                currentVolume = Math.max(currentVolume - decrement, 0);
                sound.setVolume(currentVolume);
                System.out.println("Volume decreased to " + currentVolume + "%");
                log("Volume decreased to " + currentVolume + "%");

            } else {
                System.out.println("Volume is already muted.");
                log("Volume is already muted.");
            }
        } else {
            System.out.println("TV is off. Cannot adjust volume.");
            log("TV is off. Cannot adjust volume.");
        }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Sets the volume to the specified level.
     *
     * @param newVolume The new volume level (0-100).
     */
    public void setVolume(int newVolume) {
    	try {
        if (isOn) {
            if (newVolume >= 0 && newVolume <= 100) {
                sound.setVolume(newVolume);
                System.out.println("Volume set to " + newVolume + "%");
                log("Volume set to " + newVolume + "%");

            } else {
                System.out.println("Invalid volume level. Must be between 0 and 100%.");
                log("Invalid volume level. Must be between 0 and 100%.");

            }
        } else {
            System.out.println("TV is off. Cannot adjust volume.");
            log("TV is off. Cannot adjust volume.");

        }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mutes the TV.
     */
    public void mute() {
    	try {
        if (isOn) {
        	sound.setSVolume(sound.getVolume());
            sound.setVolume(0);
            System.out.println("TV muted.");
            log("TV muted.");

        } else {
            System.out.println("TV is off. Cannot mute.");
            log("TV is off. Cannot mute.");
        }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Unmutes the TV.
     */
    public void unmute() {
    	try {
        if (isOn) {
            int previousVolume = sound.getSVolume(); 
            sound.setVolume(previousVolume);
            System.out.println("TV unmuted. Volume set to " + previousVolume + "%");
            log("TV unmuted. Volume set to " + previousVolume + "%");

        } else {
            System.out.println("TV is off. Cannot unmute.");
            log("TV is off. Cannot unmute.");
        }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Increases the volume by the specified amount.
     *
     * @param increment The amount to increase the volume by.
     */
    public void increaseVolume(int increment) {
    	try {
        if (isOn) {
            int currentVolume = sound.getVolume();
            if (currentVolume != 100) { 
                currentVolume = Math.min(currentVolume + increment, 100);
                sound.setVolume(currentVolume);
                System.out.println("Volume increased to " + currentVolume + "%");
                log("Volume increased to " + currentVolume + "%");

            } else {
                System.out.println("Volume is already at maximum.");
                log("Volume is already at maximum.");

            }
        } else {
            System.out.println("TV is off. Cannot adjust volume.");
            log("TV is off. Cannot adjust volume.");
        }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks the signal strength.
     */
    public void checkSignalStrength() {
    	try {
        int signalStrength = 100 - (remoteControl.getDistance() / 2) - remoteControl.getpercObstacles();
        if( signalStrength >= 50) {
            System.out.println("Signal +");
            log("Signal +");

        }
        else {
        	System.out.println("Signal -");
        	log("Signal -");

        }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        }
    /**
     * Simulates signal loss.
     */
    public void simulateSignalLoss() {
    	try {
        remoteControl.setpercObstacles(100); 
        System.out.println("Signal lost");
        log("Signal lost");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Moves the remote control.
     *
     * @param delta The distance to move the remote control.
     */
    public void move(int delta) {
    	try {
    	remoteControl.setDistance(Math.max(remoteControl.getDistance()+delta,0));
    	System.out.println("Distance now "+remoteControl.getDistance());
    	log("Distance now "+remoteControl.getDistance());

        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
   
