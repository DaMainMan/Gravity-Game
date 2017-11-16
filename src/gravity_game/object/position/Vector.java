package gravity_game.object.position;

public class Vector {
    private double velX, velY, velAngle, direction, magnitude;
    private CoordinateType lastUpdated;

    public Vector() {
        velX = 0;
        velY = 0;
        velAngle = 0;
        direction = 0;
        magnitude = 0;
        lastUpdated = CoordinateType.NONE;
    }

    public double getVelAngle() {
        return velAngle;
    }
    public Vector setVelAngle(double velAngle) {
        this.velAngle = velAngle;
        return this;
    }

    public double getVelX() {
        lastUpdated.update(this);
        return velX;
    }
    public Vector setVelX(double velX) {
        if(lastUpdated.equals(CoordinateType.DM))lastUpdated.update(this);
        this.velX = velX;
        lastUpdated = CoordinateType.XY;
        return this;
    }

    public double getVelY() {
        lastUpdated.update(this);
        return velY;
    }
    public Vector setVelY(double velY) {
        if(lastUpdated.equals(CoordinateType.DM))lastUpdated.update(this);
        this.velY = velY;
        lastUpdated = CoordinateType.XY;
        return this;
    }

    public double getDirection() {
        lastUpdated.update(this);
        return direction;
    }
    public Vector setDirection(double direction) {
        if(lastUpdated.equals(CoordinateType.XY))lastUpdated.update(this);
        this.direction = direction;
        lastUpdated = CoordinateType.DM;
        return this;
    }

    public double getMagnitude() {
        lastUpdated.update(this);
        return magnitude;
    }
    public Vector setMagnitude(double magnitude) {
        if(lastUpdated.equals(CoordinateType.XY))lastUpdated.update(this);
        this.magnitude = magnitude;
        lastUpdated = CoordinateType.DM;
        return this;
    }

    private enum CoordinateType {
        XY {
            @Override
            protected void update(Vector vector) {
                vector.direction = Math.atan(vector.velY/vector.velX);
                vector.magnitude = Math.sqrt(vector.velY*vector.velY+vector.velX*vector.velX);
                vector.lastUpdated = NONE;
            }
        },
        DM {
            @Override
            protected void update(Vector vector) {
                vector.velX = Math.cos(vector.direction)*vector.magnitude;
                vector.velY = Math.sin(vector.direction)*vector.magnitude;
                vector.lastUpdated = NONE;
            }
        },
        NONE {
            @Override
            protected void update(Vector vector){}
        };

        protected abstract void update(Vector vector);
    }
}
