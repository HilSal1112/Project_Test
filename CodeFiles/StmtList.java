/**
 * StmtList.java
 * This represents a list of statements in the AST
 */
import java.util.ArrayList;
import java.util.List;

public class StmtList extends Token {
    private List<Stmt> stmts;
    
    public StmtList() {
        this.stmts = new ArrayList<>();
    }
    
    public void add(Stmt stmt) {
        stmts.add(stmt);
    }
    
    public void prepend(Stmt stmt) {
        stmts.add(0, stmt);
    }
    
    public boolean isEmpty() {
        return stmts.isEmpty();
    }
    
    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        for (Stmt stmt : stmts) {
            sb.append(stmt.toString(t));
        }
        return sb.toString();
    }
}
