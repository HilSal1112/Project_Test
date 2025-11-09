import java.util.ArrayList;
import java.util.List;

/**
 * FieldDeclList.java
 * Represents a list of field or variable declarations
 * Used in three contexts:
 *   1. Class-level fields: class Test { int x; float y; }
 *   2. Method-level local variables: void foo() { int a; float b; }
 *   3. Block-level local variables: { int temp; ... }
 * 
 * Follows the same pattern as StmtList.java
 */
public class FieldDeclList extends Token {
    private List<FieldDecl> fields;
    
    /**
     * Constructor - initializes empty field list
     */
    public FieldDeclList() {
        this.fields = new ArrayList<>();
    }
    
    /**
     * Add a field declaration to the end of the list
     * @param field The field declaration to add
     */
    public void add(FieldDecl field) {
        fields.add(field);
    }
    
    /**
     * Add a field declaration to the beginning of the list
     * Used for left-recursive grammar rules
     * @param field The field declaration to prepend
     */
    public void prepend(FieldDecl field) {
        fields.add(0, field);
    }
    
    /**
     * Check if the field list is empty
     * @return True if no fields, false otherwise
     */
    public boolean isEmpty() {
        return fields.isEmpty();
    }
    
    /**
     * Get the number of field declarations
     * @return The field count
     */
    public int size() {
        return fields.size();
    }
    
    /**
     * Convert field list to string
     * Each field on its own line with proper indentation
     * Example output:
     *     int x;
     *     float arr[10];
     *     bool flag = true;
     * 
     * @param t Indentation level
     * @return String representation of all field declarations
     */
    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        for (FieldDecl field : fields) {
            sb.append(field.toString(t));
        }
        return sb.toString();
    }
}
