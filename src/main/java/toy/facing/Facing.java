package toy.facing;

import toy.position.Displacement;

public interface Facing {

    Facing left();

    Facing right();

    Displacement getDisplacement();

    void accept(FacingVisitor visitor);

}
