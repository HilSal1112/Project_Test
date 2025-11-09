/**
 * CastExpr.java
 * Represents: (Type) expr   e.g., (int)x
 */
public class CastExpr extends Expr {
    private String typeName; // "int", "float", "bool", etc.
    private Expr expr;

    public CastExpr(String typeName, Expr expr) {
        this.typeName = typeName;
        this.expr = expr;
    }

    @Override
    public String toString(int t) {
        return "(" + typeName + ") " + expr.toString(t);
    }
}

