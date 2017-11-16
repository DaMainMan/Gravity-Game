package gravity_game.world;

import gravity_game.game_engine.KeyMap;
import gravity_game.game_engine.interfaces.InputFunctionality;
import gravity_game.game_engine.interfaces.PrimaryFunctionality;
import gravity_game.object.Player;

import java.awt.*;
import java.awt.event.MouseEvent;

public class World implements PrimaryFunctionality, InputFunctionality {
    private GameObjectManager objectManager;
    private Player player;
    private KeyMap keyMap;
    public World(KeyMap keyMap) {
        objectManager = new GameObjectManager();
        player = new Player(this, keyMap);
        objectManager.add(player);
        this.keyMap = keyMap;
    }

    @Override
    public void tick() {
        objectManager.tick();
    }

    @Override
    public void render(Graphics2D g) {
        objectManager.render(g);
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

    public Player getPlayer() {
        return player;
    }
}
