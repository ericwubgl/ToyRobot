package toy;

public class Bound {

    private static Bound instance = null;

    public static Bound getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Bound is not set!");
        }
        return instance;
    }

    public static Bound newBound(int x, int y) {
        return instance = new Bound(x, y);
    }

    private int x;
    private int y;

    private Bound(int x, int y) {
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

}
