package View;

import java.awt.Color;
import java.awt.Font;
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
		String cost;
		g2.setColor(Color.BLACK);
		g2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		g2.drawImage(boost1, 370, 250, null);
		if(game.maxed(0)){
			cost = "MAXED";
		}
		else{
			cost = game.uCost(0) + " Gift Cards";
		}
		g2.drawString(cost, 565, 270);
		g2.drawImage(boost2, 370, 350, null);
		if(game.maxed(1)){
			cost = "MAXED";
		}
		else{
			cost = game.uCost(1) + " Gift Cards";
		}
		g2.drawString(cost, 565, 370);
		g2.drawImage(boost3, 370, 450, null);
		if(game.maxed(2)){
			cost = "MAXED";
		}
		else{
			cost = game.uCost(2) + " Gift Cards";
		}
		g2.drawString(cost, 565, 470);
		g2.drawImage(boost4, 370, 550, null);
		if(game.maxed(3)){
			cost = "MAXED";
		}
		else{
			cost = game.uCost(3) + " Gift Cards";
		}
		g2.drawString(cost, 565, 570);
		g2.drawImage(boost5, 370, 650, null);
		if(game.maxed(4)){
			cost = "MAXED";
		}
		else{
			cost = game.uCost(4) + " Gift Cards";
		}
		g2.drawString(cost, 565, 670);
		g2.drawImage(cont, 820, 610, null);
		String gifts = "Gift Cards: " + game.getGifts();
		g2.setColor(Color.WHITE);
		g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
		g2.drawString(gifts, 10, 130);
	}
}
