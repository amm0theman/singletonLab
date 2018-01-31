package singletonLab;

public class RaceDriver {
	public static void main(String[] args) {
		
		RaceParticipant racer = new RaceParticipant();
		Thread tortoiseThread = new Thread(racer, "Tortoise");
		Thread hareThread = new Thread(racer, "Hare");
		Thread jaguarThread = new Thread(racer, "Jaguar");
		Thread robinThread = new Thread(racer, "Robin");

		tortoiseThread.start();
		try {
			Thread.sleep(500);
		}
		catch(InterruptedException e){
			System.out.println(Thread.currentThread().toString() + " was interrupted");
			Thread.currentThread().interrupt();
		}
		hareThread.start();
		try {
			Thread.sleep(750);
		}
		catch(InterruptedException e){
			System.out.println(Thread.currentThread().toString() + " was interrupted");
			Thread.currentThread().interrupt();
		}
		jaguarThread.start();
		try {
			Thread.sleep(250);
		}
		catch(InterruptedException e){
			System.out.println(Thread.currentThread().toString() + " was interrupted");
			Thread.currentThread().interrupt();
		}
		robinThread.start();
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			System.out.println(Thread.currentThread().toString() + " was interrupted");
			Thread.currentThread().interrupt();
		}
		playByPlay.getInstance().printResults();
	}
}