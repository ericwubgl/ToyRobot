package toy.position;

import toy.Bound;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean outOfBound() {
        if (x < 0 || y < 0 || x > Bound.getInstance().getX() || y > Bound.getInstance().getY()) {
            return true;
        }
        return false;
    }

    public Position displace(Displacement displacement, int unit) {
        x = x + displacement.getX() * unit;
        y = y + displacement.getY() * unit;
        return this;
    }

}
