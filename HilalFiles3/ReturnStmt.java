/**
 * ReturnStmt.java
 * Represents: return;  or  return expr;
 */
public class ReturnStmt extends Stmt {
    private Expr expr; // may be null

    public ReturnStmt(Expr expr) {
        this.expr = expr;
    }

    @Override
    public String toString(int t) {
        if (expr == null) {
            return getTabs(t) + "return;\n";
        }
        return getTabs(t) + "return " + expr.toString(0) + ";\n";
    }
}

