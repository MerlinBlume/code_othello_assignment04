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

	 public void setGameTime()
	 {
		gameTime = System.currentTimeMillis();
	 }
	 
	 public long getTime() {
		 return GameTimer.getInstance().gameTime;
	 }			 		 
}
