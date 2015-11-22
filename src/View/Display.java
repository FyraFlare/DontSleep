package View;

import java.awt.Color;
import java.awt.Font;
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
import Model.Game;
import Model.Player;

public class Display extends JPanel implements Observer {
	private Game game;
	private Image background, hyperBar, player, gift, coffee, mug, press, tea, sugar, soda, chocolate, cream, pillow, blanket, lullaby, cap, paper, text;
	int mes;

	public Display(Game g) {
		loadImages();
		game = g;
		mes = 0;
	}

	private void loadImages() {
		try {
			background = ImageIO.read(new File("./images/background.png"));
			hyperBar = ImageIO.read(new File("./images/hyper_bar.png"));
			player = ImageIO.read(new File("./images/player.png"));
			gift = ImageIO.read(new File("./images/gift_card.png"));
			coffee = ImageIO.read(new File("./images/coffee_cup.png"));
			mug = ImageIO.read(new File("./images/coffee_mug.png"));
			press = ImageIO.read(new File("./images/coffee_press.png"));
			tea = ImageIO.read(new File("./images/tea_mug.png"));
			sugar = ImageIO.read(new File("./images/sugar_can.png"));
			soda = ImageIO.read(new File("./images/cola_bottle.png"));
			chocolate = ImageIO.read(new File("./images/hersheys_kiss.png"));
			cream = ImageIO.read(new File("./images/ice_cream_cone.png"));
			pillow = ImageIO.read(new File("./images/pillow_case.png"));
			blanket = ImageIO.read(new File("./images/blanket.png"));
			lullaby = ImageIO.read(new File("./images/musical_note.png"));
			cap = ImageIO.read(new File("./images/night_cap.png"));
			paper = ImageIO.read(new File("./images/paperwork.png"));
			text = ImageIO.read(new File("./images/textbook.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(background, 0, 0, null);
		Color c = new Color(156, 0, 0);
		g2.setColor(c);
		g2.fillRect(3, 751 - game.getCaf(), 50, game.getCaf());
		g2.drawImage(hyperBar, 0, 0, null);
		g2.drawImage(player, game.getPlayerX(), Player.PLAYER_Y, null);
		ArrayList<Item> items = game.getItems();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Gift) {
				g2.drawImage(gift, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Coffee) {
				g2.drawImage(coffee, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Mug) {
				g2.drawImage(mug, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Press) {
				g2.drawImage(press, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Tea) {
				g2.drawImage(tea, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Sugar) {
				g2.drawImage(sugar, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Soda) {
				g2.drawImage(soda, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Chocolate) {
				g2.drawImage(chocolate, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Cream) {
				g2.drawImage(cream, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Pillow) {
				g2.drawImage(pillow, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Blanket) {
				g2.drawImage(blanket, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Lullaby) {
				g2.drawImage(lullaby, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Cap) {
				g2.drawImage(cap, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Paper) {
				g2.drawImage(paper, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			} else if (items.get(i) instanceof Text) {
				g2.drawImage(text, items.get(i).getPosition().x, items.get(i).getPosition().y, null);
			}
		}
		String gifts = "Gift Cards: " + game.getGifts();
		g2.setColor(Color.WHITE);
		g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g2.drawString(gifts, 1000, 50);
		if (mes != 0) {
			String temp;
			if (mes < 0) {
				temp = "Zzz...";
			}
			else{
				temp = "Good Job!";
			}
			g2.setColor(Color.WHITE);
			g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
			g2.drawString(temp, 500, 350);
			mes = 0;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	public void setMes(int i) {
		mes = i;
		repaint();
	}
}
