package DungeonCrawler1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Render {
	
	public static BufferedImage playerStop;
	public static BufferedImage playerUp;
	public static BufferedImage playerDown;
	public static BufferedImage playerLeft;
	public static BufferedImage playerRight;
	public static BufferedImage enemyImage;
	public static BufferedImage ghostImage;

	
	public static void load()
	{
		try {
			System.out.println("image loaded");
			//playerImage = ImageIO.read(Render.class.getResource("Images/KoolaidMan.JPG"));
			playerStop = ImageIO.read(new File("src/Images/turtle.jpg"));
			enemyImage = ImageIO.read(new File("src/Images/KoolaidMan.JPG"));
			playerUp = ImageIO.read(new File("src/Images/capnMerica.jpg"));
			playerDown = ImageIO.read(new File("src/Images/superman.jpg"));
			playerLeft = ImageIO.read(new File("src/Images/wizard.jpg"));
			//playerRight = ImageIO.read(new File("src/Images/walkingMan.gif"));
			ghostImage = ImageIO.read(new File("src/Images/ghost.gif"));


		} catch (IOException e) {
			System.out.print("Failed to load image");
			e.printStackTrace();
		}
	}
	
	public BufferedImage loadImage(String str) {
		BufferedImage img = null;

		InputStream is = Render.class.getResourceAsStream(str);
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
