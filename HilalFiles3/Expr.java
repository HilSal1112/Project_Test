/**
 * Expr.java
 * Abstract base class for all expression AST nodes.
 * All expressions (literals, binary operations, unary operations, etc.) extend this.
 */
public abstract class Expr extends Token {
    public abstract String toString(int t);
}
