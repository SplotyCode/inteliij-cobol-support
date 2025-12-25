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

    private fun getDefinitionType() = when (kind) {
        CobolRefKind.PARAGRAPH -> CobolParagraphHeader::class.java
        CobolRefKind.DATA_ITEM -> CobolDataDescription::class.java
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val file = myElement.containingFile as? CobolFile ?: return ResolveResult.EMPTY_ARRAY

        val targets = PsiTreeUtil.collectElementsOfType(file, getDefinitionType())
            .filter { nameOf(it) == key }

        return targets.map { PsiElementResolveResult(it) }.toTypedArray()
    }

    override fun getVariants(): Array<Any> {
        val file = myElement.containingFile as? CobolFile ?: return emptyArray()

        return PsiTreeUtil.collectElementsOfType(file, getDefinitionType()).mapNotNull { def ->
            val name = nameOf(def) ?: return@mapNotNull null
            LookupElementBuilder.create(def, name)
                .withIcon(
                    when (kind) {
                        CobolRefKind.PARAGRAPH -> AllIcons.Nodes.Function
                        CobolRefKind.DATA_ITEM -> AllIcons.Nodes.Variable
                    }
                )
                .withTypeText(def.containingFile?.name, true)
        }.toTypedArray()
    }

    private fun nameOf(element: PsiElement): String? =
        element.node.findChildByType(CobolTypes.IDENT)?.text
}
