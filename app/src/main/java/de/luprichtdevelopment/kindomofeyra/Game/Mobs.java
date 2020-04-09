package de.luprichtdevelopment.kindomofeyra.Game;

import android.graphics.Canvas;

public class Mobs {

    int Health = 0;
    int Armor = 0;
    int reward = 0;
    int speed = 0;
    private Handler handler;


    public Mobs(Handler handler) {
        this.handler = handler;
        init();
    }

    private void init() {


    }


    public void addMob(int id) {
        switch (id) {
            case 1:

                break;
        }


    }

    public void render(int x, int y) {

    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(handler.getTexture(0), handler.drawX(0), handler.drawY(1), null);
    }


}
