// This is a generated file. Not intended for manual editing.
package de.scandurra.inteliijcobolsupport.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static de.scandurra.inteliijcobolsupport.psi.CobolTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class CobolParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return cobolFile(b, l + 1);
  }

  /* ********************************************************** */
  // line*
  static boolean cobolFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cobolFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "cobolFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENT EQ NUMBER
  public static boolean condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENT, EQ, NUMBER);
    exit_section_(b, m, CONDITION, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER IDENT pictureClause valueClause? DOT
  public static boolean dataDescription(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataDescription")) return false;
    if (!nextTokenIs(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NUMBER, IDENT);
    r = r && pictureClause(b, l + 1);
    r = r && dataDescription_3(b, l + 1);
    r = r && consumeToken(b, DOT);
    exit_section_(b, m, DATA_DESCRIPTION, r);
    return r;
  }

  // valueClause?
  private static boolean dataDescription_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataDescription_3")) return false;
    valueClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DATA DIVISION DOT
  public static boolean dataDivision(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataDivision")) return false;
    if (!nextTokenIs(b, DATA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DATA, DIVISION, DOT);
    exit_section_(b, m, DATA_DIVISION, r);
    return r;
  }

  /* ********************************************************** */
  // STRING | IDENT
  public static boolean displayArg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "displayArg")) return false;
    if (!nextTokenIs(b, "<display arg>", IDENT, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DISPLAY_ARG, "<display arg>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, IDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DISPLAY displayArg+ DOT
  public static boolean displayStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "displayStmt")) return false;
    if (!nextTokenIs(b, DISPLAY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DISPLAY);
    r = r && displayStmt_1(b, l + 1);
    r = r && consumeToken(b, DOT);
    exit_section_(b, m, DISPLAY_STMT, r);
    return r;
  }

  // displayArg+
  private static boolean displayStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "displayStmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = displayArg(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!displayArg(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "displayStmt_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFICATION DIVISION DOT
  public static boolean identificationDivision(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identificationDivision")) return false;
    if (!nextTokenIs(b, IDENTIFICATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFICATION, DIVISION, DOT);
    exit_section_(b, m, IDENTIFICATION_DIVISION, r);
    return r;
  }

  /* ********************************************************** */
  // LINE_NUMBER lineBody
  public static boolean line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line")) return false;
    if (!nextTokenIs(b, LINE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE_NUMBER);
    r = r && lineBody(b, l + 1);
    exit_section_(b, m, LINE, r);
    return r;
  }

  /* ********************************************************** */
  // identificationDivision
  //   | programIdLine
  //   | dataDivision
  //   | workingStorageSection
  //   | dataDescription
  //   | procedureDivision
  //   | paragraphHeader
  //   | statementLine
  static boolean lineBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lineBody")) return false;
    boolean r;
    r = identificationDivision(b, l + 1);
    if (!r) r = programIdLine(b, l + 1);
    if (!r) r = dataDivision(b, l + 1);
    if (!r) r = workingStorageSection(b, l + 1);
    if (!r) r = dataDescription(b, l + 1);
    if (!r) r = procedureDivision(b, l + 1);
    if (!r) r = paragraphHeader(b, l + 1);
    if (!r) r = statementLine(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENT DOT
  public static boolean paragraphHeader(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paragraphHeader")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENT, DOT);
    exit_section_(b, m, PARAGRAPH_HEADER, r);
    return r;
  }

  /* ********************************************************** */
  // PERFORM IDENT performVarying
  public static boolean performStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "performStmt")) return false;
    if (!nextTokenIs(b, PERFORM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PERFORM, IDENT);
    r = r && performVarying(b, l + 1);
    exit_section_(b, m, PERFORM_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // VARYING IDENT FROM NUMBER BY NUMBER UNTIL condition
  public static boolean performVarying(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "performVarying")) return false;
    if (!nextTokenIs(b, VARYING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VARYING, IDENT, FROM, NUMBER, BY, NUMBER, UNTIL);
    r = r && condition(b, l + 1);
    exit_section_(b, m, PERFORM_VARYING, r);
    return r;
  }

  /* ********************************************************** */
  // (PIC | PICTURE) pictureString
  public static boolean pictureClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pictureClause")) return false;
    if (!nextTokenIs(b, "<picture clause>", PIC, PICTURE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PICTURE_CLAUSE, "<picture clause>");
    r = pictureClause_0(b, l + 1);
    r = r && pictureString(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PIC | PICTURE
  private static boolean pictureClause_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pictureClause_0")) return false;
    boolean r;
    r = consumeToken(b, PIC);
    if (!r) r = consumeToken(b, PICTURE);
    return r;
  }

  /* ********************************************************** */
  // NUMBER (LPAREN NUMBER RPAREN)?
  public static boolean pictureString(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pictureString")) return false;
    if (!nextTokenIs(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    r = r && pictureString_1(b, l + 1);
    exit_section_(b, m, PICTURE_STRING, r);
    return r;
  }

  // (LPAREN NUMBER RPAREN)?
  private static boolean pictureString_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pictureString_1")) return false;
    pictureString_1_0(b, l + 1);
    return true;
  }

  // LPAREN NUMBER RPAREN
  private static boolean pictureString_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pictureString_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LPAREN, NUMBER, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PROCEDURE DIVISION DOT
  public static boolean procedureDivision(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDivision")) return false;
    if (!nextTokenIs(b, PROCEDURE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROCEDURE, DIVISION, DOT);
    exit_section_(b, m, PROCEDURE_DIVISION, r);
    return r;
  }

  /* ********************************************************** */
  // PROGRAM_ID DOT IDENT DOT
  public static boolean programIdLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "programIdLine")) return false;
    if (!nextTokenIs(b, PROGRAM_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROGRAM_ID, DOT, IDENT, DOT);
    exit_section_(b, m, PROGRAM_ID_LINE, r);
    return r;
  }

  /* ********************************************************** */
  // performStmt | stopStmt | displayStmt
  public static boolean statementLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statementLine")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT_LINE, "<statement line>");
    r = performStmt(b, l + 1);
    if (!r) r = stopStmt(b, l + 1);
    if (!r) r = displayStmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STOP RUN DOT
  public static boolean stopStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stopStmt")) return false;
    if (!nextTokenIs(b, STOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STOP, RUN, DOT);
    exit_section_(b, m, STOP_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // VALUE NUMBER
  public static boolean valueClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueClause")) return false;
    if (!nextTokenIs(b, VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VALUE, NUMBER);
    exit_section_(b, m, VALUE_CLAUSE, r);
    return r;
  }

  /* ********************************************************** */
  // WORKING_STORAGE SECTION DOT
  public static boolean workingStorageSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workingStorageSection")) return false;
    if (!nextTokenIs(b, WORKING_STORAGE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WORKING_STORAGE, SECTION, DOT);
    exit_section_(b, m, WORKING_STORAGE_SECTION, r);
    return r;
  }

}
