package toy;

import toy.command.CommandExecutor;
import toy.command.CommandListener;

public class Toy {

    public static void main(String[] args) {
        setBound(args);
        CommandListener commandListener = new CommandListener(new Robot());
        commandListener.addObserver(CommandExecutor.getInstance());
        new Thread(commandListener).start();
    }

    private static void setBound(String[] args) {
        if (args == null || args.length < 2) {
            throw new IllegalStateException("Please set x and y for bound!");
        }
        int x, y;
        try {
            x = Integer.valueOf(args[0]);
            y = Integer.valueOf(args[1]);
        } catch (Exception e) {
            throw new IllegalStateException("Please set valid x and y for bound!");
        }
        if (x <= 0 || y <=0) {
            throw new IllegalStateException("Bound x or y must be greater than 0!");
        }
        Bound.newBound(x, y);
    }

}
