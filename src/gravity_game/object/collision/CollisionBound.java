package gravity_game.object.collision;

import gravity_game.object.GameObject;
import gravity_game.object.position.Position;

public abstract class CollisionBound {
    protected GameObject object;
    public CollisionBound(GameObject object){
        this.object = object;
    }

    public abstract boolean intersects(EllipseBound bound);
    public abstract boolean intersects(RectangleBound bound);
    public abstract boolean inside(Position position);
}
