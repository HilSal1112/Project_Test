/**
 * CharLiteral.java
 * Represents a character literal (e.g., 'a', 'z')
 */
public class CharLiteral extends Expr {
    private String value; // keep the quotes as in source

    public CharLiteral(String value) {
        this.value = value;
    }

    @Override
    public String toString(int t) {
        return value;
    }
}

