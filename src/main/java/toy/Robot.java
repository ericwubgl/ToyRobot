package toy;

import toy.facing.Facing;
import toy.position.Position;

public class Robot {

    private Position position;
    private Facing facing;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }

}
