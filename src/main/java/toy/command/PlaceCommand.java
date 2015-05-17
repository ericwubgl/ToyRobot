package toy.command;

import toy.Robot;
import toy.facing.Facing;
import toy.position.Position;

public class PlaceCommand implements Command {

    private Position position;
    private Facing facing;

    public void execute(Robot robot) {
        if (getPosition() == null || getFacing() == null || getPosition().outOfBound()) {
            System.out.println("Please place me on the table with a valid facing!");
            return;
        }
        robot.setPosition(getPosition());
        robot.setFacing(getFacing());
    }

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
