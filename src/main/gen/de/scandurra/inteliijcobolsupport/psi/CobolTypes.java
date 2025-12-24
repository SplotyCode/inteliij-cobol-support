// This is a generated file. Not intended for manual editing.
package de.scandurra.inteliijcobolsupport.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.scandurra.inteliijcobolsupport.psi.impl.*;

public interface CobolTypes {

  IElementType CONDITION = new CobolElementType("CONDITION");
  IElementType DATA_DESCRIPTION = new CobolElementType("DATA_DESCRIPTION");
  IElementType DATA_DIVISION = new CobolElementType("DATA_DIVISION");
  IElementType DISPLAY_ARG = new CobolElementType("DISPLAY_ARG");
  IElementType DISPLAY_STMT = new CobolElementType("DISPLAY_STMT");
  IElementType IDENTIFICATION_DIVISION = new CobolElementType("IDENTIFICATION_DIVISION");
  IElementType LINE = new CobolElementType("LINE");
  IElementType PARAGRAPH_HEADER = new CobolElementType("PARAGRAPH_HEADER");
  IElementType PERFORM_STMT = new CobolElementType("PERFORM_STMT");
  IElementType PERFORM_VARYING = new CobolElementType("PERFORM_VARYING");
  IElementType PICTURE_CLAUSE = new CobolElementType("PICTURE_CLAUSE");
  IElementType PICTURE_STRING = new CobolElementType("PICTURE_STRING");
  IElementType PROCEDURE_DIVISION = new CobolElementType("PROCEDURE_DIVISION");
  IElementType PROGRAM_ID_LINE = new CobolElementType("PROGRAM_ID_LINE");
  IElementType STATEMENT_LINE = new CobolElementType("STATEMENT_LINE");
  IElementType STOP_STMT = new CobolElementType("STOP_STMT");
  IElementType VALUE_CLAUSE = new CobolElementType("VALUE_CLAUSE");
  IElementType WORKING_STORAGE_SECTION = new CobolElementType("WORKING_STORAGE_SECTION");

  IElementType BY = new CobolTokenType("BY");
  IElementType DATA = new CobolTokenType("DATA");
  IElementType DISPLAY = new CobolTokenType("DISPLAY");
  IElementType DIVISION = new CobolTokenType("DIVISION");
  IElementType DOT = new CobolTokenType("DOT");
  IElementType EQ = new CobolTokenType("EQ");
  IElementType FROM = new CobolTokenType("FROM");
  IElementType IDENT = new CobolTokenType("IDENT");
  IElementType IDENTIFICATION = new CobolTokenType("IDENTIFICATION");
  IElementType LINE_NUMBER = new CobolTokenType("LINE_NUMBER");
  IElementType LPAREN = new CobolTokenType("LPAREN");
  IElementType NUMBER = new CobolTokenType("NUMBER");
  IElementType PERFORM = new CobolTokenType("PERFORM");
  IElementType PIC = new CobolTokenType("PIC");
  IElementType PICTURE = new CobolTokenType("PICTURE");
  IElementType PROCEDURE = new CobolTokenType("PROCEDURE");
  IElementType PROGRAM_ID = new CobolTokenType("PROGRAM_ID");
  IElementType RPAREN = new CobolTokenType("RPAREN");
  IElementType RUN = new CobolTokenType("RUN");
  IElementType SECTION = new CobolTokenType("SECTION");
  IElementType STOP = new CobolTokenType("STOP");
  IElementType STRING = new CobolTokenType("STRING");
  IElementType UNTIL = new CobolTokenType("UNTIL");
  IElementType VALUE = new CobolTokenType("VALUE");
  IElementType VARYING = new CobolTokenType("VARYING");
  IElementType WORKING_STORAGE = new CobolTokenType("WORKING_STORAGE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CONDITION) {
        return new CobolConditionImpl(node);
      }
      else if (type == DATA_DESCRIPTION) {
        return new CobolDataDescriptionImpl(node);
      }
      else if (type == DATA_DIVISION) {
        return new CobolDataDivisionImpl(node);
      }
      else if (type == DISPLAY_ARG) {
        return new CobolDisplayArgImpl(node);
      }
      else if (type == DISPLAY_STMT) {
        return new CobolDisplayStmtImpl(node);
      }
      else if (type == IDENTIFICATION_DIVISION) {
        return new CobolIdentificationDivisionImpl(node);
      }
      else if (type == LINE) {
        return new CobolLineImpl(node);
      }
      else if (type == PARAGRAPH_HEADER) {
        return new CobolParagraphHeaderImpl(node);
      }
      else if (type == PERFORM_STMT) {
        return new CobolPerformStmtImpl(node);
      }
      else if (type == PERFORM_VARYING) {
        return new CobolPerformVaryingImpl(node);
      }
      else if (type == PICTURE_CLAUSE) {
        return new CobolPictureClauseImpl(node);
      }
      else if (type == PICTURE_STRING) {
        return new CobolPictureStringImpl(node);
      }
      else if (type == PROCEDURE_DIVISION) {
        return new CobolProcedureDivisionImpl(node);
      }
      else if (type == PROGRAM_ID_LINE) {
        return new CobolProgramIdLineImpl(node);
      }
      else if (type == STATEMENT_LINE) {
        return new CobolStatementLineImpl(node);
      }
      else if (type == STOP_STMT) {
        return new CobolStopStmtImpl(node);
      }
      else if (type == VALUE_CLAUSE) {
        return new CobolValueClauseImpl(node);
      }
      else if (type == WORKING_STORAGE_SECTION) {
        return new CobolWorkingStorageSectionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
