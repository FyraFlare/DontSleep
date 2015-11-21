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
	
	public DontSleepGUI(){
		setTitle("Don't Sleep!");
		setSize(new Dimension(1200, 800));
		setLocation(300, 100);
		setupLayout();
		registerListenersAndObservers();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timer = new Timer(100, new TickListener());
		timer.start();
	}

	public static void main (String[] args){
		new DontSleepGUI();
	}

	private void setupLayout() {
		game = new Game();
		panel = new Display(game);
		add(panel);
	}
	
	private void registerListenersAndObservers() {
		game.addObserver(panel);
		addKeyListener(new MoveListener());
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
