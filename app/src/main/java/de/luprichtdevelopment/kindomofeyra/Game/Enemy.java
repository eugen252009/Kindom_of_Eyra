package de.luprichtdevelopment.kindomofeyra.Game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Enemy implements Core {

    private Handler handler;
    private int health;
    private int armor;
    private float speed = 0.1f;
    private float x, y;
    private Bitmap texture;
    private int lastRound = 0;


    public Enemy(Handler handler, int id) {
        this.handler = handler;
        switch (id) {
            case 0:
                this.health = 20;
                this.armor = 2;
                x = handler.getEnemy().getX();
                y = handler.getEnemy().getY();
                texture = handler.getTexture(11);
                break;


        }
        this.speed /= 10000;
    }

    @Override
    public void render() {


    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(texture, handler.getxOffset() + (x * handler.getTilewidth()), handler.getyOffset() + (y) * handler.getTileheight(), null);

    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Bitmap getTexture() {
        return texture;
    }

    public void setTexture(Bitmap texture) {
        this.texture = texture;
    }
}
