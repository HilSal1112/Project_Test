/**
 * WhileStmt.java
 * Represents: while (cond) { body }
 */
public class WhileStmt extends Stmt {
    private Expr condition;
    private Stmt body; // usually BlockStmt

    public WhileStmt(Expr condition, Stmt body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTabs(t))
          .append("while (")
          .append(condition.toString(0))
          .append(")\n");
        sb.append(body.toString(t));
        return sb.toString();
    }
}

