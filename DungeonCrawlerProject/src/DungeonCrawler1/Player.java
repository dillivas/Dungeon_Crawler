/********************************************
 * Written By: William Mckeever    			*
 * Date: 1/28/2018       					*
 * Class: Player       						*
 *            								*
 * The class control's the player object 	*
 ********************************************/

package DungeonCrawler1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends GameObject {
	private Game game;
	Handler handler;
	
	//Object immunity handler
	/* boolean immunity;
	 int immunityTime;*/

	/**
	 * Player constructor
	 * @param x coordinate of player
	 * @param y coordinate of player
	 * @param id of player object
	 */
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		/*immunity = false;
		 immunityTime = 0;*/
	}
	
	/**
	 * This is the Players hit box.
	 */
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}

	/**
	 * Player location
	 */
	public void tick() {
		x += speedX;
		y += speedY;

		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60); 
		collision();
	}
	
	/**
	 * This method handles the collisions between game objects
	 */
	private void collision() {
		/*if(immunityTime > 0)
			 immunityTime--;
		 else if((immunityTime == 0) && (immunity == true))
				 immunity = false;*/

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getID() == ID.BasicEnemy) {

				if(getBounds().intersects(tempObject.getBounds()) && (tempObject.getID() == ID.BasicEnemy)/* && (immunity == false)*/) {
					//collision with basic enemy and knockback / direction of knockback
					HUD.HEALTH -= 1;
				
					if(KeyInput.up == true) {
						x-=40;
					}
					else if(KeyInput.down == true) {
						x+=40;
					}
					else if(KeyInput.right == true) {
						y+=40;
					}
					else if(KeyInput.left == true) {
						y-=40;
					}
					else {
						x+=40;
					}
				}
			}
		}
	}

	/**
	 * Player Graphic
	 * @param g is player graphic
	 */
	public void render(Graphics g) {
		if(KeyInput.stop == true) {
			g.drawImage(Render.playerStop,x,y,32,32, null);
		}
		if(KeyInput.up == true) {
			g.drawImage(Render.playerUp,x,y,32,32, null);
		}
		if(KeyInput.down == true) {
			g.drawImage(Render.playerDown,x,y,32,32, null);
		}
		if(KeyInput.left == true) {
			g.drawImage(Render.playerLeft,x,y,32,32, null);
		}
		if(KeyInput.right == true) {
			g.drawImage(Render.playerRight,x,y,32,32, null);
		}	  
	}
}

