package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Items.Coffee;
import Items.Gift;
import Items.Item;
import Items.Pillow;
import Model.Game;
import Model.Player;

public class Shop extends JPanel{
	private Game game;
	private Image store, boost1, boost2, boost3, boost4, boost5;

	public Shop(Game g) {
		loadImages();
		game = g;
	}

	private void loadImages() {
		try {
			store = ImageIO.read(new File("./images/store/store.png"));
			boost1 = ImageIO.read(new File("./images/store/caffeine_boost.png"));
			boost2 = ImageIO.read(new File("./images/store/speed_up_upgrade.png.png"));
			boost3 = ImageIO.read(new File("./images/store/less_sleepy_upgrade.png.png"));
			boost4 = ImageIO.read(new File("./images/store/more_caffeine.png"));
			boost5 = ImageIO.read(new File("./images/store/even_more_caffeine.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(store, 0, 0, null);
		//
	}
}
