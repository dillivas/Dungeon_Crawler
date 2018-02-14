/************************************************
 * Written By: William Mckeever    				*
 * Date: 1/28/2018       						*
 * Class: Wall      							*
 *            									*
 * The class controls a wall or block object	*
 * to act as a obstacle to the player.			*
 ************************************************/

package DungeonCrawler1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Fireball extends GameObject {
	
	 public Fireball(int x, int y, ID id) {
		 super(x, y, id);
		 if(KeyInput.leftAim == true)
			 speedX = -3;
		 else if(KeyInput.rightAim == true)
			 speedX = 3;
		 else if(KeyInput.upAim == true)
			 speedY = -3;
		 else if(KeyInput.downAim == true)
			 speedY = 3;
	 }
	 public Rectangle getBounds() {
		 return new Rectangle(x,y,16,16);
	 }
	 
	 public void tick() {
			x += speedX;
			y += speedY;

			x = Game.clamp(x, 0, Game.WIDTH);
			y = Game.clamp(y, 0, Game.HEIGHT);
			
			if((x == 0) || (x == Game.WIDTH) || (y == 0) || (y == Game.HEIGHT)){
				this.remove = true;
			}
	 }
	 
	 public void render(Graphics g) {
		 
		 //Graphics2D g2d = (Graphics2D)g;
		 
		  g.setColor(Color.orange);
		  g.fillRect(x, y, 16, 16);
	 }
}
