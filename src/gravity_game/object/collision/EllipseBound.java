package gravity_game.object.collision;

import gravity_game.object.GameObject;
import gravity_game.object.position.Position;

public class EllipseBound extends CollisionBound{
    private double radius;

    public EllipseBound(GameObject object, double radius) {
        super(object);
        this.radius = radius;
    }

    @Override
    public boolean intersects(EllipseBound ellipseBound) {
        return ellipseBound.object.getPosition().distance(object.getPosition())<=radius+ellipseBound.radius;
    }

    @Override
    public boolean intersects(RectangleBound bound) {
        return false;
    }

    @Override
    public boolean inside(Position position) {
        return position.distance(object.getPosition())<radius;
    }

    public double getRadius() {
        return radius;
    }
}
