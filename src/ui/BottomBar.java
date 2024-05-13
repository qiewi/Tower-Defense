package ui;

import static main.GameStates.setGameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.Tile;
import scenes.Playing;

import static main.GameStates.*;

public class BottomBar {
    
    private int x, y, width, height;
    private Playing playing;
    private MyButton bMenu;

    private Tile selectedTile;

    private ArrayList<MyButton> tileButtons = new ArrayList<MyButton>();

    public BottomBar(int x, int y, int width, int height, Playing playing) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playing = playing;

        initButtons();
    }

    private void drawButtons(Graphics g) {
		bMenu.draw(g);

        drawTileButtons(g);
        drawSelectedTile(g);
	}

    private void drawSelectedTile(Graphics g) {
        if (selectedTile != null) {
            g.drawImage(selectedTile.getSprite(), 550, 650, 50, 50, null);
            g.setColor(Color.BLACK);
            g.drawRect(550, 650, 50, 50);
        }
    }

    private void drawTileButtons(Graphics g) {
        for (MyButton b: tileButtons) {
            // Sprite
            g.drawImage(getButtImg(b.getId()), b.x, b.y, b.width, b.height, null);

            // MouseHover
            if (b.isMouseHover()) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }

            // Border
            g.drawRect(b.x, b.y, b.width, b.height);

            // MousePressed
            if (b.isMousePressed()) {
                g.drawRect(b.x+1, b.y+1, b.width-2, b.height-2);
                g.drawRect(b.x+2, b.y+2, b.width-4, b.height-4);
            }
            
        }
    }

    public BufferedImage getButtImg(int id) {
        return playing.getTileManager().getSprite(id);
    }

    private void initButtons() {
		bMenu = new MyButton("Menu", 2, 642, 100, 30);

        int w = 50;
        int h = 50;
        int xStart = 110;
        int yStart = 650;
        int xOffset = (int) (w * 1.1f);

        int i = 0;
        for (Tile tile : playing.getTileManager().tiles) {
            tileButtons.add(new MyButton(tile.getName(), xStart + xOffset * i, yStart, w, h, i));
            i++;
        }

	}

    public void draw(Graphics g) {
        
        // Background Color
        g.setColor(new Color(92, 64, 51));
        g.fillRect(x, y, width, height);

        // Buttons
        drawButtons(g);
        
    }

	public void mouseClicked(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			setGameState(MENU);
        else {
            for (MyButton b: tileButtons) {
                if (b.getBounds().contains(x, y)) {
                    selectedTile = playing.getTileManager().getTile(b.getId());
                    playing.setSelectedTile(selectedTile);
                    return;
                }
            }
        }

	}

	
	public void mouseMoved(int x, int y) {
		bMenu.setMouseHover(false);
        for (MyButton b: tileButtons) {
            b.setMouseHover(false);
        }
        
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMouseHover(true);
        else {
            for (MyButton b: tileButtons) {
                if (b.getBounds().contains(x, y)){ 
                    b.setMouseHover(true);
                    return;
                }
            }
        }

	}

	
	public void mousePressed(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMousePressed(true);
        else {
            for (MyButton b: tileButtons) {
                if (b.getBounds().contains(x, y)) {
                    b.setMousePressed(true);
                    return;
                }
                
            }
        }
	}

	
	public void mouseReleased(int x, int y) {
		bMenu.resetBooleans();
        for (MyButton b: tileButtons) {
            b.resetBooleans();
        }
	}

}
