package gravity_game.world;

import gravity_game.game_engine.AllTheMethods;

import java.awt.*;
import java.awt.event.MouseEvent;

public class World implements AllTheMethods{
    private GameObjectManager objectManager;
    public World(){
        objectManager = new GameObjectManager();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    public GameObjectManager getObjectManager() {
        return objectManager;
    }
}
