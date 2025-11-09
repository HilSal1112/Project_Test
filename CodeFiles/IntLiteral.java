/**
 * intlit.java
 * Represents an integer literal in the AST (such as: 5, 42, 100)
 */
public class IntLiteral extends Expr {
    private String value;
    
    public IntLiteral(String value) {
        this.value = value;
    }
    
    @Override
    public String toString(int t) {
        return value;
    }
}
