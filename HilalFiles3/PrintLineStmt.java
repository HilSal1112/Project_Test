import java.util.List;

/**
 * PrintLineStmt.java
 *   printline();            // no args
 *   printline(expr1, ...);  // with args
 */
public class PrintLineStmt extends Stmt {
    private List<Expr> exprs; // may be null/empty

    public PrintLineStmt(List<Expr> exprs) {
        this.exprs = exprs;
    }

    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTabs(t)).append("printline(");
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

