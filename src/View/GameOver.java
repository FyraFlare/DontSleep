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

public class GameOver extends JPanel{
	private Game game;
	private Image aPlus, a, b, c, d, f;
	
	public GameOver(Game g) {
		loadImages();
		game = g;
	}

	private void loadImages() {
		try {
			aPlus = ImageIO.read(new File("./images/end_of_game/a_plus_screen.png"));
			a = ImageIO.read(new File("./images/end_of_game/a_screen.png"));
			b = ImageIO.read(new File("./images/end_of_game/b_screen.png"));
			c = ImageIO.read(new File("./images/end_of_game/c_screen.png"));
			d = ImageIO.read(new File("./images/end_of_game/d_screen.png"));
			f = ImageIO.read(new File("./images/end_of_game/f_screen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int result = game.getlvl();
		if(result > 6){
			g2.drawImage(aPlus, 0, 0, null);
		}
		else if(result > 5){
			g2.drawImage(a, 0, 0, null);
		}
		else if(result > 4){
			g2.drawImage(b, 0, 0, null);
		}
		else if(result > 3){
			g2.drawImage(c, 0, 0, null);
		}
		else if(result > 1){
			g2.drawImage(d, 0, 0, null);
		}
		else{
			g2.drawImage(f, 0, 0, null);
		}
	}
}
