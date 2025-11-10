/**
 * IncStmt.java
 * Represents: Name++;
 */
public class IncStmt extends Stmt {
    private Expr target; // should be VarExpr or ArrayAccessExpr

    public IncStmt(Expr target) {
        this.target = target;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + target.toString(0) + "++;\n";
    }
}

