/**
 * FloatLiteral.java
 * Represents a floating-point literal
 */
public class FloatLiteral extends Expr {
    private String value;

    public FloatLiteral(String value) {
        this.value = value;
    }

    @Override
    public String toString(int t) {
        return value;
    }
}

