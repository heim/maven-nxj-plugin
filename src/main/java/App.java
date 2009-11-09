import lejos.nxt.Button;
import lejos.nxt.LCD;


public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		LCD.drawString("Hella good", 0, 1);
		Thread.sleep(2000);
		Button.waitForPress();
	}

}
