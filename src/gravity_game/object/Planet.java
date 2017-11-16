package gravity_game.object;

import gravity_game.object.position.Position;
import gravity_game.world.World;

import java.awt.*;

public class Planet extends GameObject {
    private int radius;
    public Planet(World world) {
        super(world);
        radius = 100;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void render(Graphics2D g) {
        Position renderPos = getPosition().renderPosition();
        g.drawOval((int)renderPos.getX()-radius, (int)renderPos.getY()-radius, radius*2, radius*2);
    }
}