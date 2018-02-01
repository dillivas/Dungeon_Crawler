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

public class Player extends GameObject {
		
	 /**
	  * Player constructor
	  * @param x coordinate of player
	  * @param y coordinate of player
	  * @param id of player object
	  */
	 public Player(int x, int y, ID id) {
		 super(x, y, id);
	 }
	 
	 /**
	  * Player location
	  */
	 public void tick() {
		  x += speedX;
		  y += speedY;
		  
		  x = Game.clamp(x, 0, Game.WIDTH - 37);
		  y = Game.clamp(y, 0, Game.HEIGHT - 60);
		  
	 }
	 /**
	  * Player Graphic
	  * @param g is player graphic
	  */
	 public void render(Graphics g) {
		  g.setColor(Color.green);
		  g.fillRect(x, y, 32, 32);
	 }
	 
}

