package gravity_game.gameState;

import gravity_game.game_engine.KeyMap;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MenuState extends GameState {
    //The menu state functions as a way for the user to navigate their way through all accessible game modes.
    //Overall, this adds a more professional feel to any game.
    public MenuState(GameStateManager gsm, KeyMap keyMap) {
        super(gsm, keyMap);
    }

    @Override
    public void tick() {
        gsm.setGameState(1);
    }

    @Override
    public void render(Graphics2D g) {

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
}
