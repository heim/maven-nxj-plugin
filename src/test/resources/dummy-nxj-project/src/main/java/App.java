

import no.shit.nxt.TextConstructarGh;
import lejos.nxt.Button;
import lejos.nxt.LCD;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        LCD.drawString( TextConstructarGh.cockFuck(), 0, 1);
        Thread.sleep(2000);
        Button.waitForPress();
    }
}
