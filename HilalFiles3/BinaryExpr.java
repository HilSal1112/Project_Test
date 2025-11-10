/**
 * BinaryExpr.java
 * Represents binary operation between any two expressions
 * such as a+b or x*y
 * supposed to format it then print. 
 */

public class BinaryExpr extends Expr {
    private Expr left;
    private String op;
    private Expr right;
    
    public BinaryExpr(Expr left, String op, Expr right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
    
    @Override
    public String toString(int t) {
        return "(" + left.toString(t) + " " + op + " " + right.toString(t) + ")";
    }
}
