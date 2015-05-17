package toy.facing;


public interface FacingVisitor {

    void visit(North north);
    void visit(South south);
    void visit(East east);
    void visit(West west);

}
