package toy.command;

import java.util.Observable;
import java.util.Scanner;

import toy.Robot;

public class CommandListener extends Observable implements Runnable {

    private Robot robot;

    public CommandListener(Robot robot) {
        this.robot = robot;
    }

    @SuppressWarnings("resource")
    public void run() {
        while (true) {
            String commandString = new Scanner(System.in).nextLine();
            setChanged();
            notifyObservers(commandString);
        }
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

}
