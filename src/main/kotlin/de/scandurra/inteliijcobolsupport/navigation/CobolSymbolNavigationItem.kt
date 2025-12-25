package de.scandurra.inteliijcobolsupport.navigation

import com.intellij.icons.AllIcons
import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.pom.Navigatable
import com.intellij.psi.PsiElement
import de.scandurra.inteliijcobolsupport.psi.CobolDataDescription
import de.scandurra.inteliijcobolsupport.psi.CobolParagraphHeader
import de.scandurra.inteliijcobolsupport.psi.CobolProgramIdLine
import javax.swing.Icon

class CobolSymbolNavigationItem(
    private val element: PsiElement,
    private val symbolName: String
) : NavigationItem {
    override fun getName(): String = symbolName

    override fun getPresentation(): ItemPresentation = object : ItemPresentation {
        override fun getPresentableText(): String = when (element) {
            is CobolProgramIdLine -> "PROGRAM $symbolName"
            is CobolParagraphHeader -> symbolName
            is CobolDataDescription -> symbolName
            else -> symbolName
        }

        override fun getLocationString(): String? = element.containingFile?.name

        override fun getIcon(unused: Boolean): Icon? = when (element) {
            is CobolProgramIdLine -> AllIcons.Nodes.Module
            is CobolParagraphHeader -> AllIcons.Nodes.Function
            is CobolDataDescription -> AllIcons.Nodes.Variable
            else -> element.getIcon(0)
        }
    }

    override fun navigate(requestFocus: Boolean) {
        (element as? Navigatable)?.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean = (element as? Navigatable)?.canNavigate() ?: false
    override fun canNavigateToSource(): Boolean = (element as? Navigatable)?.canNavigateToSource() ?: false
}
