package othello.app;

public class GameTimer {
	
	/**
	 *  GameTimer is a Singleton implementation that allows Games to check the
	 *  timeliness of of a move, between the Rules, and Game concrete classes.
	 *   
	 */
	
	 private static GameTimer sInstance = null; 
	 private long gameTime;
	 
	 // The use of a private constructor to prevent init.
	 private GameTimer() {} 
	 
	 /**
	  *  Get an instance of the GameTimer.
	  */
	 public static GameTimer getInstance() { 
	 if (sInstance == null) 
		 sInstance = new GameTimer(); 
	 return sInstance; 
	 }

	 /**
	  * Starts the GameTimer.
	  */
	 public void setGameTime()
	 {
		gameTime = System.currentTimeMillis();
	 }
	
	 /**
	  *  Returns the "GameTime". (AKA SystemTime in milliseconds (Wall Clock).
	  */
	 public long getTime() {
		 return GameTimer.getInstance().gameTime;
	 }			 		 
}
