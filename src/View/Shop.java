package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Model.Game;

public class Shop extends JPanel{
	private Game game;
	private Image store, boost1, boost2, boost3, boost4, boost5, cont;
	//private JButton b;

	public Shop(Game g) {
		loadImages();
		game = g;
	}

	private void loadImages() {
		try {
			store = ImageIO.read(new File("./images/store/store.png"));
			boost1 = ImageIO.read(new File("./images/store/caffeine_boost.png"));
			boost2 = ImageIO.read(new File("./images/store/speed_up_upgrade.png"));
			boost3 = ImageIO.read(new File("./images/store/less_sleepy_upgrade.png"));
			boost4 = ImageIO.read(new File("./images/store/more_caffeine_upgrade.png"));
			boost5 = ImageIO.read(new File("./images/store/even_more_caffeine.png"));
			cont = ImageIO.read(new File("./images/store/continue.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(store, 0, 0, null);
		g2.drawImage(boost1, 370, 250, null);
		g2.drawImage(boost2, 370, 350, null);
		g2.drawImage(boost3, 370, 450, null);
		g2.drawImage(boost4, 370, 550, null);
		g2.drawImage(boost5, 370, 650, null);
		g2.drawImage(cont, 820, 610, null);
	}
}
