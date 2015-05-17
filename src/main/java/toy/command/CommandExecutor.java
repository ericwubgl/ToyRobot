package toy.command;

import java.util.Observable;
import java.util.Observer;

public class CommandExecutor implements Observer {

    private static CommandExecutor instance = null;

    public static CommandExecutor getInstance() {
        if (instance == null) {
            instance = new CommandExecutor();
        }
        return instance;
    }

    private CommandExecutor() {}

    public void update(Observable listener, Object commandString) {
        Command command = CommandFactory.getInstance().getCommand((String) commandString);
        if (command != null) {
            command.execute(((CommandListener) listener).getRobot());
        }
    }

}
