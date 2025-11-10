/**
 * assnstmt.java aka Assign Statement
 * Represents an assignment statement: x = expr;
 */
public class AssignStmt extends Stmt {
    private String varName;
    private Expr expr;
    
    public AssignStmt(String varName, Expr expr) {
        this.varName = varName;
        this.expr = expr;
    }
    
    @Override
    public String toString(int t) {
        // Format: x = (expr);
        return getTabs(t) + varName + " = " + expr.toString(t) + ";\n";
    }
}
