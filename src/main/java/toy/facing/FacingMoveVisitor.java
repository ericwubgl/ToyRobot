package toy.facing;

import toy.position.Displacement;

public class FacingMoveVisitor implements FacingVisitor {

    private static FacingMoveVisitor instance = null;

    public static FacingMoveVisitor getInstance() {
        if (instance == null) {
            instance = new FacingMoveVisitor();
        }
        return instance;
    }

    private FacingMoveVisitor() {}

    public void visit(North north) {
        north.setDisplacement(new Displacement(0, 1));
    }

    public void visit(South south) {
        south.setDisplacement(new Displacement(0, -1));
    }

    public void visit(East east) {
        east.setDisplacement(new Displacement(1, 0));
    }

    public void visit(West west) {
        west.setDisplacement(new Displacement(-1, 0));
    }

}
