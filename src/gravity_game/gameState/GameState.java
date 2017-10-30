package gravity_game.gameState;

import gravity_game.game_engine.AllTheMethods;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class GameState implements AllTheMethods{
    //This class represents all things constant between any state the game can be in.

    //Every game state will need the ability to change the game state
    protected GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        //All game states will need the ability to change the ability to change the game state, and thus
        //the game state manager is a required part of every game state
    }

    //All game states need to be updated and have the ability to draw to the window.
    public abstract void tick();

    public abstract void render(Graphics g);

    //All game states will respond to user input.
    public abstract void keyPressed(int k);

    public abstract void keyReleased(int k);

    public abstract void mousePressed(MouseEvent e);

    public abstract void mouseReleased(MouseEvent e);
}