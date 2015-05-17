package toy.command;

public enum Commands {

    PLACE("place"), LEFT("left"), RIGHT("right"), MOVE("move"), REPORT("report");

    private String name;

    private Commands(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Commands fromString(String name) {
        if (name != null) {
            for (Commands command : Commands.values()) {
                if (name.equalsIgnoreCase(command.name)) {
                    return command;
                }
            }
        }
        return null;
    }

}
