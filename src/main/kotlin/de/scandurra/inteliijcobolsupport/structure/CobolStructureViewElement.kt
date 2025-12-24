package de.scandurra.inteliijcobolsupport.structure

import com.intellij.icons.AllIcons
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import de.scandurra.inteliijcobolsupport.psi.*
import javax.swing.Icon

class CobolStructureViewElement(element: PsiElement) : PsiTreeElementBase<PsiElement>(element) {

    override fun getPresentableText(): String? {
        val el = element ?: return null
        return when (el) {
            is CobolFile -> el.name
            is CobolProgramIdLine -> "PROGRAM ${firstIdentText(el) ?: el.text}"
            is CobolParagraphHeader -> firstIdentText(el) ?: el.text
            is CobolDataDescription -> firstIdentText(el) ?: el.text
            else -> el.text
        }
    }

    override fun getIcon(open: Boolean): Icon? {
        val el = element ?: return null
        return when (el) {
            is CobolFile -> AllIcons.FileTypes.Text
            is CobolProgramIdLine -> AllIcons.Nodes.Module
            is CobolParagraphHeader -> AllIcons.Nodes.Function
            is CobolDataDescription -> AllIcons.Nodes.Variable
            else -> null
        }
    }

    override fun getChildrenBase(): Collection<StructureViewTreeElement> {
        val el = element ?: return emptyList()
        if (el is CobolFile) {
            val program = PsiTreeUtil.findChildOfType(el, CobolProgramIdLine::class.java)
            if (program != null) return listOf(CobolStructureViewElement(program))
            return collectParagraphsAndData(el)
        }
        if (el is CobolProgramIdLine) {
            val file = el.containingFile as? CobolFile ?: return emptyList()
            return collectParagraphsAndData(file)
        }
        return emptyList()
    }

    override fun getPresentation(): ItemPresentation = super.getPresentation()

    private fun collectParagraphsAndData(file: CobolFile): List<StructureViewTreeElement> {
        val paragraphs = PsiTreeUtil.collectElementsOfType(file, CobolParagraphHeader::class.java)
            .sortedBy { it.textOffset }
            .map { CobolStructureViewElement(it) }

        val dataItems = PsiTreeUtil.collectElementsOfType(file, CobolDataDescription::class.java)
            .sortedBy { it.textOffset }
            .map { CobolStructureViewElement(it) }

        return paragraphs + dataItems
    }

    private fun firstIdentText(el: PsiElement): String? {
        val node = el.node.findChildByType(CobolTypes.IDENT) ?: return null
        return node.text
    }
}
