/**
 * MethodDecl.java
 * Represents a method declaration with return type, parameters, local variables, and body
 * Examples:
 *   float pythag(float vals[]) { ... }
 *   void main() { ... }
 *   int add(int a, int b) { ... }
 */
public class MethodDecl extends Token {
    private Type returnType;        // null if void method
    private boolean isVoid;
    private String name;
    private ParamList params;
    private FieldDeclList localVars;
    private StmtList body;
    
    /**
     * Constructor for method with return type
     * @param returnType The return type of the method
     * @param name The name of the method
     * @param params The parameter list (can be empty)
     * @param localVars The local variable declarations (can be empty)
     * @param body The statement list for the method body
     */
    public MethodDecl(Type returnType, String name, ParamList params, 
                      FieldDeclList localVars, StmtList body) {
        this.returnType = returnType;
        this.isVoid = false;
        this.name = name;
        this.params = params;
        this.localVars = localVars;
        this.body = body;
    }
    
    /**
     * Constructor for void method
     * @param name The name of the method
     * @param params The parameter list (can be empty)
     * @param localVars The local variable declarations (can be empty)
     * @param body The statement list for the method body
     */
    public MethodDecl(String name, ParamList params, 
                      FieldDeclList localVars, StmtList body) {
        this.returnType = null;
        this.isVoid = true;
        this.name = name;
        this.params = params;
        this.localVars = localVars;
        this.body = body;
    }
    
    /**
     * Get the return type
     * @return The Type object, or null if void
     */
    public Type getReturnType() {
        return returnType;
    }
    
    /**
     * Check if this is a void method
     * @return True if void, false otherwise
     */
    public boolean isVoid() {
        return isVoid;
    }
    
    /**
     * Get the method name
     * @return The method name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the parameter list
     * @return The ParamList
     */
    public ParamList getParams() {
        return params;
    }
    
    /**
     * Get the local variable declarations
     * @return The FieldDeclList for local variables
     */
    public FieldDeclList getLocalVars() {
        return localVars;
    }
    
    /**
     * Get the method body
     * @return The StmtList for the body
     */
    public StmtList getBody() {
        return body;
    }
    
    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        
        // Method signature line
        sb.append(getTabs(t));
        
        // Return type or void
        if (isVoid) {
            sb.append("void");
        } else {
            sb.append(returnType.toString(0));
        }
        
        // Method name
        sb.append(" ").append(name);
        
        // Parameters
        sb.append("(");
        if (params != null && !params.isEmpty()) {
            sb.append(params.toString(0));
        }
        sb.append(")\n");
        
        // Method body opening brace
        sb.append(getTabs(t)).append("{\n");
        
        // Local variable declarations (indented)
        if (localVars != null && !localVars.isEmpty()) {
            sb.append(localVars.toString(t + 1));
        }
        
        // Statements (indented)
        if (body != null) {
            sb.append(body.toString(t + 1));
        }
        
        // Method body closing brace
        sb.append(getTabs(t)).append("}\n");
        
        return sb.toString();
    }
}
