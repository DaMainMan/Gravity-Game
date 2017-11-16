package gravity_game.gameState;

import gravity_game.game_engine.KeyMap;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameStateManager {
    //This class has the basic function of organizing and controlling all of the states the game can be in.
    private ArrayList<GameState> states;
    private KeyMap keyMap;
    private int gameState;

    public GameStateManager(KeyMap keyMap) {
        gameState = 0;
        states = new ArrayList<>();
        this.keyMap = keyMap;
        registerStates();
    }

    public void tick() {
        states.get(gameState).tick();
    }

    public void render(Graphics2D g) {
        states.get(gameState).render(g);
    }

    public void keyPressed(int k) {
        states.get(gameState).keyPressed(k);
    }

    public void keyReleased(int k) {
        states.get(gameState).keyReleased(k);
    }

    public void mousePressed(MouseEvent e) {
        states.get(gameState).mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
        states.get(gameState).mouseReleased(e);
    }

    public void setGameState(int gameState) {
        if (gameState < states.size())
            this.gameState = gameState;
        else
            System.out.println("GameState " + gameState + " does not exist.");
    }

    public void registerStates() {
        states.add(new MenuState(this, keyMap));
        states.add(new WorldState(this, keyMap));
    }
}
