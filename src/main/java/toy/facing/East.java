package toy.facing;

import toy.position.Displacement;

public class East implements Facing {

    private Displacement displacement;

    public Facing left() {
        return new North();
    }

    public Facing right() {
        return new South();
    }

    @Override
    public String toString() {
        return "EAST";
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
