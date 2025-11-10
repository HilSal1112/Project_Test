/**
 * TernaryExpr.java
 * Represents: (cond ? thenExpr : elseExpr)
 */
public class TernaryExpr extends Expr {
    private Expr condition;
    private Expr thenExpr;
    private Expr elseExpr;

    public TernaryExpr(Expr condition, Expr thenExpr, Expr elseExpr) {
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }

    @Override
    public String toString(int t) {
        return "(" + condition.toString(t) + " ? " +
               thenExpr.toString(t) + " : " +
               elseExpr.toString(t) + ")";
    }
}

