package toy.facing;

public class FacingFactory {

    private static FacingFactory instance = null;

    public static FacingFactory getInstance() {
        if (instance == null) {
            instance = new FacingFactory();
        }
        return instance;
    }

    private FacingFactory() {}

    public Facing getFacing(String facingString) {
        if (facingString == null || facingString.length() == 0) {
            return null;
        }
        Facing newFacing = null;
        Facings facing = Facings.fromString(facingString);
        switch (facing) {
            case NORTH:
                newFacing = new North();
                break;
            case SOUTH:
                newFacing = new South();
                break;
            case EAST:
                newFacing = new East();
                break;
            case WEST:
                newFacing = new West();
                break;
            default:
                newFacing = null;
                break;
        }
        return newFacing;
    }

}
