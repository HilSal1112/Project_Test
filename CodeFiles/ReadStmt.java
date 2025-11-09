import java.util.List;

/**
 * ReadStmt.java
 * Represents: read(x, y, arr[i]);
 */
public class ReadStmt extends Stmt {
    private List<Expr> targets; // should be Name/ArrayAccessExpr nodes

    public ReadStmt(List<Expr> targets) {
        this.targets = targets;
    }

    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTabs(t)).append("read(");
        if (targets != null && !targets.isEmpty()) {
            for (int i = 0; i < targets.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(targets.get(i).toString(0));
            }
        }
        sb.append(");\n");
        return sb.toString();
    }
}

