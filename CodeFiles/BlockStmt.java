/**
 * BlockStmt.java
 * Represents a block statement: { local_vars... stmts... }
 * 
 * PHASE 1: Block contained only statements
 * PHASE 2: Block can contain local variable declarations followed by statements
 * 
 * Used in:
 *   - if/else bodies
 *   - while loop bodies
 *   - standalone blocks
 */
public class BlockStmt extends Stmt {
    private FieldDeclList localVars;
    private StmtList stmts;
    
    /**
     * Constructor for Phase 2 BlockStmt
     * @param localVars The local variable declarations (can be empty)
     * @param stmts The statement list (can be empty)
     */
    public BlockStmt(FieldDeclList localVars, StmtList stmts) {
        this.localVars = localVars;
        this.stmts = stmts;
    }
    
    /**
     * Get the local variable declarations
     * @return The FieldDeclList
     */
    public FieldDeclList getLocalVars() {
        return localVars;
    }
    
    /**
     * Get the statements
     * @return The StmtList
     */
    public StmtList getStmts() {
        return stmts;
    }
    
    /**
     * Convert block to formatted string
     * Format:
     *   {
     *       <local vars - each on own line>
     *       <statements - each on own line>
     *   }
     * 
     * Local variables are printed BEFORE statements.
     * Both are indented one level more than the opening brace.
     * 
     * @param t Indentation level for the braces
     * @return String representation of the block
     */
    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        
        // Opening brace
        sb.append(getTabs(t)).append("{\n");
        
        // Local variable declarations (if any)
        if (localVars != null && !localVars.isEmpty()) {
            sb.append(localVars.toString(t + 1));
        }
        
        // Statements (if any)
        if (stmts != null) {
            sb.append(stmts.toString(t + 1));
        }
        
        // Closing brace
        sb.append(getTabs(t)).append("}\n");
        
        return sb.toString();
    }
}
