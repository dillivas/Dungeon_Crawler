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
	public char lastKey = 'd';
	public int pressLength = 4;
	
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
		
		if(handler.getUp()) speedY = -3;
		else if(!handler.getDown()) speedY = 0;
		
		if(handler.getDown()) speedY = 3;
		else if(!handler.getUp()) speedY = 0;
		
		if(handler.getRight()) speedX = 3;
		else if(!handler.getLeft()) speedX = 0;
		
		if(handler.getLeft()) speedX = -3;
		else if(!handler.getRight()) speedX = 0;

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
				
					if(handler.getUp() == true) {
						x-=40;
					}
					else if(handler.getDown() == true) {
						x+=40;
					}
					else if(handler.getRight() == true) {
						y+=40;
					}
					else if(handler.getLeft() == true) {
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
		
		
		if(handler.getStop() == true && lastKey=='w') {
			g.drawImage(Render.playerUpStanding,x,y,32,50, null);
		}
		if(handler.getStop() == true && lastKey=='s') {
			g.drawImage(Render.playerDownStanding,x,y,32,50, null);
		}
		if(handler.getStop() && lastKey=='a') {
			g.drawImage(Render.playerLeftStanding,x,y,32,50, null);
		}
		if(handler.getStop() && lastKey=='d') {
			g.drawImage(Render.playerRightStanding,x,y,32,50, null);
		}
		
		
		if(handler.getUp() == true) {
			lastKey='w';
			pressLength++;
			if(pressLength%2==0) {
				g.drawImage(Render.playerForwardWalk1,x,y,32,50, null);
			}
			else {
				g.drawImage(Render.playerForwardWalk2,x,y,32,50, null);
			}
				
		}
		if(handler.getDown() == true) {
			lastKey='s';
			pressLength++;
			if(pressLength%2==0) {
				g.drawImage(Render.playerDownWalk1,x,y,32,50, null);
			}
			else {
				g.drawImage(Render.playerDownWalk2,x,y,32,50, null);
			}
		}
		
		if(handler.getLeft() == true) {
			lastKey='a';
			pressLength++;
			if(pressLength%2==0) {
				g.drawImage(Render.playerLeftWalk1,x,y,32,50, null);
			}
			else {
				g.drawImage(Render.playerLeftWalk2,x,y,32,50, null);
			}
		}
		
		if(handler.getRight() == true) {
			lastKey='d';
			pressLength++;
			if(pressLength%2==0) {
				g.drawImage(Render.playerRightWalk1,x,y,32,50, null);
			}
			else {
				g.drawImage(Render.playerRightWalk2,x,y,32,50, null);
			}
		}	  
	}
}

