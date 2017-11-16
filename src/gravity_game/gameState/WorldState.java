package gravity_game.gameState;

import gravity_game.game_engine.KeyMap;
import gravity_game.world.World;

import java.awt.*;
import java.awt.event.MouseEvent;

public class WorldState extends GameState{
    private World world;
    public WorldState(GameStateManager gsm, KeyMap keyMap) {
        super(gsm, keyMap);
        world = new World(keyMap);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics2D g) {
        world.render(g);
    }

    @Override
    public void keyPressed(int k) {
        world.keyPressed(k);
    }

    @Override
    public void keyReleased(int k) {
        world.keyReleased(k);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        world.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        world.mouseReleased(e);
    }
}
