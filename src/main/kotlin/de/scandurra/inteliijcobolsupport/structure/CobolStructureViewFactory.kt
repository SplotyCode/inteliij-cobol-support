package de.scandurra.inteliijcobolsupport.structure

import com.intellij.ide.structureView.StructureViewBuilder
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import de.scandurra.inteliijcobolsupport.psi.CobolFile

class CobolStructureViewFactory : PsiStructureViewFactory {
    override fun getStructureViewBuilder(psiFile: PsiFile): StructureViewBuilder? {
        val file = psiFile as? CobolFile ?: return null

        return object : TreeBasedStructureViewBuilder() {
            override fun createStructureViewModel(editor: Editor?) =
                CobolStructureViewModel(file, editor)
        }
    }
}
