package de.scandurra.inteliijcobolsupport.navigation

import com.intellij.navigation.ChooseByNameContributorEx
import com.intellij.navigation.NavigationItem
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.Processor
import com.intellij.util.indexing.FindSymbolParameters

class CobolChooseByNameContributor : ChooseByNameContributorEx {
    override fun processNames(
        processor: Processor<in String>,
        scope: GlobalSearchScope,
        filter: com.intellij.util.indexing.IdFilter?
    ) {
        val project = scope.project ?: return
        val names = HashSet<String>()

        for (element in CobolSymbolUtil.findAllSymbols(project, scope)) {
            val name = CobolSymbolUtil.elementName(element) ?: continue
            names += name
        }

        for (n in names) {
            if (!processor.process(n)) return
        }
    }

    override fun processElementsWithName(
        name: String,
        processor: Processor<in NavigationItem>,
        parameters: FindSymbolParameters
    ) {
        val project = parameters.project
        val scope = parameters.searchScope

        val elements = CobolSymbolUtil.findSymbolsByName(project, name, scope)
        for (el in elements) {
            val item = CobolSymbolNavigationItem(el, name)
            if (!processor.process(item)) return
        }
    }
}
