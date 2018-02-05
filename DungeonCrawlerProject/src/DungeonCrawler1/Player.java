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
import java.awt.Rectangle;

public class Player extends GameObject {
	
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
				 
				 if(getBounds().intersects(tempObject.getBounds())/* && (immunity == false)*/) {
					 //collision with basic enemy and knockback / immunity
					 HUD.HEALTH -= 1;

					 //immunityTime = 3000;
					 //immunity = true;
					 x += 20;
					 y += 20;
				 }
			 }
			 
			 //Check for wall
			 if(tempObject.getID() == ID.Structer) {
				 if(getBounds().intersects(tempObject.getBounds())) {
					 x = Game.clampReverse(x, tempObject.getX() - 32, tempObject.getX());
					 y = Game.clampReverse(y, tempObject.getY() - 32, tempObject.getY()); 
				 }
			 }
		 }
	 }
	 
	 /**
	  * Player Graphic
	  * @param g is player graphic
	  */
	 public void render(Graphics g) {
		 
		 //Graphics2D g2d = (Graphics2D)g;
		 
		  g.setColor(Color.green);
		  g.fillRect(x, y, 32, 32);
	 }
	 
	 /*public boolean getImmunity() {
		 return immunity;
	 }
	 public int getImmunityTime() {
		 return immunityTime;
	 }
	 
	 public void setImmunity(boolean immunity) {
		 this.immunity = immunity;
	 }
	 
	 public void setImmunityTime(int immunityTime) {
		 this.immunityTime = immunityTime;
	 }*/
}

