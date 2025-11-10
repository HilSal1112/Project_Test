/**
 * StringLiteral.java
 * Represents a string literal (e.g., "hello")
 */
public class StringLiteral extends Expr {
    private String value; // keep the quotes

    public StringLiteral(String value) {
        this.value = value;
    }

    @Override
    public String toString(int t) {
        return value;
    }
}

