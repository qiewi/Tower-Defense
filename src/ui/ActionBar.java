package ui;

import static main.GameStates.setGameState;

import java.awt.Color;
import java.awt.Graphics;

import scenes.Playing;

import static main.GameStates.*;

public class ActionBar extends Bar{
    
    private Playing playing;
    private MyButton bMenu;

    public ActionBar(int x, int y, int width, int height, Playing playing) {
        super(x, y, width, height);
        this.playing = playing;

        initButtons();
    }

    private void drawButtons(Graphics g) {
		bMenu.draw(g);

	}

    private void initButtons() {
		bMenu = new MyButton("Menu", 2, 642, 100, 30);
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

	}


    public void mouseMoved(int x, int y) {
		bMenu.setMouseHover(false);
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMouseHover(true);
	}

	
	public void mousePressed(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMousePressed(true);
	}

	
	public void mouseReleased(int x, int y) {
		bMenu.resetBooleans();
	}

}
