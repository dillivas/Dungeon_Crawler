/********************************************
 * Written By: William Mckeever    			*
 * Date: 1/28/2018       					*
 * Class: BasicEnemy      					*
 *            								*
 * The class control's a BasicEnemy object 	*
 ********************************************/

package DungeonCrawler1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{

	/**
	 * BasicEnemy constructor
	 * @param x coordinates
	 * @param y coordinates
	 * @param id enemy type
	 */
	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		speedX = 2;
		speedY = 2;
	}

	/**
	 * This is the basic enemies hit box.
	 */
	public Rectangle getBounds() {
		return new Rectangle(x,y,100,100);
	}

	/**
	 * Controls BasicEnemy movements
	 */
	public void tick() {
		x += speedX;
		y += speedY;

		if(x <= 0 || x >= Game.WIDTH - 37) speedX *= -1;
		if(y <= 0 || y >= Game.HEIGHT - 60) speedY *= -1;
	}

	/**
	 * Controls BasicEnemy rendering
	 */
	public void render(Graphics g) {
		g.drawImage(Render.enemyImage,x,y,100,100, null);
		//g.fillRect(x, y, 32, 32);
	}
}
