import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.Timer;

public class DontSleepGUI extends JFrame{
	public DontSleepGUI(){
		setTitle("Don't Sleep!");
		setSize(new Dimension(1200, 800));
		setLocation(300, 100);
		//setupLayout();
		//registerListenersAndObservers();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//timer = new Timer(1000, new TickListener());
		//timer.start();
	}
	
	public static void main (String[] args){
		new DontSleepGUI();
	}
}
