package toy.command;

import toy.Robot;

public class LeftCommand implements Command {

    private static LeftCommand instance;

    public static LeftCommand getInstance() {
        if (instance == null) {
            instance = new LeftCommand();
        }
        return instance;
    }

    private LeftCommand() {}

    public void execute(Robot robot) {
        if (robot.getPosition() == null || robot.getFacing() == null) {
            System.out.println("Aborted. Robot is not even placed on table!");
            return;
        }
        robot.setFacing(robot.getFacing().left());
    }

}
