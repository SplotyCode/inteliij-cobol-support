package de.scandurra.inteliijcobolsupport

import com.intellij.lexer.FlexAdapter

class CobolLexerAdapter : FlexAdapter(CobolLexer(null))
