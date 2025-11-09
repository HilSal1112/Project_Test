//------------------------------------------------------------
// CS 4386 - Compiler Design - Project 1
// tokens.jflex
// Hilal Salahudeen
//------------------------------------------------------------

import java_cup.runtime.*;

%%
%class Lexer
%unicode
%cup
%line
%column
%state BCOMMENT

%{
  // Constructors to generate CUP symbols with or without values
  Symbol newSym(int tokenId) {
    return new Symbol(tokenId, yyline, yycolumn);
  }
  Symbol newSym(int tokenId, Object value) {
    return new Symbol(tokenId, yyline, yycolumn, value);
  }
%}

/* ---------------- Pattern Definitions ---------------- */
digit       = [0-9]
letter      = [a-zA-Z]
id          = {letter}({letter}|{digit})*
intlit      = {digit}+
floatlit    = {digit}+\.{digit}+
charlit     = \'([^\'\\]|\\[ntr'\\])\'
/* Strings cannot contain unescaped quotes, backslashes, newlines, or tabs */
strlit      = \"([^\"\\\n\t]|\\[ntr\"\\])*\"
whitespace  = [ \t\r\n]+
/* Line comments start with double backslash */
linecomment = "\\\\"
/* Block comments use \* ... *\ syntax */
%%

/* ---------------- Ignore Whitespace & Comments ---------------- */
{whitespace}          { /* skip */ }
{linecomment}[^\n]*   { /* skip single-line comment */ }

"\\*"                 { yybegin(BCOMMENT); }
<BCOMMENT> [^*]+      { /* skip body */ }
<BCOMMENT> \*+[^\\]   { /* skip runs of * not followed by \ */ }
<BCOMMENT> "*\\"      { yybegin(YYINITIAL); }

/* ------------------- Keywords ------------------- */
"class"           { return newSym(sym.CLASS, "class"); }
"final"           { return newSym(sym.FINAL, "final"); }
"int"             { return newSym(sym.INT, "int"); }
"char"            { return newSym(sym.CHAR, "char"); }
"bool"            { return newSym(sym.BOOL, "bool"); }
"float"           { return newSym(sym.FLOAT, "float"); }
"void"            { return newSym(sym.VOID, "void"); }
"if"              { return newSym(sym.IF, "if"); }
"else"            { return newSym(sym.ELSE, "else"); }
"while"           { return newSym(sym.WHILE, "while"); }
"read"            { return newSym(sym.READ, "read"); }
"print"           { return newSym(sym.PRINT, "print"); }
"printline"       { return newSym(sym.PRINTLINE, "printline"); }
"return"          { return newSym(sym.RETURN, "return"); }
"true"            { return newSym(sym.TRUE, "true"); }
"false"           { return newSym(sym.FALSE, "false"); }

/* ------------- Operators & Symbols ------------- */
"++"              { return newSym(sym.INC, "++"); }
"--"              { return newSym(sym.DEC, "--"); }
"||"              { return newSym(sym.OR, "||"); }
"&&"              { return newSym(sym.AND, "&&"); }
"<="              { return newSym(sym.LE, "<="); }
">="              { return newSym(sym.GE, ">="); }
"=="              { return newSym(sym.EQEQ, "=="); }
"<>"              { return newSym(sym.NE, "<>"); }

"<"               { return newSym(sym.LT, "<"); }
">"               { return newSym(sym.GT, ">"); }
"="               { return newSym(sym.EQ, "="); }
"+"               { return newSym(sym.PLUS, "+"); }
"-"               { return newSym(sym.MINUS, "-"); }
"*"               { return newSym(sym.MULT, "*"); }
"/"               { return newSym(sym.DIV, "/"); }
"~"               { return newSym(sym.NOT, "~"); }
"?"               { return newSym(sym.QMARK, "?"); }
":"               { return newSym(sym.COLON, ":"); }
";"               { return newSym(sym.SEMI, ";"); }
","               { return newSym(sym.COMMA, ","); }
"("               { return newSym(sym.LPAREN, "("); }
")"               { return newSym(sym.RPAREN, ")"); }
"["               { return newSym(sym.LBRACKET, "["); }
"]"               { return newSym(sym.RBRACKET, "]"); }
"{"               { return newSym(sym.LBRACE, "{"); }
"}"               { return newSym(sym.RBRACE, "}"); }

/* ---------------- Identifiers & Literals ---------------- */
{id}              { return newSym(sym.ID, yytext()); }
{intlit}          { return newSym(sym.INTLIT, yytext()); }
{floatlit}        { return newSym(sym.FLOATLIT, yytext()); }
{charlit}         { return newSym(sym.CHARLIT, yytext()); }
{strlit}          { return newSym(sym.STRLIT, yytext()); }

/* ------------------- Error Handling ------------------- */
.                 {
                    System.err.println(
                      "Illegal char, '" + yytext() +
                      "' line: " + yyline + ", column: " + yycolumn
                    );
                    return newSym(sym.ERROR, yytext());
                  }

