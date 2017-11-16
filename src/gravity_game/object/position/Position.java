package gravity_game.object.position;

import gravity_game.game_engine.Game;

public class Position{
    private double x, y, rotation;

    private static Position offset = new Position();
    private static boolean playerCentric = true;

    public Position(double x, double y, double rotation){
        this.x=x;
        this.y=y;
        this.rotation=rotation;
    }

    public Position(){
        x = 0;
        y = 0;
        rotation = 0;
    }

    public Position(Position position){
        x = position.x;
        y = position.y;
        rotation = position.rotation;
    }

    public Position translate(Position position){
        this.x += position.x;
        this.y += position.y;
        return this;
    }

    public Position rotatePosition(double radians){
        this.rotation += radians;
        return this;
    }

    public Position rotateAbout(Position position, double radians){
        double xDis = position.x-x,
                yDis = position.y-y,
                distance = Math.sqrt(xDis*xDis+yDis*yDis),
                currentRadians = Math.atan(yDis/xDis),
                newRadians = currentRadians + radians;
        x = position.x + Math.cos(newRadians)*distance;
        y = position.y + Math.sin(newRadians)*distance;
        rotation += radians;
        return this;
    }

    public Position rotateTo(Position position, double radians){
        double distance = distance(position);
        x = position.x + Math.cos(radians)*distance;
        y = position.y + Math.sin(radians)*distance;
        rotation = radians;
        return this;
    }

    public Position minus(){
        return new Position(-x, -y, rotation);
    }

    public double distance(Position position){
        double xDis = x-position.x, yDis = y-position.y;
        return Math.sqrt(xDis*xDis + yDis*yDis);
    }

    public Position setDistanceFrom(Position position, double newDistance){
        double xDis = position.x-x,
                yDis = position.y-y,
                distance = Math.sqrt(xDis*xDis+yDis*yDis);
        x = position.x + xDis*newDistance/distance;
        y = position.y + yDis*newDistance/distance;
        return this;
    }

    public Position apply(Vector vector){
        x += vector.getVelX();
        y += vector.getVelY();
        rotation += vector.getVelAngle();
        return this;
    }

    public Position renderPosition(){
        if(playerCentric)return new Position(this).translate(offset).rotateAbout(new Position(Game.getWIDTH()/2, Game.getHEIGHT()/2, 0), offset.rotation);
        return new Position(this).translate(offset);
    }

    public static Position getOffset() {
        return offset;
    }

    public static boolean isPlayerCentric() {
        return playerCentric;
    }

    public static void setPlayerCentric(boolean playerCentric) {
        Position.playerCentric = playerCentric;
    }

    public Position setX(double x){
        this.x=x;
        return this;
    }

    public Position setY(double y){
        this.y=y;
        return this;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRotation() {
        return rotation;
    }

    public Position setRotation(double rotation){
        this.rotation = rotation;
        return this;
    }
}