package de.scandurra.inteliijcobolsupport.psi

import com.intellij.psi.tree.IElementType
import de.scandurra.inteliijcobolsupport.CobolLanguage

class CobolTokenType(debugName: String) : IElementType(debugName, CobolLanguage) {
    override fun toString(): String = "CobolTokenType." + super.toString()
}