package DungeonCrawler1;

import java.awt.Graphics;
import java.awt.Rectangle;

public class PauseScreen extends GameObject {
	public char lastKey = 'd';
	public static boolean newGame = false;
	/**
	 * BasicEnemy constructor
	 * @param x coordinates
	 * @param y coordinates
	 * @param id enemy type
	 */
	public PauseScreen(int x, int y, ID id) {
		super(x, y, id);
		speedX = 2;
		speedY = 2;
	}

	/**
	 * This is the basic enemies hit box.
	 */
	public Rectangle getBounds() {
		//System.out.println(x);
		return new Rectangle(0,0,0,0);
	}

	/**
	 * Controls BasicEnemy movements
	 */
	public void tick() {
		/*x += speedX;
		y += speedY;

		if(x <= 0 || x >= Game.WIDTH - 37) speedX *= -1;
		if(y <= 0 || y >= Game.HEIGHT - 60) speedY *= -1;*/
	}

	/**
	 * Controls BasicEnemy rendering
	 */
	public void render(Graphics g) {
		if (KeyInput.pause == true) {
			g.drawImage(Render.pauseQuit,0,0,650,458, null);
			if(KeyInput.stop == true && lastKey=='w') {
				g.drawImage(Render.pauseQuit,0,0,650,458, null);
					if(KeyInput.space == true) {
						System.exit(1);
					}
			}
			if(KeyInput.stop == true && lastKey=='s') {
				g.drawImage(Render.pauseRestart,0,0,650,458, null);
				if(KeyInput.space == true) {
					new Game();
				}
			}
			
			if(KeyInput.up == true) {
				g.drawImage(Render.pauseQuit,0,0,650,458, null);
				lastKey = 'w'; 
				//g.fillRect(x, y, 32, 32);
			}

			if (KeyInput.down == true){
				g.drawImage(Render.pauseRestart,0,0,650,458, null);
				lastKey = 's';
				//g.fillRect(x, y, 32, 32);
			}
			//g.fillRect(x, y, 32, 32);
		}
		
		if(HUD.HEALTH == 0) {
			g.drawImage(Render.gameRestart,0,0,650,458, null);

			if(KeyInput.stop == true && lastKey=='w') {
				g.drawImage(Render.gameQuit,0,0,650,458, null);
					if(KeyInput.space == true) {
						System.exit(1);
					}
			}
			if(KeyInput.stop == true && lastKey=='s') {
				g.drawImage(Render.gameRestart,0,0,650,458, null);
				if(KeyInput.space == true) {
					newGame = true;
				}
			}
			
			if(KeyInput.up == true) {
				g.drawImage(Render.gameQuit,0,0,650,458, null);
				lastKey = 'w'; 
				//g.fillRect(x, y, 32, 32);
			}

			if (KeyInput.down == true){
				g.drawImage(Render.gameRestart,0,0,650,458, null);
				lastKey = 's';
				//g.fillRect(x, y, 32, 32);
			}
				{
			}
		}
	}
}
