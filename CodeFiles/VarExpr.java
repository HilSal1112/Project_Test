/**
 * VarExpr.java
 * Represents a variable reference in an expression (so like: x, myVar, count)
 */
public class VarExpr extends Expr {
    private String name;
    
    public VarExpr(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(int t) {
        return name;
    }
}
