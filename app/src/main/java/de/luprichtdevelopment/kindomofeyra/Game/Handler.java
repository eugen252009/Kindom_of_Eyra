//"C:\Users\Niklas\AppData\Local\Android\Sdk\platform-tools\adb.exe" connect 192.168.178.51
//"C:\Users\Eugen\AppData\Local\Android\Sdk\platform-tools\adb.exe" connect 192.168.178.25
package de.luprichtdevelopment.kindomofeyra.Game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
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
    // private Bitmap sprite, grass, rock, pathhorizontal, pathvertical, pathtopright, pathtopleft, pathbotright, pathbotleft, playerbase, enemybase, enemyone;
    private Bitmap[] texture = new Bitmap[30];
    private int round = 0;

    //TILES
    private int tiles = 11;
    //fixedSIze
    private int tilesize = 100;
    private boolean fixedSize = true;

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


        //Map
        map = new Map(this);


        //PLAYER
        player = new Player(this, 20, 20, 100);
        player.setBase(0, tilewidth, tileheight);
        player.setX(tiles - 2);
        player.setY(tiles / 2);


        //ENEMY
        enemy = new Player(this, 20, 20, 100);
        enemy.setBase(1, tilewidth, tileheight);
        enemy.setX(2);
        enemy.setY(tiles / 2);
        wave = new Wave(this, 2, 0);


    }


    public void draw(Canvas canvas) {
        player.drawHUD(canvas);
        map.draw(canvas);
        enemy.draw(canvas);
        wave.draw(canvas);
        player.draw(canvas);
    }

    public void render(Point touch) {
        player.render();
        wave.render();
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


        texture = new Bitmap[]{
                //0 DEFAULT
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.sprite), tilewidth, tileheight, false),//0
                //1 GRASS
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.grass), tilewidth, tileheight, false),
                //2 Rock
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.rock), tilewidth, tileheight, false),
                //3 Pathhorizontal
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathhorizontal), tilewidth, tileheight, false),
                //4 Pathvertical
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathvertical), tilewidth, tileheight, false),
                //5 Path-Bot-Left
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathbotleft), tilewidth, tileheight, false),
                //6 Path-Bot-Right
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathbotright), tilewidth, tileheight, false),
                //7 Path-Top-Left
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathtopleft), tilewidth, tileheight, false),
                //8 Path-Top-Right
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.pathtopright), tilewidth, tileheight, false),
                //9 PLAYER base
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.playerbase), 2 * tilewidth, 2 * tileheight, false),
                //10 ENEMY base
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.enemybase), 2 * tilewidth, 2 * tileheight, false),
                //11 Enemyone
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.enemyone), tilewidth, tileheight, false),


                //DEBUGG
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.rock1), tilewidth, tileheight, false),
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.rock2), tilewidth, tileheight, false),
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.rock3), tilewidth, tileheight, false),
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.rock), tilewidth, tileheight, false),
                //15
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.rockecketopright), tilewidth, tileheight, false),
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.rockecketopleft), tilewidth, tileheight, false),
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.rockeckebotright), tilewidth, tileheight, false),
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppTools.getAppContext().getResources(), R.raw.rockeckebotleft), tilewidth, tileheight, false),


        };


    }

    public Bitmap getTexture(int n) {
        return n > texture.length ? texture[0] : texture[n];
    }

    public int getRound() {
        return round;
    }
}