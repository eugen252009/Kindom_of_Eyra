//"C:\Users\Niklas\AppData\Local\Android\Sdk\platform-tools\adb.exe" connect 192.168.178.51
//"C:\Users\Eugen\AppData\Local\Android\Sdk\platform-tools\adb.exe" connect 192.168.178.25
package de.luprichtdevelopment.kindomofeyra.Game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

import de.luprichtdevelopment.kindomofeyra.R;
import de.luprichtdevelopment.kindomofeyra.map.Map;
import de.luprichtdevelopment.kindomofeyra.tools.AppTools;

public class Handler {
	
	private Map map;
	private Player player, enemy;
	private Wave wave;
	private int xOffset, yOffset;
	private int width, height;
	private int tilewidth;
	private int tileheight;
	private int xtiles, ytiles;
	private Bitmap[] misctexture = new Bitmap[30];
	private Bitmap[] mapTexture = new Bitmap[30];
	private Bitmap[] playerTexture = new Bitmap[30];
	private Bitmap error;
	
	
	private int round = 0;
	private int touchX, touchY;
	
	//TILES
	private int tiles = 20;
	//fixedSIze
	private int tilesize = 100;
	private boolean fixedSize = false;
	
	
	public Handler(int width, int height) {
		this.width = width;
		this.height = height;
		init();
	}
	
	void init() {
		
		if (fixedSize) {
			tiles = width / tilesize;
		}
		xtiles = tiles;
		ytiles = tiles;
		
		tilewidth = ((width) / xtiles);
		tileheight = ((height) / ytiles);
		
		
		if (tilewidth > tileheight) {
			tilewidth = tileheight;
			xOffset = (width - tilewidth * xtiles) / 2;
			yOffset = ((height - tileheight * ytiles) / 2);
			Log.d("TileSize", "OFFSET: " + xOffset + " * " + yOffset + " & TileSize " + tilewidth + " * " + ytiles);
		} else {
			tileheight = tilewidth;
			xOffset = (width - tilewidth * xtiles) / 2;
			yOffset = (height - tileheight * ytiles) / 2;
			Log.d("TileSize", "OFFSET: " + xOffset + " * " + yOffset + " & TileSize " + tileheight + " * " + ytiles);
		}
		
		initBitmaps();
		
		
		//PLAYER
		player = new Player(this, 20, 20, 100, false);
		player.setBase(tilewidth, tileheight);
		player.setX(tiles - 3);
		player.setY(tiles / 2);
		
		
		//ENEMY
		enemy = new Player(this, 5, 30, 100, true);
		enemy.setBase(tilewidth, tileheight);
		enemy.setX(1);
		enemy.setY(tiles / 2);
		
		//Map
		map = new Map(this);
		
		
	}
	
	
	public void draw(Canvas canvas) {
		player.drawHUD(canvas, 0);
		enemy.drawHUD(canvas, 500);
		map.draw(canvas);
		player.draw(canvas);
		enemy.draw(canvas);
	}
	
	public void render() {
		player.render();
		enemy.render();
		if (touchY > 500) nextRound();
	}
	
	void nextRound() {
		this.round++;
	}
	
	//GETTER & SETTER
	
	public int getxOffset() {
		return xOffset;
	}
	
	public int getyOffset() {
		return yOffset;
	}
	
	public int getTilewidth() {
		return tilewidth;
	}
	
	public int getTileheight() {
		return tileheight;
	}
	
	public int getXtiles() {
		return xtiles;
	}
	
	public int getYtiles() {
		return ytiles;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Map getMap() {
		return map;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Player getEnemy() {
		return enemy;
	}
	
	void initBitmaps() {
		
		error = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.sprite), tilewidth, tileheight, false);
		
		playerTexture = new Bitmap[]{
				//0 PLAYER BASE
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.playerbase), 2 * tilewidth, 2 * tileheight, false),
				//1 ENEMY base
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.enemybase), 2 * tilewidth, 2 * tileheight, false),
				//2 Enemyone
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.enemyone), tilewidth, tileheight, false),
		};
		mapTexture = new Bitmap[]{
				//0 GRASS
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.grass), tilewidth, tileheight, false),
				//1 Pathhorizontal
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathhorizontal), tilewidth, tileheight, false),
				//2 Pathvertical
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathvertical), tilewidth, tileheight, false),
				//3 Path-Bot-Left
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathbotleft), tilewidth, tileheight, false),
				//4 Path-Bot-Right
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathbotright), tilewidth, tileheight, false),
				//5 Path-Top-Left
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathtopleft), tilewidth, tileheight, false),
				//6 Path-Top-Right
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathtopright), tilewidth, tileheight, false),
				//7 BORDER TOP
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.bordertop), tilewidth, tileheight, false),
				//8 BORDER BOT
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.borderbot), tilewidth, tileheight, false),
				//9 BORDER LEFT
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.borderleft), tilewidth, tileheight, false),
				//10 BORDER RIGHT
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.borderright), tilewidth, tileheight, false),
				//11 BORDER TOP RIGHT
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.bordertopright), tilewidth, tileheight, false),
				//12  BORDER TOP LEFT
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.bordertopleft), tilewidth, tileheight, false),
				//13 BORDER BOT RIGHT
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.borderbotright), tilewidth, tileheight, false),
				//14 BORDER BOT LEFT
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.borderbotleft), tilewidth, tileheight, false),
		};
		
		misctexture = new Bitmap[]{
				//0 DEFAULT //ERROR
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.sprite), tilewidth, tileheight, false),
		};
		
		
	}
	
	
	public int drawX(int tilex) {
		return (getxOffset() + (tilex * this.getTilewidth()));
	}
	
	public int drawY(int tileY) {
		return (getyOffset() + (tileY * this.getTileheight()));
	}
	
	public Bitmap getplayerTexture(int n) {
		return n > playerTexture.length ? error : playerTexture[n];
	}
	
	public Bitmap getmapTexture(int n) {
		if (n == -1) {
			return error;
		}
		return n > mapTexture.length ? error : mapTexture[n];
	}
	
	
	public int getRound() {
		return round;
	}
	
	
	int getPath() {
		
		
		return 0;
	}
	
	public void setTouch(int x, int y) {
		touchX = x;
		touchY = y;
	}
}