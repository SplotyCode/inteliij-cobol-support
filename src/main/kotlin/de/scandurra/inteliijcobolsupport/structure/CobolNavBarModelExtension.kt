package de.scandurra.inteliijcobolsupport.structure

import com.intellij.icons.AllIcons
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension
import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import de.scandurra.inteliijcobolsupport.CobolLanguage
import de.scandurra.inteliijcobolsupport.psi.*
import javax.swing.Icon

class CobolNavBarModelExtension : StructureAwareNavBarModelExtension() {
    override val language: Language = CobolLanguage

    override fun getPresentableText(obj: Any?): String? {
        return when (obj) {
            is CobolFile -> obj.name
            is CobolProgramIdLine -> firstIdentText(obj)?.let { "PROGRAM $it" } ?: "PROGRAM"
            is CobolParagraphHeader -> firstIdentText(obj) ?: obj.text
            is CobolDataDescription -> firstIdentText(obj) ?: obj.text
            else -> null
        }
    }

    override fun getIcon(obj: Any?): Icon? {
        return when (obj) {
            is CobolFile -> AllIcons.FileTypes.Text
            is CobolProgramIdLine -> AllIcons.Nodes.Module
            is CobolParagraphHeader -> AllIcons.Nodes.Function
            is CobolDataDescription -> AllIcons.Nodes.Variable
            else -> null
        }
    }

    private fun firstIdentText(element: PsiElement): String? {
        val node = element.node.findChildByType(CobolTypes.IDENT) ?: return null
        return node.text
    }
}
