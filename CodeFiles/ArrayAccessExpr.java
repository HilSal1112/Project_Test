/**
 * ArrayAccessExpr.java
 * Represents array access: name[expr]
 */
public class ArrayAccessExpr extends Expr {
    private String arrayName;
    private Expr index;

    public ArrayAccessExpr(String arrayName, Expr index) {
        this.arrayName = arrayName;
        this.index = index;
    }

    @Override
    public String toString(int t) {
        return arrayName + "[" + index.toString(t) + "]";
    }
}

