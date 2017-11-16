package gravity_game.object;

import gravity_game.object.position.Position;
import gravity_game.object.position.Vector;
import gravity_game.world.World;

import java.awt.*;

public abstract class GameObject {

    private Position position;
    private Vector velocity;
    private World world;

    public GameObject(World world){
        this.position = new Position();
        this.velocity = new Vector();
        this.world = world;
    }

    public Position getPosition() {
        return position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public World getWorld() {
        return world;
    }

    public void tick(){
        position.apply(velocity);
    }

    public abstract void render(Graphics2D g);
}