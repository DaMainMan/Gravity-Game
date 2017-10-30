package gravity_game.game_engine;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface AllTheMethods {
    void tick();
    void render(Graphics g);
    void keyPressed(int k);
    void keyReleased(int k);
    void mousePressed(MouseEvent e);
    void mouseReleased(MouseEvent e);
}
