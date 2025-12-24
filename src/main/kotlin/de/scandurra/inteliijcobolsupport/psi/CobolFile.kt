package de.scandurra.inteliijcobolsupport.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import de.scandurra.inteliijcobolsupport.CobolFileType
import de.scandurra.inteliijcobolsupport.CobolLanguage

class CobolFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, CobolLanguage) {
    override fun getFileType(): FileType = CobolFileType
    override fun toString(): String = "COBOL File"
}
