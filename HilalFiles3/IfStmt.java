/**
 * IfStmt.java
 * Represents:
 *   if (cond) { thenStmts }
 *   if (cond) { thenStmts } else { elseStmts }
 */
public class IfStmt extends Stmt {
    private Expr condition;
    private Stmt thenPart; // usually BlockStmt
    private Stmt elsePart; // may be null

    public IfStmt(Expr condition, Stmt thenPart, Stmt elsePart) {
        this.condition = condition;
        this.thenPart = thenPart;
        this.elsePart = elsePart;
    }

    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTabs(t))
          .append("if (")
          .append(condition.toString(0))
          .append(")\n");
        sb.append(thenPart.toString(t + 0)); // thenPart already handles its own braces/indent

        if (elsePart != null) {
            sb.append(getTabs(t)).append("else\n");
            sb.append(elsePart.toString(t + 0));
        }

        return sb.toString();
    }
}

