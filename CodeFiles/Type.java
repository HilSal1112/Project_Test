/**
 * Type.java
 * Represents a type in the language: int, float, char, bool
 * Used in field declarations, method return types, parameters, and local variables
 */
public class Type extends Token {
    private String typeName; // "int", "float", "char", "bool"
    
    /**
     * Constructor for Type
     * @param typeName The name of the type (int, float, char, or bool)
     */
    public Type(String typeName) {
        this.typeName = typeName;
    }
    
    /**
     * Get the type name
     * @return The type name as a string
     */
    public String getTypeName() {
        return typeName;
    }
    
    @Override
    public String toString(int t) {
        return typeName;
    }
}
