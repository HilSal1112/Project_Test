/**
 * UnaryExpr.java
 * Represents unary operations: +expr, -expr, ~expr
 */
public class UnaryExpr extends Expr {
    private String op;  // "+", "-", "~"
    private Expr expr;

    public UnaryExpr(String op, Expr expr) {
        this.op = op;
        this.expr = expr;
    }

    @Override
    public String toString(int t) {
        return "(" + op + expr.toString(t) + ")";
    }
}

