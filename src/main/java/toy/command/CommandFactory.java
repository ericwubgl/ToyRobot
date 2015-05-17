package toy.command;

import toy.facing.Facing;
import toy.facing.FacingFactory;
import toy.facing.Facings;
import toy.position.Position;

public class CommandFactory {

    private static CommandFactory instance = null;

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    private CommandFactory() {}

    public Command getCommand(String commandString) {
        if (commandString == null || commandString.length() == 0) {
            return null;
        }
        Command newCommand = null;
        String[] commands = commandString.split(" ");
        Commands command = Commands.fromString(commands[0]);
        if (command == null) {
            System.out.println("Aborted. Invalid command.");
            return null;
        }
        switch (command) {
            case PLACE:
                String[] placeParams = null;
                Position position = null;
                Facing facing = null;
                try {
                    if (commands.length > 1) {
                        placeParams = commands[1].split(",");
                        position = new Position(Integer.valueOf(placeParams[0]), Integer.valueOf(placeParams[1]));
                        facing = FacingFactory.getInstance().getFacing(Facings.fromString(placeParams[2]).getName());
                    }
                } catch (Exception e) {
                    // Handled by command
                }
                newCommand = new PlaceCommand();
                ((PlaceCommand) newCommand).setPosition(position);
                ((PlaceCommand) newCommand).setFacing(facing);
                break;
            case LEFT:
                newCommand = LeftCommand.getInstance();
                break;
            case RIGHT:
                newCommand = RightCommand.getInstance();
                break;
            case MOVE:
                newCommand = new MoveCommand();
                try {
                    if (commands.length > 1) {
                        String moveParam = commands[1];
                        ((MoveCommand) newCommand).setUnit(Integer.valueOf(moveParam));
                    }
                } catch (Exception e) {
                    ((MoveCommand) newCommand).setUnit(0);
                }
                break;
            case REPORT:
                newCommand = ReportCommand.getInstance();
                break;
            default:
                newCommand = null;
                break;
        }
        return newCommand;
    }

}
