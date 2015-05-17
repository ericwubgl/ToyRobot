package toy.command;

import toy.Robot;

public class ReportCommand implements Command {

    private static ReportCommand instance;

    public static ReportCommand getInstance() {
        if (instance == null) {
            instance = new ReportCommand();
        }
        return instance;
    }

    private ReportCommand() {}

    public void execute(Robot robot) {
        if (robot.getPosition() == null || robot.getFacing() == null) {
            System.out.println("Aborted. Robot is not even placed on table!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Output: ")
            .append(robot.getPosition().getX())
            .append(", ")
            .append(robot.getPosition().getY())
            .append(", ")
            .append(robot.getFacing().toString());
        System.out.println(sb.toString());
    }

}
