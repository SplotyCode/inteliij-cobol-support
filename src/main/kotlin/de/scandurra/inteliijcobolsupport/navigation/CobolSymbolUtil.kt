package de.scandurra.inteliijcobolsupport.navigation

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.util.PsiTreeUtil
import de.scandurra.inteliijcobolsupport.CobolFileType
import de.scandurra.inteliijcobolsupport.psi.*

object CobolSymbolUtil {
    fun elementName(el: PsiElement): String? =
        el.node.findChildByType(CobolTypes.IDENT)?.text

    fun findAllSymbols(project: Project, scope: GlobalSearchScope = GlobalSearchScope.projectScope(project)): List<PsiElement> {
        val psiManager = PsiManager.getInstance(project)
        val vFiles = FileTypeIndex.getFiles(CobolFileType, scope)

        val result = ArrayList<PsiElement>()

        for (vf in vFiles) {
            val file = psiManager.findFile(vf) as? CobolFile ?: continue

            result += PsiTreeUtil.collectElementsOfType(file, CobolProgramIdLine::class.java)
            result += PsiTreeUtil.collectElementsOfType(file, CobolParagraphHeader::class.java)
            result += PsiTreeUtil.collectElementsOfType(file, CobolDataDescription::class.java)
        }
        return result
    }

    fun findSymbolsByName(project: Project, name: String, scope: GlobalSearchScope): List<PsiElement> =
        findAllSymbols(project, scope).filter { elementName(it) == name }
}
