// This is a generated file. Not intended for manual editing.
package de.scandurra.inteliijcobolsupport.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CobolLine extends PsiElement {

  @Nullable
  CobolDataDescription getDataDescription();

  @Nullable
  CobolDataDivision getDataDivision();

  @Nullable
  CobolIdentificationDivision getIdentificationDivision();

  @Nullable
  CobolParagraphHeader getParagraphHeader();

  @Nullable
  CobolProcedureDivision getProcedureDivision();

  @Nullable
  CobolProgramIdLine getProgramIdLine();

  @Nullable
  CobolStatementLine getStatementLine();

  @Nullable
  CobolWorkingStorageSection getWorkingStorageSection();

}
