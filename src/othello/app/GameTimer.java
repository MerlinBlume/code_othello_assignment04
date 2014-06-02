package othello.app;

public class GameTimer {
	
	 private static GameTimer sInstance = null; 
	 private long gameTime;
	 
	 
	 // The use of a private constructor to prevent init.
	 private GameTimer() {} 
	 
	 public static GameTimer getInstance() { 
	 if (sInstance == null) 
		 sInstance = new GameTimer(); 
	 return sInstance; 
	 }

	 /**
	  * @
	  * setGameTime, when called, will stamp the time at
	  * The current time of the system clock.
	  * This is stored so that it can be checked 
	  * by any rules implementation at a later moment.
	  * @param - none
	  * 
	  */
	 
	 public void setGameTime()
	 {
		gameTime = System.currentTimeMillis();
	 }
	 
	 public long getTime() {
		 return GameTimer.getInstance().gameTime;
	 }			 		 
}





