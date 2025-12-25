// This is a generated file. Not intended for manual editing.
package de.scandurra.inteliijcobolsupport.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static de.scandurra.inteliijcobolsupport.psi.CobolTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import de.scandurra.inteliijcobolsupport.psi.*;

public class CobolLineImpl extends ASTWrapperPsiElement implements CobolLine {

  public CobolLineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CobolVisitor visitor) {
    visitor.visitLine(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CobolVisitor) accept((CobolVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CobolDataDescription getDataDescription() {
    return findChildByClass(CobolDataDescription.class);
  }

  @Override
  @Nullable
  public CobolDataDivision getDataDivision() {
    return findChildByClass(CobolDataDivision.class);
  }

  @Override
  @Nullable
  public CobolIdentificationDivision getIdentificationDivision() {
    return findChildByClass(CobolIdentificationDivision.class);
  }

  @Override
  @Nullable
  public CobolParagraphHeader getParagraphHeader() {
    return findChildByClass(CobolParagraphHeader.class);
  }

  @Override
  @Nullable
  public CobolProcedureDivision getProcedureDivision() {
    return findChildByClass(CobolProcedureDivision.class);
  }

  @Override
  @Nullable
  public CobolProgramIdLine getProgramIdLine() {
    return findChildByClass(CobolProgramIdLine.class);
  }

  @Override
  @Nullable
  public CobolSentence getSentence() {
    return findChildByClass(CobolSentence.class);
  }

  @Override
  @Nullable
  public CobolWorkingStorageSection getWorkingStorageSection() {
    return findChildByClass(CobolWorkingStorageSection.class);
  }

}
