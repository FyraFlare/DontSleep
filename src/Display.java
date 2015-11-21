import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Items.Item;

public class Display extends JPanel implements Observer{
	private Game game;
	private Image player, item;
	
	public Display(Game g){
		loadImages();
		game = g;
	}
	
	private void loadImages() {
		try {
			player = ImageIO.read(new File("./images/purple.png"));
			item = ImageIO.read(new File("./images/orange.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//TODO draw background
		g2.drawImage(player, game.getPlayer(), Game.PlAYER_Y, null);
		ArrayList<Item> items = game.getItems();
		for(int i = 0; i < items.size(); i++){
			//TODO draw right image
			g2.drawImage(item, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
