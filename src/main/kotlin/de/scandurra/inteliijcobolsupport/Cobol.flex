package de.scandurra.inteliijcobolsupport;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import de.scandurra.inteliijcobolsupport.psi.CobolTypes;

%%

%public
%class CobolLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%ignorecase

%state IN_LINE

EOL=\r\n|\r|\n
WS=[ \t\f]+
LINE_NO=[0-9][0-9]

ID=[A-Z][A-Z0-9-]*
INT=[0-9]+
SQSTRING=\'([^\'\r\n]|\'\')*\'

%%

<YYINITIAL> {EOL}+    { return TokenType.WHITE_SPACE; }
<YYINITIAL> {WS}+     { return TokenType.WHITE_SPACE; }
<YYINITIAL> {LINE_NO} { yybegin(IN_LINE); return CobolTypes.LINE_NUMBER; }
<YYINITIAL> .         { return TokenType.BAD_CHARACTER; }

<IN_LINE> {EOL}+      { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
<IN_LINE> {WS}+       { return TokenType.WHITE_SPACE; }

<IN_LINE> "."         { return CobolTypes.DOT; }
<IN_LINE> "("         { return CobolTypes.LPAREN; }
<IN_LINE> ")"         { return CobolTypes.RPAREN; }
<IN_LINE> "="         { return CobolTypes.EQ; }

<IN_LINE> "IDENTIFICATION"  { return CobolTypes.IDENTIFICATION; }
<IN_LINE> "DIVISION"        { return CobolTypes.DIVISION; }
<IN_LINE> "PROGRAM-ID"      { return CobolTypes.PROGRAM_ID; }
<IN_LINE> "DATA"            { return CobolTypes.DATA; }
<IN_LINE> "WORKING-STORAGE" { return CobolTypes.WORKING_STORAGE; }
<IN_LINE> "SECTION"         { return CobolTypes.SECTION; }
<IN_LINE> "PROCEDURE"       { return CobolTypes.PROCEDURE; }

<IN_LINE> "PIC"             { return CobolTypes.PIC; }
<IN_LINE> "PICTURE"         { return CobolTypes.PICTURE; }
<IN_LINE> "VALUE"           { return CobolTypes.VALUE; }

<IN_LINE> "PERFORM"         { return CobolTypes.PERFORM; }
<IN_LINE> "VARYING"         { return CobolTypes.VARYING; }
<IN_LINE> "FROM"            { return CobolTypes.FROM; }
<IN_LINE> "BY"              { return CobolTypes.BY; }
<IN_LINE> "UNTIL"           { return CobolTypes.UNTIL; }

<IN_LINE> "STOP"            { return CobolTypes.STOP; }
<IN_LINE> "RUN"             { return CobolTypes.RUN; }
<IN_LINE> "DISPLAY"         { return CobolTypes.DISPLAY; }

<IN_LINE> {SQSTRING}        { return CobolTypes.STRING; }
<IN_LINE> {INT}             { return CobolTypes.NUMBER; }
<IN_LINE> {ID}              { return CobolTypes.IDENT; }

<IN_LINE> .                 { return TokenType.BAD_CHARACTER; }
