package gravity_game.object;

import gravity_game.game_engine.KeyMap;
import gravity_game.game_engine.interfaces.InputFunctionality;
import gravity_game.game_engine.interfaces.PrimaryFunctionality;
import gravity_game.object.position.Position;
import gravity_game.world.World;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Player extends GameObject implements PrimaryFunctionality, InputFunctionality{
    private int radius;
    private boolean left, right;
    private KeyMap keyMap;
    public Player(World world, KeyMap keyMap) {
        super(world);
        radius = 10;
        this.keyMap = keyMap;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.RED);
        Position renderPos = getPosition().renderPosition();
        g.drawOval((int)renderPos.getX()-radius, (int)renderPos.getY()-radius, radius*2, radius*2);
    }

    public void keyPressed(int k){

    }

    public void keyReleased(int k){

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}