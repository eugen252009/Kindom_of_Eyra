package de.luprichtdevelopment.kindomofeyra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import de.luprichtdevelopment.kindomofeyra.Game.Handler;
import de.luprichtdevelopment.kindomofeyra.Game.Player;
import de.luprichtdevelopment.kindomofeyra.Game.Wave;
import de.luprichtdevelopment.kindomofeyra.map.Map;


/**
 * Created by eugen on 22.04.2017.
 */

public class Surface extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;

    private Paint FPSpaint;
    private Map map;
    private Player player;
    private Wave enemy;
    private int tiles = 11;
    private Handler handler;


    public Surface(Context context) {
        super(context);

        getHolder().addCallback(this);

        setFocusable(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
	    handler.setTouch((int) event.getX(), (int) event.getY());
        return true;
    }

    void init() {

        //DEBUG
        FPSpaint = new Paint();
        FPSpaint.setColor(Color.WHITE);
        FPSpaint.setTextSize(90);
        //Handler
        handler = new Handler(this.getWidth(), this.getHeight());
        //Start Thread
        main();
    }

    void main() {
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
    }


    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (thread != null) {
            thread.setRunning(false);
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        init();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (thread != null) {
            thread.setRunning(false);
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(Canvas canvas, int FPS) {
        // super.draw(canvas);
        canvas.drawColor(Color.DKGRAY);
        handler.draw(canvas);

//        canvas.drawColor(Color.DKGRAY);
//

        canvas.drawText("FPS:" + FPS, this.getWidth() - 300, 90, FPSpaint);

    }

    public void update() {
	    handler.render();
    }

}

