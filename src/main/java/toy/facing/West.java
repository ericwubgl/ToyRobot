package toy.facing;

import toy.position.Displacement;

public class West implements Facing {

    private Displacement displacement;

    public Facing left() {
        return new South();
    }

    public Facing right() {
        return new North();
    }

    @Override
    public String toString() {
        return "WEST";
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
