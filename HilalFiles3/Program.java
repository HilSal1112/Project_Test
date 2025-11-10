/**
 * Program.java
 * The root node of the AST for Phase 2
 * Represents a complete class with fields and methods
 * 
 * PHASE 1: Program contained just a StmtList
 * PHASE 2: Program represents: class <name> { fields... methods... }
 */
public class Program extends Token {
    private String className;
    private FieldDeclList fields;
    private MethodDeclList methods;
    
    /**
     * Constructor for Phase 2 Program
     * @param className The name of the class
     * @param fields The list of field declarations
     * @param methods The list of method declarations
     */
    public Program(String className, FieldDeclList fields, MethodDeclList methods) {
        this.className = className;
        this.fields = fields;
        this.methods = methods;
    }
    
    /**
     * Get the class name
     * @return The class name
     */
    public String getClassName() {
        return className;
    }
    
    /**
     * Get the field declarations
     * @return The FieldDeclList
     */
    public FieldDeclList getFields() {
        return fields;
    }
    
    /**
     * Get the method declarations
     * @return The MethodDeclList
     */
    public MethodDeclList getMethods() {
        return methods;
    }
    
    /**
     * Convert the program to formatted string
     * Format:
     *   class <name>
     *   {
     *       <fields - indented with 1 tab>
     *       <methods - indented with 1 tab>
     *   }
     * 
     * @param t Indentation level (always 0 for Program root)
     * @return String representation of the entire program
     */
    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        
        // Class header
        sb.append("class ").append(className).append("\n{\n");
        
        // Fields (if any)
        if (fields != null && !fields.isEmpty()) {
            sb.append(fields.toString(1));
        }
        
        // Methods (if any)
        if (methods != null && !methods.isEmpty()) {
            sb.append(methods.toString(1));
        }
        
        // Closing brace
        sb.append("}\n");
        
        return sb.toString();
    }
}
