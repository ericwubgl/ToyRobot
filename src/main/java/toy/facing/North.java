package toy.facing;

import toy.position.Displacement;

public class North implements Facing {

    private Displacement displacement;

    public Facing left() {
        return new West();
    }

    public Facing right() {
        return new East();
    }

    @Override
    public String toString() {
        return "NORTH";
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
