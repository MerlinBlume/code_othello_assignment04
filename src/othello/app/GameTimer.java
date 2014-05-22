package othello.app;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
	int delay = 0;
	int period = 60000;
	private static GameTimer countDown = null;
	static Timer timer;
	
	
	private GameTimer(){}	
	
	public static GameTimer getInstance(){

		if (null == countDown)
		{
			countDown = new GameTimer();
		}
		return countDown;
	}
	
	public void setNull(){
		//to-do implement timing 
		//timer.schedule(new TimerTask(){
		//	public void run() {
		//		System.out.println("hi");
		//		}
		//}, delay, period);	
		countDown = null;
	}	
}


