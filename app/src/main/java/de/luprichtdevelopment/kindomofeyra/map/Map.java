package de.luprichtdevelopment.kindomofeyra.map;

import android.graphics.Canvas;
import android.graphics.Paint;

import de.luprichtdevelopment.kindomofeyra.Game.Handler;

public class Map {
	
	private final int GRASS = 1;
	private final int PATHTOPRIGHT = 6;
	private final int PATHTOPLEFT = 7;
	private final int PATHBOTRIGHT = 8;
	private final int PATHBOTLEFT = 9;
	private final int BORDERTOP = 10;
	private final int BORDERBOT = 11;
	private final int BORDERLEFT = 12;
	private final int BORDERRIGHT = 13;
	private final int BORDERTOPRIGHT = 14;
	private final int BORDERTOPLEFT = 15;
	private final int BORDERBOTRIGHT = 16;
	private final int BORDERBOTLEFT = 17;
	private final int PATHHORIZONTAL = 18;
	private final int PATHVERTICAL = 19;
	private int[][] map;
	private Handler handler;
	private Paint paint;
	
	public Map(Handler handler) {
		this.handler = handler;
		map = new int[handler.getXtiles()][handler.getYtiles()];
		mapinit();
	}
	
	private void mapinit() {
		for (int i = 0; i < handler.getXtiles(); i++) {
			for (int j = 0; j < handler.getXtiles(); j++) {
				if (i == 0) {
					map[i][j] = BORDERLEFT;
					continue;
				}
				if (j == 0) {
					map[i][j] = BORDERTOP;
					continue;
				}
				if (i == handler.getXtiles() - 1) {
					map[i][j] = BORDERRIGHT;
					continue;
				}
				if (j == handler.getYtiles() - 1) {
					map[i][j] = BORDERBOT;
					continue;
				}
				map[i][j] = GRASS;
			}
			
			//TOP Right
			map[0][handler.getYtiles() - 1] = BORDERTOPRIGHT;
			//TOP LEFT
			map[0][0] = BORDERTOPLEFT;
			//BOTTOM LEFT
			map[handler.getXtiles() - 1][0] = BORDERBOTLEFT;
			//BOTTOM RIGHT
			map[handler.getXtiles() - 1][handler.getYtiles() - 1] = BORDERBOTRIGHT;
			
		}
	}
	
	private int gettextureID(int x, int y) {
		switch (map[x][y]) {
			default:
				return -1;//ERROR
			case GRASS:
				return 0;
			case PATHHORIZONTAL:
				return 1;
			case PATHVERTICAL:
				return 2;
			case PATHBOTLEFT:
				return 3;
			case PATHBOTRIGHT:
				return 4;
			case PATHTOPLEFT:
				return 5;
			case PATHTOPRIGHT:
				return 6;
			case BORDERTOP:
				return 7;
			case BORDERBOT:
				return 8;
			case BORDERLEFT:
				return 9;
			case BORDERRIGHT:
				return 10;
			case BORDERTOPRIGHT:
				return 11;
			case BORDERTOPLEFT:
				return 12;
			case BORDERBOTRIGHT:
				return 13;
			case BORDERBOTLEFT:
				return 14;
		}
	}
	
	
	public void draw(Canvas canvas) {
		for (int i = 0; i < handler.getXtiles(); i++) {
			for (int j = 0; j < handler.getXtiles(); j++) {
				//          if (map[i][j]==-1)break;
				canvas.drawBitmap(handler.getmapTexture(gettextureID(i, j)), handler.getxOffset() + (i * handler.getTilewidth()), handler.getyOffset() + j * handler.getTileheight(), paint);
			}
		}
	}
	
	public void render() {
	
	}
}