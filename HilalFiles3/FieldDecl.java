/**
 * FieldDecl.java
 * Represents a field declaration (class-level) or local variable declaration (method-level)
 * Examples: 
 *   int x;
 *   int arr[10];
 *   float a = vals[0];
 *   final int CONST = 5;
 */
public class FieldDecl extends Token {
    private boolean isFinal;
    private Type type;
    private String name;
    private Expr initExpr;      // For declarations like: float a = vals[0];
    private Integer arraySize;  // For declarations like: int arr[10];
    
    /**
     * Constructor for simple field/variable: int x;
     * @param type The type of the field
     * @param name The name of the field
     */
    public FieldDecl(Type type, String name) {
        this.type = type;
        this.name = name;
        this.isFinal = false;
        this.initExpr = null;
        this.arraySize = null;
    }
    
    /**
     * Constructor for array field/variable: int arr[10];
     * @param type The type of the field
     * @param name The name of the field
     * @param arraySize The size of the array (from INTLIT)
     */
    public FieldDecl(Type type, String name, int arraySize) {
        this.type = type;
        this.name = name;
        this.arraySize = arraySize;
        this.isFinal = false;
        this.initExpr = null;
    }
    
    /**
     * Constructor for field/variable with initializer: float a = vals[0];
     * @param type The type of the field
     * @param name The name of the field
     * @param initExpr The initialization expression
     */
    public FieldDecl(Type type, String name, Expr initExpr) {
        this.type = type;
        this.name = name;
        this.initExpr = initExpr;
        this.isFinal = false;
        this.arraySize = null;
    }
    
    /**
     * Constructor for final field with initializer: final int CONST = 5;
     * @param isFinal True if this is a final field
     * @param type The type of the field
     * @param name The name of the field
     * @param initExpr The initialization expression (required for final)
     */
    public FieldDecl(boolean isFinal, Type type, String name, Expr initExpr) {
        this.isFinal = isFinal;
        this.type = type;
        this.name = name;
        this.initExpr = initExpr;
        this.arraySize = null;
    }
    
    /**
     * Get the field type
     * @return The Type object
     */
    public Type getType() {
        return type;
    }
    
    /**
     * Get the field name
     * @return The field name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Check if this is a final field
     * @return True if final, false otherwise
     */
    public boolean isFinal() {
        return isFinal;
    }
    
    /**
     * Get the array size if this is an array declaration
     * @return The array size, or null if not an array
     */
    public Integer getArraySize() {
        return arraySize;
    }
    
    /**
     * Get the initialization expression if present
     * @return The init expression, or null if none
     */
    public Expr getInitExpr() {
        return initExpr;
    }
    
    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTabs(t));
        
        // Add final keyword if present
        if (isFinal) {
            sb.append("final ");
        }
        
        // Add type and name
        sb.append(type.toString(0)).append(" ").append(name);
        
        // Add array size if this is an array
        if (arraySize != null) {
            sb.append("[").append(arraySize).append("]");
        }
        
        // Add initializer if present
        if (initExpr != null) {
            sb.append(" = ").append(initExpr.toString(0));
        }
        
        sb.append(";\n");
        return sb.toString();
    }
}
