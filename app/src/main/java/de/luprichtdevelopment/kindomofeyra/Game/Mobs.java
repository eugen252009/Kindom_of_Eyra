package de.luprichtdevelopment.kindomofeyra.Game;

import android.graphics.Canvas;
import android.graphics.Point;

public class Mobs {
	
	private int Health = 0;
	private int Armor = 0;
	private int reward = 0;
	private int speed = 0;
	private int dmg = 0;
	private Handler handler;
	private boolean isVisible = true;
	private int x, y;
	private Point waypoint = new Point();
	
	public Mobs(Handler handler) {
		this.handler = handler;
		init();
	}
	
	public Mobs(Handler handler, int id) {
		this.handler = handler;
		init(id);
	}
	
	private void init() {
	}
	
	private void init(int id) {
		addMob(id, x, y);
		
	}
	
	public void addMob(int id, int x, int y) {
		this.x = x;
		this.y = y;
		addMob(id);
	}
	
	public void addMob(int id) {
		switch (id) {
			//PlayerMOBS
			case 1:
				Health = 20;
				Armor = 10;
				reward = 1;
				speed = 10;
				dmg = 1;
				break;
			case 2:
				Health = 30;
				Armor = 10;
				reward = 1;
				speed = 10;
				dmg = 1;
				break;
			case 3:
				Health = 40;
				Armor = 10;
				reward = 1;
				speed = 10;
				dmg = 1;
				break;
			case 4:
				Health = 50;
				Armor = 10;
				reward = 1;
				speed = 10;
				dmg = 1;
				break;
			case 5:
				Health = 60;
				Armor = 10;
				reward = 1;
				speed = 10;
				dmg = 1;
				break;
			case 6:
				Health = 70;
				Armor = 10;
				reward = 1;
				speed = 10;
				dmg = 1;
				break;
			case 7:
				Health = 80;
				Armor = 10;
				reward = 1;
				speed = 10;
				dmg = 1;
				break;
			case 8:
				Health = 90;
				Armor = 10;
				reward = 1;
				speed = 10;
				dmg = 1;
				break;
			case 9:
				Health = 1000;
				Armor = 1;
				reward = 1;
				speed = 10;
				dmg = 1;
				break;
			case 10:
				Health = 100;
				Armor = 50;
				reward = 1;
				speed = 10;
				dmg = 1;
				break;
			//ENEMY MOBS
			
		}
		
		
	}
	
	public boolean render(int x, int y) {
		if (getHealth() == 0) {
			setVisible(false);
			return true;
		}
		return false;
	}
	
	public void draw(Canvas canvas) {
		if (isVisible) {
			canvas.drawBitmap(handler.getplayerTexture(2), handler.drawX(0), handler.drawY(1), null);
		}
	}
	
	
	public int getHealth() {
		return Health;
	}
	
	public void setHealth(int health) {
		Health = health;
	}
	
	public int getArmor() {
		return Armor;
	}
	
	public void setArmor(int armor) {
		Armor = armor;
	}
	
	public int getReward() {
		return reward;
	}
	
	public void setReward(int reward) {
		this.reward = reward;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	public void setVisible(boolean visible) {
		isVisible = visible;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getDmg() {
		return dmg;
	}
	
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	
	public Point getWaypoint() {
		return waypoint;
	}
	
	public void setWaypoint(Point waypoint) {
		this.waypoint = waypoint;
	}
}
