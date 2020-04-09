package de.luprichtdevelopment.kindomofeyra.map;

import android.graphics.Canvas;
import android.graphics.Paint;

import de.luprichtdevelopment.kindomofeyra.Game.Core;
import de.luprichtdevelopment.kindomofeyra.Game.Handler;

public class Map implements Core {

    private int[][] map;
    private Handler handler;
    private Paint paint;
    private int grass = 0;


    public Map(Handler handler) {
        this.handler = handler;
        map = new int[handler.getXtiles()][handler.getYtiles()];
        mapinit();
    }

    void mapinit() {
        for (int i = 0; i < handler.getXtiles(); i++) {
            for (int j = 0; j < handler.getXtiles(); j++) {
                if (i == 0) {
                    map[i][j] = 6;
                }
                if (j == 0) {
                    map[i][j] = 10;
                }
                if (i == handler.getXtiles() - 1) {
                    map[i][j] = 8;
                }
                if (j == handler.getYtiles() - 1) {
                    map[i][j] = 7;
                }
            }
            map[0][0] = 12;
            map[handler.getXtiles() - 1][0] = 13;
            map[handler.getXtiles() - 1][handler.getYtiles() - 1] = 11;
            map[0][handler.getYtiles() - 1] = 9;

        }
    }

    private int gettextureID(int x, int y) {
        switch (map[x][y]) {
            default:
                return 0;
            case 0:


               /*
if (map[x+1][y]==0&&map[x][y+1]==0){
    map[x][y]=0;
    map[x+1][y]=-1;
    map[x+1][y+1]=-1;
    map[x][y+1]=-1;
}
*/

               /* if (grass<=60){
                    grass++;
                    return 1;
                }
                if (grass>60){
                    grass--;
                    return 12;
                }*/
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            //BORDER
            case 6:
                return 12;
            case 7:
                return 13;
            case 8:
                return 14;
            case 9:
                return 16;
            case 10:
                return 15;
            case 11:
                return 17;
            case 12:
                return 18;
            case 13:
                return 19;


        }
    }
/*  0 DEFAULT
    1 Grass
    2 Rock
    3 PathHorizontal
    4 Pathevertical
    5 path Bot left
    6 path bot right
    7 path top left
    8 path top right
    9 player base
    10 enemy base
    11 enemy one
* */

    public void draw(Canvas canvas) {
        for (int i = 0; i < handler.getXtiles(); i++) {
            for (int j = 0; j < handler.getXtiles(); j++) {
                //          if (map[i][j]==-1)break;
                canvas.drawBitmap(handler.getTexture(gettextureID(i, j)), handler.getxOffset() + (i * handler.getTilewidth()), handler.getyOffset() + j * handler.getTileheight(), paint);
            }
        }
    }


    @Override
    public void render() {

    }
}