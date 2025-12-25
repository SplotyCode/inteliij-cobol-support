package de.scandurra.inteliijcobolsupport.reference

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.util.ProcessingContext
import de.scandurra.inteliijcobolsupport.psi.*

class CobolReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(CobolTypes.REF_IDENT),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    return arrayOf(CobolReference(element, CobolRefKind.PARAGRAPH))
                }
            }
        )

        // DISPLAY ... <IDENT> -> data item reference
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(CobolTypes.REF_IDENT).withParent(CobolDisplayArg::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    return arrayOf(CobolReference(element, CobolRefKind.DATA_ITEM))
                }
            }
        )

        // VARYING <IDENT> -> data item reference (the loop variable)
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(CobolTypes.REF_IDENT).withParent(CobolPerformVarying::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    return arrayOf(CobolReference(element, CobolRefKind.DATA_ITEM))
                }
            }
        )

        // <IDENT> = <NUMBER> in UNTIL condition -> data item reference
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(CobolTypes.REF_IDENT).withParent(CobolCondition::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    return arrayOf(CobolReference(element, CobolRefKind.DATA_ITEM))
                }
            }
        )
    }
}
