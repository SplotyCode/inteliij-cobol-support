package de.scandurra.inteliijcobolsupport.structure

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import de.scandurra.inteliijcobolsupport.psi.*

class CobolStructureViewModel(
    file: CobolFile,
    editor: Editor?
) : StructureViewModelBase(file, editor, CobolStructureViewElement(file)),
    StructureViewModel.ElementInfoProvider {

    override fun getSorters(): Array<Sorter> = arrayOf(Sorter.ALPHA_SORTER)

    override fun getSuitableClasses(): Array<Class<*>> = arrayOf(
        CobolProgramIdLine::class.java,
        CobolParagraphHeader::class.java,
        CobolDataDescription::class.java,
    )

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean =
        element.value is CobolFile || element.value is CobolProgramIdLine

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean =
        element.value is CobolParagraphHeader || element.value is CobolDataDescription
}
