/**
 * This is basically what im using as the base class for all AST (Abstract Syntax Tree) nodes.
 * So, every AST node must extend this class and implement toString(int t).
 */
public abstract class Token {
    
    /**
     * Need a method to generate tab characters for indentation.
     * @param t - The number of tabs to generate
     * @return A - strings containing t tab characters
     */
    protected String getTabs(int t) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
    
    /**
     * Converts the AST node to a formatted string representation.
     * @param t The indentation level (number of tabs)
     * @return String representation of this AST node
     */
    public abstract String toString(int t);
}
