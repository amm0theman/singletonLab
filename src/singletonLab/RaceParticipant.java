package singletonLab;

public class RaceParticipant implements Runnable {
	 
	public static String daWinner = null;
	
	public static playByPlay instance = playByPlay.getInstance();
	
	public void race() {
		//How fast this racer will move
		double speed;
		System.out.println(Thread.currentThread().getName());
		//Which thread is this
		if(Thread.currentThread().getName().matches("Tortoise")) {
			speed = 0.4;
		}
		else if(Thread.currentThread().getName().matches("Hare")) {
			speed = 0.5;
		}
		else if(Thread.currentThread().getName().matches("Jaguar")) {
			speed = 1.5;
		}
		else
			speed = 2;
		
			for(double distance=1;distance<=55;distance += speed){
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e){
				System.out.println(Thread.currentThread().toString() + " was interrupted");
				Thread.currentThread().interrupt();
			}
			if(RaceParticipant.daWinner != null) {
				System.out.println("I've LOST: "+Thread.currentThread().getName()+ " is: "+ distance +" meters");
				String a = "I've LOST: "+Thread.currentThread().getName()+ " is: "+ distance +" meters\n";
				playByPlay.getInstance().sendPlay(a);
				
			}else {
				System.out.println("RACING "+Thread.currentThread().getName()+ " is: "+ distance +" meters");
				String b = "RACING "+Thread.currentThread().getName()+ " is: "+ distance +" meters\n";
				playByPlay.getInstance().sendPlay(b);
			}
			boolean isRaceWon = this.isRaceWon(distance);
			if(isRaceWon){
				break;
			}
		}
	}
 
	private boolean isRaceWon(double totalDistanceCovered){
		boolean isRaceWon =  false;
		if((RaceParticipant.daWinner==null )&&(totalDistanceCovered>=50)){
				RaceParticipant.daWinner = Thread.currentThread().getName();
				System.out.println("Winner is :"+RaceParticipant.daWinner);
				isRaceWon = true;
			}
			/*need to stop loop if other party has won*/
		    if (totalDistanceCovered>=50){
				isRaceWon = true;
			}
		return isRaceWon;
		}
 
	@Override
	public void run() {
		this.race();
 
	}
 
}