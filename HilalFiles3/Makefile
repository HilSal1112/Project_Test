#------------------------------------------------------------
# CS 4386 - Compiler Design - Project 2 Phase 2
# Makefile
# Modified from Phase 1 to include Phase 2 AST classes
#------------------------------------------------------------

# Java tools
JAVA=java
JAVAC=javac

# JFlex and CUP tools
JFLEX=$(JAVA) -jar jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR):./java-cup-11b-runtime.jar

#------------------------------------------------------------
# Default target
#------------------------------------------------------------
default: run

.SUFFIXES: .java .class
.java.class:
	$(JAVAC) -cp $(CP) $*.java

#------------------------------------------------------------
# Files to compile
# PHASE 2 ADDITIONS: Type, ParamDecl, ParamList, FieldDecl,
#                    FieldDeclList, MethodDecl, MethodDeclList
#------------------------------------------------------------
FILE=Lexer.java parser.java sym.java

SRC = Token.java \
      Expr.java \
      IntLiteral.java \
      FloatLiteral.java \
      CharLiteral.java \
      StringLiteral.java \
      BoolLiteral.java \
      VarExpr.java \
      ArrayAccessExpr.java \
      BinaryExpr.java \
      UnaryExpr.java \
      TernaryExpr.java \
      CastExpr.java \
      CallExpr.java \
      Stmt.java \
      StmtList.java \
      AssignStmt.java \
      BlockStmt.java \
      IfStmt.java \
      WhileStmt.java \
      ReadStmt.java \
      PrintStmt.java \
      PrintLineStmt.java \
      ReturnStmt.java \
      CallStmt.java \
      IncStmt.java \
      DecStmt.java \
      Type.java \
      ParamDecl.java \
      ParamList.java \
      FieldDecl.java \
      FieldDeclList.java \
      MethodDecl.java \
      MethodDeclList.java \
      Program.java \
      ScannerTest.java

#------------------------------------------------------------
# Build and Run Targets
#------------------------------------------------------------

# Run all test files
run: all
	@echo "Running lexical analysis on all .txt files in directory..."
	@for file in *.txt; do \
		if [ "$$file" != "example_output.txt" ]; then \
			output="$${file%.txt}-output.txt"; \
			echo "Analyzing $$file → $$output"; \
			$(JAVA) -cp $(CP) ScannerTest $$file > $$output; \
		fi \
	done
	@echo "---------------------------------------------"
	@echo "Lexical analysis complete for all .txt files."
	@echo "---------------------------------------------"

# Compile everything
all: Lexer.java parser.java $(FILE:java=class) $(SRC:.java=.class)

#------------------------------------------------------------
# Cleanup
#------------------------------------------------------------
clean:
	rm -f *.class *~ *.bak Lexer.java parser.java sym.java *-output.txt

#------------------------------------------------------------
# File generation rules
#------------------------------------------------------------
Lexer.java: tokens.jflex
	$(JFLEX) tokens.jflex

parser.java sym.java: grammar.cup
	$(CUP) -expect 9 grammar.cup
