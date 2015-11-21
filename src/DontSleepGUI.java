import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DontSleepGUI extends JFrame{
	private Game game;
	private Display play;
	private JPanel menu, win, lose, holder;
	private JButton start;
	private Timer timer;
	private int mode;
	private CardLayout cards;
	
	public DontSleepGUI(){
		setTitle("Don't Sleep!");
		setSize(new Dimension(1200, 810));
		setLocation(300, 100);
		setupLayout();
		registerListenersAndObservers();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main (String[] args){
		new DontSleepGUI();
	}
	
	private void setupLayout() {
		cards = new CardLayout();
		holder = new JPanel(cards);
		menu = new JPanel();
		start = new JButton("Play");
		start.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		menu.setLayout(null);
		menu.add(start);
		start.setBounds(550, 350, 100, 50);
		start.setLocation(new Point(500, 350));
		menu.setBackground(Color.CYAN);
		game = new Game();
		play = new Display(game);
		
		holder.add(menu, "Menu");
		holder.add(play, "Play");
		add(holder);
		
		timer = new Timer(100, new TickListener());
		setMode(0);
		//add(cur);
	}
	
	private void registerListenersAndObservers() {
		game.addObserver(play);
		addKeyListener(new MoveListener());
		start.addActionListener(new StartListener());
	}
	
	private void setMode(int m){
		mode = m;
		if(mode == 0){ //main menu
			timer.stop();
			//cur = menu;
			//add(menu);
			cards.show(holder, "Menu");
		}
		else if(mode == 1){ //game
			cards.show(holder, "Play");
			//cur = play;
			//this.removeAll();
			//add(play);
			timer.start();
		}
		else if(mode == 3){ //win
			timer.stop();
			//cur = win;
		}
		else if(mode == 4){ //lose
			timer.stop();
			//cur = lose;
			//add lose screen
		}
		this.requestFocusInWindow();
		this.validate();
	}
	
	private class TickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//System.out.println("tick");// test timing
			game.updateGame();
		}
	}
	
	private class StartListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setMode(1);
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
			else if(key.getKeyCode() == KeyEvent.VK_M){
				setMode(0);
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
