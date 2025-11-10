import java.util.List;

/**
 * PrintStmt.java
 * Represents: print(expr1, expr2, ...);
 */
public class PrintStmt extends Stmt {
    private List<Expr> exprs;

    public PrintStmt(List<Expr> exprs) {
        this.exprs = exprs;
    }

    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTabs(t)).append("print(");
        if (exprs != null && !exprs.isEmpty()) {
            for (int i = 0; i < exprs.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(exprs.get(i).toString(0));
            }
        }
        sb.append(");\n");
        return sb.toString();
    }
}

