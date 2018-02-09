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
import java.util.Random;

public class Ghost extends GameObject{
	HUD hud;
	Random rand;
	int steps = 0;
	public static int HEALTH = 12;

	/**
	 * BasicEnemy constructor
	 * @param x coordinates
	 * @param y coordinates
	 * @param id enemy type
	 */
	public Ghost(int x, int y, ID id) {
		super(x, y, id);
		speedX = 3;
		speedY = 3;
	}

	/**
	 * This is the basic enemies hit box.
	 */
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}

	/**
	 * Controls ghost movements
	 */
	public void tick() {
		HEALTH = Game.clamp(HEALTH,0,12);
        // makes the bird fly clockwise
        if(steps%140 < 30){
            x += speedX;
        }
        else if(steps%140 < 70){
            y += speedY;
        }
        else if(steps%140 < 100){
            x -= speedX;
        }
        else if(steps%140 < 140){
            y -= speedY;
        }
        steps++;
	}

	/**
	 * Controls BasicEnemy rendering
	 */
	public void render(Graphics g) {
		g.drawImage(Render.ghostImage,x,y,50,50, null);
		//g.fillRect(x, y, 32, 32);
	}
	public void health(Graphics g) {
		  g.setColor(Color.gray);
		  g.fillRect(200 , 15, 120, 32);
		  g.setColor(Color.red);
		  g.fillRect(200 , 15, HEALTH * 10, 32);
		  g.setColor(Color.white);
		  g.drawRect(200 , 15, 120, 32);
	 }
}
