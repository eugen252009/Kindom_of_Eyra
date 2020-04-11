package de.luprichtdevelopment.kindomofeyra.Game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;

import de.luprichtdevelopment.kindomofeyra.R;
import de.luprichtdevelopment.kindomofeyra.tools.AppTools;


public class Player {
	private int health;
	private int armor;
	private int coins;
	private Bitmap heartbit, base, armorbit, coinbit;
	private Paint heartcolor = new Paint();
	private Paint armorcolor = new Paint();
	private Paint coincolor = new Paint();
	private int bitheight, bitwidth;
	private float x, y;
	private Wave[] enemies = new Wave[1];
	private boolean enemy = true;
	private Handler handler;
	private float speed = 0;
	private int lastRound = 0;
	private boolean isEnemy;
	private Mobs army;
	private ArrayList<Mobs> Army = new ArrayList<>();
	private Point waypoint = new Point();
	
	
	Player(Handler handler, int health, int armor, int coins, boolean isEnemy) {
		this.handler = handler;
		this.health = health;
		this.armor = armor;
		this.coins = coins;
		this.isEnemy = isEnemy;
		bitheight = 50;
		bitwidth = 50;
		init();
	}
	
	@SuppressWarnings("all")
	public void setBase(int tilewidth, int tileheight) {
		if (!isEnemy)
			base = handler.getplayerTexture(0);//PLAYER
		if (isEnemy)
			base = handler.getplayerTexture(1);//ENEMY
	}
	
	private void init() {
		//Health
		heartbit = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.heart), bitwidth, bitheight, false);
		heartcolor.setColor(Color.rgb(255, 0, 0));
		heartcolor.setTextSize(bitheight);
		
		armorbit = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.armor), bitwidth, bitheight, false);
		armorcolor.setColor(Color.rgb(137, 137, 137));
		armorcolor.setTextSize(bitheight);
		
		coinbit = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.coin), bitwidth, bitheight, false);
		coincolor.setColor(Color.rgb(227, 212, 48));
		coincolor.setTextSize(bitheight);
		
		
	}
	
	void drawHUD(Canvas canvas, int y) {
		//heart
		canvas.drawBitmap(heartbit, 10, y + bitheight, null);
		canvas.drawText("" + health, 70, y + 90, heartcolor);
		//Armor
		canvas.drawBitmap(armorbit, 10, y + bitheight * 2 + 10, null);
		canvas.drawText("" + armor, 70, y + 150, armorcolor);
		//COINS
		canvas.drawBitmap(coinbit, 10, y + bitheight * 3 + 20, null);
		canvas.drawText("" + coins, 70, y + bitheight * 4 + 10, coincolor);
	}
	
	public Bitmap getBase() {
		return base;
	}
	
	public float getX() {
		return x;
	}
	
	@SuppressWarnings("all")
	public void setX(int x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	void setY(int y) {
		this.y = y;
	}
	
	
	void render() {
		if (handler.getRound() % 2 == 0 && !isEnemy) {
			Log.i("Round:", "Player Round " + handler.getRound());
			
			
		} else if (handler.getRound() % 2 == 1 && isEnemy) {
			Log.i("Round:", "Enemy Round " + handler.getRound());
         
            
            
        }
	}
	
	void draw(Canvas canvas) {
		canvas.drawBitmap(base, handler.drawX((int) x), handler.drawY((int) y), null);
		for (Mobs mobs : Army) {
			mobs.draw(canvas);
		}
	}
	
	public Wave[] getEnemies() {
		return enemies;
	}
	
	public Mobs getArmy() {
		return army;
	}
}
