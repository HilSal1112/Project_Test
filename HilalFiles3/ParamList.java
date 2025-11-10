import java.util.ArrayList;
import java.util.List;

/**
 * ParamList.java
 * Represents a list of parameter declarations in a method
 * Used in method signatures like: void foo(int x, float arr[])
 * 
 * Follows the same pattern as StmtList.java
 */
public class ParamList extends Token {
    private List<ParamDecl> params;
    
    /**
     * Constructor - initializes empty parameter list
     */
    public ParamList() {
        this.params = new ArrayList<>();
    }
    
    /**
     * Add a parameter to the end of the list
     * @param param The parameter to add
     */
    public void add(ParamDecl param) {
        params.add(param);
    }
    
    /**
     * Add a parameter to the beginning of the list
     * Used for left-recursive grammar rules
     * @param param The parameter to prepend
     */
    public void prepend(ParamDecl param) {
        params.add(0, param);
    }
    
    /**
     * Check if the parameter list is empty
     * @return True if no parameters, false otherwise
     */
    public boolean isEmpty() {
        return params.isEmpty();
    }
    
    /**
     * Get the number of parameters
     * @return The parameter count
     */
    public int size() {
        return params.size();
    }
    
    /**
     * Convert parameter list to string
     * Format: comma-separated on same line (for method signatures)
     * Example: "int x, float arr[], bool flag"
     * 
     * @param t Indentation level (ignored for params - always inline)
     * @return String representation of parameters
     */
    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < params.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(params.get(i).toString(0));
        }
        return sb.toString();
    }
}
