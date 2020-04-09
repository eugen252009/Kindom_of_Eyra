package de.luprichtdevelopment.kindomofeyra.Game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import de.luprichtdevelopment.kindomofeyra.R;
import de.luprichtdevelopment.kindomofeyra.tools.AppTools;


public class Player implements Core {
    private int health = 0;
    private int armor = 0;
    private int coins = 0;
    private Bitmap heartbit, base, armorbit, coinbit;
    private Paint heartcolor = new Paint();
    private Paint armorcolor = new Paint();
    private Paint coincolor = new Paint();
    private int bitheight, bitwidth;
    private float x, y;
    private Wave[] enemies = new Wave[1];
    private boolean enemy = false;
    private Handler handler;
    private float speed = 0;
    private int lastRound = 0;
    private boolean isEnemy = true;
    private Mobs army;


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

    public void setBase(int tilewidth, int tileheight) {
        if (!isEnemy)
            base = handler.getTexture(9);//PLAYER
        if (isEnemy)
            base = handler.getTexture(10);//ENEMY
    }

    void init() {
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

        army = new Mobs(handler);

    }

    void drawHUD(Canvas canvas) {
        //heart
        canvas.drawBitmap(heartbit, 10, bitheight, null);
        canvas.drawText("" + health, 70, 90, heartcolor);
        //Armor
        canvas.drawBitmap(armorbit, 10, bitheight * 2 + 10, null);
        canvas.drawText("" + armor, 70, 150, armorcolor);
        //COINS
        canvas.drawBitmap(coinbit, 10, bitheight * 3 + 20, null);
        canvas.drawText("" + coins, 70, bitheight * 4 + 10, coincolor);
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

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public void render() {
        if (handler.getRound() > lastRound) {
            army.addMob(0);
            army.render(1, 0);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(base, handler.drawX((int) x), (int) y, null);
    }

    public Wave[] getEnemies() {
        return enemies;
    }

    public Mobs getArmy() {
        return army;
    }
}
