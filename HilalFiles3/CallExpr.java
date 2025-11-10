import java.util.List;

/**
 * CallExpr.java
 * Represents a function call used as an expression: f(), f(a, b)
 */
public class CallExpr extends Expr {
    private String funcName;
    private List<Expr> args;

    public CallExpr(String funcName, List<Expr> args) {
        this.funcName = funcName;
        this.args = args;
    }

    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(funcName).append("(");
        if (args != null && !args.isEmpty()) {
            for (int i = 0; i < args.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(args.get(i).toString(t));
            }
        }
        sb.append(")");
        return sb.toString();
    }
}

