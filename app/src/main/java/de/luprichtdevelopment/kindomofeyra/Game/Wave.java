package de.luprichtdevelopment.kindomofeyra.Game;

import android.graphics.Canvas;

import java.util.ArrayList;

public class Wave implements Core {

    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private float timeSinceLastSpawn, spawnTime;
    private int id;
    private Handler handler;


    public Wave(Handler handler, float spawnTime, int id) {
        this.handler = handler;
        this.spawnTime = spawnTime;
        this.id = id;
        timeSinceLastSpawn = 0;
    }


    private void spawn() {

        enemies.add(new Enemy(handler, 0));
        enemies.add(new Enemy(handler, 0));

    }

    @Override
    public void render() {
        for (Enemy e : enemies) {
            e.render();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        for (Enemy e : enemies) {
            e.draw(canvas);
        }
    }
}
