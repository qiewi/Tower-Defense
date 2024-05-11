package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class Playing extends GameScene implements SceneMethods {
    
    public Playing(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 640, 640);
    }
}
