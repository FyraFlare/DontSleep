import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class DontSleepGUI extends JFrame{
	private Game game;
	private Display panel;
	private Timer timer;
	private int mode;
	
	public DontSleepGUI(){
		setTitle("Don't Sleep!");
		setSize(new Dimension(1200, 800));
		setLocation(300, 100);
		game = new Game();
		panel = new Display(game);
		registerListenersAndObservers();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timer = new Timer(100, new TickListener());
		setMode(1);
	}

	public static void main (String[] args){
		new DontSleepGUI();
	}
	
	private void registerListenersAndObservers() {
		game.addObserver(panel);
		addKeyListener(new MoveListener());
	}
	
	private void setMode(int m){
		mode = m;
		if(mode == 0){ //main menu
			timer.stop();
			remove(panel);
			//add main menu
		}
		else if(mode == 1){ //game
			add(panel);
			timer.start();
		}
		else if(mode == 3){ //end
			timer.stop();
			remove(panel);
			//add end screen
		}
	}
	
	private class TickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//System.out.println("tick");// test timing
			game.updateGame();
		}
	}
	
	private class MoveListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent key) {
			if(key.getKeyCode() == KeyEvent.VK_LEFT){
				game.move(true);
			}
			else if(key.getKeyCode() == KeyEvent.VK_RIGHT){
				game.move(false);
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}
	}
}
