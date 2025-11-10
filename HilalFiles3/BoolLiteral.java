/**
 * BoolLiteral.java
 * Represents: true or false
 */
public class BoolLiteral extends Expr {
    private String value; // "true" or "false"

    public BoolLiteral(String value) {
        this.value = value;
    }

    @Override
    public String toString(int t) {
        return value;
    }
}

