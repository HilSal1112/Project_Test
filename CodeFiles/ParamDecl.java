/**
 * ParamDecl.java
 * Represents a single parameter declaration in a method
 * Examples: int x, float arr[]
 */
public class ParamDecl extends Token {
    private Type type;
    private String name;
    private boolean isArray;
    
    /**
     * Constructor for simple parameter (e.g., int x)
     * @param type The type of the parameter
     * @param name The name of the parameter
     */
    public ParamDecl(Type type, String name) {
        this.type = type;
        this.name = name;
        this.isArray = false;
    }
    
    /**
     * Constructor for parameter with array flag (e.g., float arr[])
     * @param type The type of the parameter
     * @param name The name of the parameter
     * @param isArray True if this is an array parameter (has [])
     */
    public ParamDecl(Type type, String name, boolean isArray) {
        this.type = type;
        this.name = name;
        this.isArray = isArray;
    }
    
    /**
     * Get the parameter type
     * @return The Type object
     */
    public Type getType() {
        return type;
    }
    
    /**
     * Get the parameter name
     * @return The parameter name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Check if this is an array parameter
     * @return True if array parameter, false otherwise
     */
    public boolean isArray() {
        return isArray;
    }
    
    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(type.toString(0));
        sb.append(" ");
        sb.append(name);
        if (isArray) {
            sb.append("[]");
        }
        return sb.toString();
    }
}
