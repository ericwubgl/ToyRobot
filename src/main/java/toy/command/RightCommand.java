package toy.command;

import toy.Robot;

public class RightCommand implements Command {

    private static RightCommand instance;

    public static RightCommand getInstance() {
        if (instance == null) {
            instance = new RightCommand();
        }
        return instance;
    }

    private RightCommand() {}

    public void execute(Robot robot) {
        if (robot.getPosition() == null || robot.getFacing() == null) {
            System.out.println("Aborted. Robot is not even placed on table!");
            return;
        }
        robot.setFacing(robot.getFacing().right());
    }

}
