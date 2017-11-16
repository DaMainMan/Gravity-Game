package gravity_game.game_engine.interfaces;

import java.awt.event.MouseEvent;

public interface InputFunctionality {
    void keyPressed(int k);
    void keyReleased(int k);
    void mousePressed(MouseEvent e);
    void mouseReleased(MouseEvent e);
}
