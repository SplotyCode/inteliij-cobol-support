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

public class CobolConditionImpl extends ASTWrapperPsiElement implements CobolCondition {

  public CobolConditionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CobolVisitor visitor) {
    visitor.visitCondition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CobolVisitor) accept((CobolVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public CobolRefIdent getRefIdent() {
    return findNotNullChildByClass(CobolRefIdent.class);
  }

}
