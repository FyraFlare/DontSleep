import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Items.*;

public class Display extends JPanel implements Observer {
	private Game game;
	private Image player, coffee, pillow;

	public Display(Game g) {
		loadImages();
		game = g;
	}

	private void loadImages() {
		try {
			player = ImageIO.read(new File("./images/purple.png"));
			coffee = ImageIO.read(new File("./images/orange.png"));
			pillow = ImageIO.read(new File("./images/gray.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(player, game.getPlayerX(), Player.PLAYER_Y, null);
		ArrayList<Item> items = game.getItems();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Coffee) {
				g2.drawImage(coffee, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			}
			else if (items.get(i) instanceof Pillow) {
				g2.drawImage(pillow, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
