/**
 * DecStmt.java
 * Represents: Name--;
 */
public class DecStmt extends Stmt {
    private Expr target; // should be VarExpr or ArrayAccessExpr

    public DecStmt(Expr target) {
        this.target = target;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + target.toString(0) + "--;\n";
    }
}

