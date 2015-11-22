package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Model.Game;

public class Instructions extends JPanel{
	private Image inst;
	public Instructions() {
		try {
			inst = ImageIO.read(new File("./images/instructions.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(inst, 0, 0, null);
	}
}
