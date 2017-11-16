package gravity_game.gameState;

import gravity_game.game_engine.KeyMap;
import gravity_game.game_engine.interfaces.InputFunctionality;
import gravity_game.game_engine.interfaces.PrimaryFunctionality;

public abstract class GameState implements PrimaryFunctionality , InputFunctionality{

    protected GameStateManager gsm;
    protected KeyMap keyMap;

    public GameState(GameStateManager gsm, KeyMap keyMap) {
        this.gsm = gsm;
    }
}