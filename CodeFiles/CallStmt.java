import java.util.List;

/**
 * CallStmt.java
 * Represents function calls used as statements: f(); f(a, b);
 */
public class CallStmt extends Stmt {
    private String funcName;
    private List<Expr> args;

    public CallStmt(String funcName, List<Expr> args) {
        this.funcName = funcName;
        this.args = args;
    }

    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTabs(t)).append(funcName).append("(");
        if (args != null && !args.isEmpty()) {
            for (int i = 0; i < args.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(args.get(i).toString(0));
            }
        }
        sb.append(");\n");
        return sb.toString();
    }
}

