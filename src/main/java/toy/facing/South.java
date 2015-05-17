package toy.facing;

import toy.position.Displacement;

public class South implements Facing {

    private Displacement displacement;

    public Facing left() {
        return new East();
    }

    public Facing right() {
        return new West();
    }

    @Override
    public String toString() {
        return "SOUTH";
    }

    public Displacement getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Displacement displacement) {
        this.displacement = displacement;
    }

    public void accept(FacingVisitor visitor) {
        visitor.visit(this);
    }

}
