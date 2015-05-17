package toy.command;

import toy.Robot;
import toy.facing.FacingMoveVisitor;
import toy.position.Position;

public class MoveCommand implements Command {

    private int unit = 1;

    public void execute(Robot robot) {
        if (robot.getPosition() == null || robot.getFacing() == null) {
            System.out.println("Aborted. Robot is not even placed on table!");
            return;
        }
        if (unit <= 0) {
            System.out.println("Aborted. Invalid move units.");
            return;
        }
        robot.getFacing().accept(FacingMoveVisitor.getInstance());
        Position existingPosition = new Position(robot.getPosition().getX(), robot.getPosition().getY());
        Position newPosition = existingPosition.displace(robot.getFacing().getDisplacement(), getUnit());
        if (!newPosition.outOfBound()) {
            robot.setPosition(newPosition);
        }
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

}
