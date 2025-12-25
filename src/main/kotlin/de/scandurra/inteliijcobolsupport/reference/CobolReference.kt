package de.scandurra.inteliijcobolsupport.reference

import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.ResolveResult
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.PsiPolyVariantReferenceBase
import de.scandurra.inteliijcobolsupport.psi.*

enum class CobolRefKind { PARAGRAPH, DATA_ITEM }

class CobolReference(
    element: PsiElement,
    private val kind: CobolRefKind
) : PsiPolyVariantReferenceBase<PsiElement>(
    element,
    TextRange(0, element.textLength),
    false
) {
    private val key: String = element.text

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val file = myElement.containingFile as? CobolFile ?: return ResolveResult.EMPTY_ARRAY

        val targets: List<PsiElement> = when (kind) {
            CobolRefKind.PARAGRAPH -> {
                PsiTreeUtil.collectElementsOfType(file, CobolParagraphHeader::class.java)
                    .filter { nameOf(it) == key }
                    .map { it as PsiElement }
            }
            CobolRefKind.DATA_ITEM -> {
                PsiTreeUtil.collectElementsOfType(file, CobolDataDescription::class.java)
                    .filter { nameOf(it) == key }
                    .map { it as PsiElement }
            }
        }

        return targets.map { PsiElementResolveResult(it) }.toTypedArray()
    }

    override fun getVariants(): Array<Any> {
        val file = myElement.containingFile as? CobolFile ?: return emptyArray()

        val defs: Collection<PsiElement> = when (kind) {
            CobolRefKind.PARAGRAPH -> PsiTreeUtil.collectElementsOfType(file, CobolParagraphHeader::class.java)
            CobolRefKind.DATA_ITEM -> PsiTreeUtil.collectElementsOfType(file, CobolDataDescription::class.java)
        }.map { it as PsiElement }

        return defs.mapNotNull { def ->
            val n = nameOf(def) ?: return@mapNotNull null
            LookupElementBuilder.create(def, n)
                .withIcon(
                    when (kind) {
                        CobolRefKind.PARAGRAPH -> AllIcons.Nodes.Function
                        CobolRefKind.DATA_ITEM -> AllIcons.Nodes.Variable
                    }
                )
                .withTypeText(def.containingFile?.name, true)
        }.toTypedArray()
    }

    private fun nameOf(el: PsiElement): String? =
        el.node.findChildByType(CobolTypes.IDENT)?.text
}
