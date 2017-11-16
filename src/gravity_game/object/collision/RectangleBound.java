package gravity_game.object.collision;

import gravity_game.object.GameObject;
import gravity_game.object.position.Position;

public class RectangleBound extends CollisionBound {
    private double width, height;
    public RectangleBound(GameObject object, double width, double height) {
        super(object);
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean intersects(EllipseBound bound) {
        double x = object.getPosition().getX(), y = object.getPosition().getY(),
                x1 = bound.object.getPosition().getX(), y1 = bound.object.getPosition().getY(), radius = bound.getRadius();
        if(x1>x&&x1<x+width){
            return (y1+radius>y&&y1+radius<y+height) || (y1-radius>y&&y1-radius<y+height);
        }
        else if(y1>y&&y1<y+height){
            return (x1+radius>x&&x1+radius<x+width) || (y1-radius>y&&y1-radius<y+height);
        }
        return Math.sqrt(Math.pow(x1-x, 2)+Math.pow(y1-y, 2))<radius||
                Math.sqrt(Math.pow(x1-(x+width), 2)+Math.pow(y1-y, 2))<radius||
                Math.sqrt(Math.pow(x1-x, 2)+Math.pow(y1-(y+height), 2))<radius||
                Math.sqrt(Math.pow(x1-(x+width), 2)+Math.pow(y1-(y+height), 2))<radius;
    }

    @Override
    public boolean intersects(RectangleBound bound) {
        double x = object.getPosition().getX(), y = object.getPosition().getY(), x1 = bound.object.getPosition().getX(), y1 = bound.object.getPosition().getY();
        return  (x>x1&&x<x1+bound.width&&y>y1&&y<y1+bound.height)||
                (x+width>x1&&x+width<x1+bound.width&&y>y1&&y<y1+bound.width)||
                (x>x1&&x<x1+bound.width&&y+height>y1&&y+height<y1+bound.height)||
                (x+width>x1&&x+width<x1+bound.width&&y+height>y1&&y+height<y1+bound.width);
    }

    @Override
    public boolean inside(Position position) {
        return position.getX()>object.getPosition().getX()&&
                position.getX()<object.getPosition().getX()+width&&
                position.getY()>object.getPosition().getY()&&
                position.getY()<object.getPosition().getY()+width;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
