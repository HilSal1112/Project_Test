/**	 
 * Stmt.java
 * base class for all statement AST nodes
 */
public abstract class Stmt extends Token {
    /**
     * statements must implement toString(int t)
     * and most statements end with a newline
     */
    public abstract String toString(int t);
}





