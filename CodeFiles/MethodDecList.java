import java.util.ArrayList;
import java.util.List;

/**
 * MethodDeclList.java
 * Represents a list of method declarations in a class
 * Example: class Test { void foo() {...} int bar() {...} }
 * 
 * Follows the same pattern as StmtList.java
 */
public class MethodDeclList extends Token {
    private List<MethodDecl> methods;
    
    /**
     * Constructor - initializes empty method list
     */
    public MethodDeclList() {
        this.methods = new ArrayList<>();
    }
    
    /**
     * Add a method declaration to the end of the list
     * @param method The method declaration to add
     */
    public void add(MethodDecl method) {
        methods.add(method);
    }
    
    /**
     * Add a method declaration to the beginning of the list
     * Used for left-recursive grammar rules
     * @param method The method declaration to prepend
     */
    public void prepend(MethodDecl method) {
        methods.add(0, method);
    }
    
    /**
     * Check if the method list is empty
     * @return True if no methods, false otherwise
     */
    public boolean isEmpty() {
        return methods.isEmpty();
    }
    
    /**
     * Get the number of method declarations
     * @return The method count
     */
    public int size() {
        return methods.size();
    }
    
    /**
     * Convert method list to string
     * Each method on its own lines with proper indentation
     * Example output:
     *     void foo()
     *     {
     *         ...
     *     }
     *     int bar()
     *     {
     *         ...
     *     }
     * 
     * @param t Indentation level
     * @return String representation of all method declarations
     */
    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        for (MethodDecl method : methods) {
            sb.append(method.toString(t));
        }
        return sb.toString();
    }
}
