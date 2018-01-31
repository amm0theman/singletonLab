package singletonLab;

public class playByPlay {
	
	private static String playByPlays = "Start Race: ";
	private static playByPlay instance = null;
	   private playByPlay() {
	      // Exists only to defeat instantiation.
	   }
	   public static synchronized playByPlay getInstance() {
	      if(instance == null) {
	         instance = new playByPlay();
	      }
	      return instance;
	   }
	   
	   public  synchronized void sendPlay(String play) {
				   playByPlay.playByPlays += play;
	   }
	   
	   public void printResults() {
		   System.out.println(playByPlays);
	   }
}
