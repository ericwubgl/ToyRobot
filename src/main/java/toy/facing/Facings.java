package toy.facing;

public enum Facings {

    EAST("east"), WEST("west"), NORTH("north"), SOUTH("south");

    private String name;

    private Facings(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Facings fromString(String name) {
        if (name != null) {
            for (Facings facing : Facings.values()) {
                if (name.equalsIgnoreCase(facing.name)) {
                    return facing;
                }
            }
        }
        return null;
    }

}
