package gravity_game.object;

import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Vector velocity;

    public GameObject(Position position, Vector velocity){
        this.position = position;
        this.velocity = velocity;
    }

    public Position getPosition() {
        return position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void tick(){
        position.apply(velocity);
    }

    public abstract void render(Graphics g);
}