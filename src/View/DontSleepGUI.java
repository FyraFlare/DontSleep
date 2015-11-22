package View;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Model.Game;

public class DontSleepGUI extends JFrame{
	private Game game;
	private Display play;
	private JPanel menu, end, holder, shop;
	private JButton start;
	private Timer timer;
	private int mode;
	private CardLayout cards;
	int freeze;
	int next;
	
	public DontSleepGUI(){
		setTitle("Don't Sleep!");
		setSize(new Dimension(1200, 810));
		setLocation(300, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupLayout();
		registerListenersAndObservers();
	}

	public static void main (String[] args){
		new DontSleepGUI();
	}
	
	private void setupLayout() {
		cards = new CardLayout();
		holder = new JPanel(cards);
		
		menu = new Menu();/*
		start = new JButton("Play");
		start.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		menu.setLayout(null);
		menu.add(start);
		start.setBounds(525, 350, 100, 50);
		menu.setBackground(Color.CYAN);*/
		
		game = new Game();
		play = new Display(game);
		
		shop = new Shop(game);
		
		end = new GameOver(game);
		
		holder.add(menu, "Menu");
		holder.add(play, "Play");
		holder.add(shop, "Shop");
		holder.add(end, "End");
		add(holder);
		
		timer = new Timer(100, new TickListener());
		freeze = 0;
		setMode(0);
	}
	
	private void registerListenersAndObservers() {
		game.addObserver(play);
		addKeyListener(new MoveListener());
		shop.addMouseListener(new buyListener());
	}
	
	private void setMode(int m){
		mode = m;
		if(mode == 0){ //main menu
			timer.stop();
			cards.show(holder, "Menu");
		}
		else if(mode == 1){ //game
			timer.start();
			cards.show(holder, "Play");
		}
		else if(mode == 2){ //shop
			timer.stop();
			cards.show(holder, "Shop");
		}
		else if(mode == 3){ //end
			timer.stop();
			cards.show(holder, "End");
		}
		this.requestFocusInWindow();
		this.validate();
	}
	
	private class TickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(freeze < 1){
				int result = game.updateGame();
				if(result > 0){
					play.setMes(result);
					freeze = 30;
					if(result > 1){
						next = 3;
					}
					next = 2;
				}
				else if(result < 0){
					play.setMes(result);
					freeze = 30;
					next = 3;
				}
			}
			else{
				freeze--;
				if(freeze < 1){
					setMode(next);
				}
			}
		}
	}
	
	private class MoveListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent key) {
			if(key.getKeyCode() == KeyEvent.VK_LEFT){
				game.move(1);
			}
			else if(key.getKeyCode() == KeyEvent.VK_RIGHT){
				game.move(2);
			}
		}

		@Override
		public void keyReleased(KeyEvent key) {
			if(key.getKeyCode() == KeyEvent.VK_LEFT || key.getKeyCode() == KeyEvent.VK_RIGHT){
				game.move(0);
			}
			else if(key.getKeyCode() == KeyEvent.VK_P){
				if(mode == 0 || mode == 2){
					setMode(1);
				}
				else{
					setMode(0);
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}
	}
	
	private class buyListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent mouse) {
			if(mouse.getX() > 370 && mouse.getX() < 705){
				game.buy((mouse.getY()-250)/100);
				repaint();
			}
			else if(mouse.getX() > 820 && mouse.getX() < 1055 && mouse.getY() > 610 && mouse.getY() < 1052){
				setMode(1);
			}
		}
		
	}
}
