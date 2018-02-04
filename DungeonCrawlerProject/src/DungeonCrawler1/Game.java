/****************************************************************************
 * Written By: William Mckeever           									*
 * Date: 1/28/2018               											*
 * Class: Game                												*
 * Source Assistance: https://www.youtube.com/watch?v=1gir2R7G9ws&t=661s 	*
 *                    														*
 * The class controls the game            									*
 ****************************************************************************/

package DungeonCrawler1;

import javax.imageio.ImageIO;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game extends Canvas implements Runnable{
		
	 private static final long serialVersionUID = 665215786302647934L;
	 
	 //Variable
	 public static final int WIDTH = 650, HEIGHT = WIDTH / 12 * 9;
	 private Thread thread;
	 private boolean running = false;
	 private Handler handler;
	 private HUD hud;
	 
	 /**
	  * Game Constructor
	  * IMPORTAINT: this will need to be edited so that we can add objetcs in based on map layout later
	  */
	 public Game() {
		  handler = new Handler();
		  this.addKeyListener(new KeyInput(handler));
		  
		  new Window(WIDTH, HEIGHT, "Dungeon Crawler", this);
		  
		  hud = new HUD();
		  
		  handler.addObject(new Player(WIDTH/2-300,HEIGHT/2-3,ID.Player, handler));
		  handler.addObject(new BasicEnemy(WIDTH/2-64,HEIGHT/2-64,ID.BasicEnemy));
		  handler.addObject(new BasicEnemy(WIDTH/2,HEIGHT/2,ID.BasicEnemy));
	  
	 }
	 
	 //Might need to edit this later (add threads)
	 /**
	  * Start Game
	  */
	 public synchronized void start() {
		 thread = new Thread(this);
		 thread.start();
		 running = true;
	 }
	 
	 /**
	  * Stop Game
	  */
	 public synchronized void stop() {
		  try {
			  thread.join();
			  running = false;
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	 }
	 
	 /**
	  * Game Loop.
	  * Also controls the frames.
	  */
	 public void run(){
		 	//Causes inputs to be prioritized by window
		 	this.requestFocus();

		 	BufferedImage img = null;

		 	InputStream is = this.getClass().getResourceAsStream("/Images/Basic_Dungeon.JPG");
		 try {
			 img = ImageIO.read(is);
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 long lastTime = System.nanoTime();
		 	double amountOfTicks = 60.0;
		 	double ns = 1000000000 / amountOfTicks;
		 	double delta = 0;
		 	long timer = System.currentTimeMillis();
		 	int frames = 0;
		 	while(running)
		 	{
		 		long now = System.nanoTime();
		     	delta += (now - lastTime) / ns;
		     	lastTime = now;
		     	while(delta >=1){
		     		tick();
		         	delta--;
		     	}
		     	if(running)
		     		render(img);
		         	frames++;
		                         	
		     	if(System.currentTimeMillis() - timer > 1000){
		     		timer += 1000;
		         	System.out.println("FPS: "+ frames);
		         	frames = 0;
		     	}
		 	}
		 	stop();
	 }
	 
	 private void tick() {
		  handler.tick();
		  hud.tick();
	 }
	 
	 /**
	  * Controls what renders on the screen
	  */
	 private void render(BufferedImage img) {
		  BufferStrategy bs = this.getBufferStrategy();
		  if(bs == null) {
			   this.createBufferStrategy(3);
			   return;
		  }
		  
		  Graphics g = bs.getDrawGraphics();
		  
		  g.setColor(Color.black);
		  g.drawImage(img,0,0,WIDTH,HEIGHT, this);
		  //g.fillRect(0, 0, WIDTH, HEIGHT);
		  
		  handler.render(g);
		  
		  hud.render(g);
		  
		  g.dispose();
		  bs.show();
	 }
	 
	 /**
	  * Method to make sure player stays within room
	  * @param var player movement
	  * @param min room size
	  * @param max room size
	  * @return player position
	  */
	 public static int clamp(int var, int min, int max) {
		  if(var >= max)
			  return var = max;
		  else if(var <= min)
			  return var = min;
		  else 
			  return var;
	 }
	 
	 
	 /**
	  * Main method to create new game
	  */
	 public static void main(String args[]) {
		 new Game();
	 }
}