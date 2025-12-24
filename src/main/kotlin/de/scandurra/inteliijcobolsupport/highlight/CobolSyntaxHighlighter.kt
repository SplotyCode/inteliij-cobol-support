package de.scandurra.inteliijcobolsupport.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import de.scandurra.inteliijcobolsupport.CobolLexerAdapter
import de.scandurra.inteliijcobolsupport.psi.CobolTypes

object CobolSyntaxHighlighter : SyntaxHighlighterBase() {
    val KEYWORD: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("COBOL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)

    val IDENTIFIER: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("COBOL_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)

    val NUMBER: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("COBOL_NUMBER", DefaultLanguageHighlighterColors.NUMBER)

    val STRING: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("COBOL_STRING", DefaultLanguageHighlighterColors.STRING)

    val OPERATOR: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("COBOL_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)

    val PUNCTUATION: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("COBOL_PUNCTUATION", DefaultLanguageHighlighterColors.DOT)

    val LINE_NUMBER: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("COBOL_LINE_NUMBER", DefaultLanguageHighlighterColors.METADATA)

    val BAD_CHARACTER: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("COBOL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

    private val EMPTY_KEYS = emptyArray<TextAttributesKey>()

    private fun keys(vararg k: TextAttributesKey) = arrayOf(*k)

    private val KEYWORD_TOKENS = setOf<IElementType>(
        CobolTypes.IDENTIFICATION,
        CobolTypes.DIVISION,
        CobolTypes.PROGRAM_ID,
        CobolTypes.DATA,
        CobolTypes.WORKING_STORAGE,
        CobolTypes.SECTION,
        CobolTypes.PROCEDURE,
        CobolTypes.PIC,
        CobolTypes.PICTURE,
        CobolTypes.VALUE,
        CobolTypes.PERFORM,
        CobolTypes.VARYING,
        CobolTypes.FROM,
        CobolTypes.BY,
        CobolTypes.UNTIL,
        CobolTypes.STOP,
        CobolTypes.RUN,
        CobolTypes.DISPLAY,
    )

    override fun getHighlightingLexer(): Lexer = CobolLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            in KEYWORD_TOKENS -> keys(KEYWORD)
            CobolTypes.IDENT -> keys(IDENTIFIER)
            CobolTypes.NUMBER -> keys(NUMBER)
            CobolTypes.STRING -> keys(STRING)
            CobolTypes.LINE_NUMBER -> keys(LINE_NUMBER)
            CobolTypes.EQ -> keys(OPERATOR)
            CobolTypes.DOT, CobolTypes.LPAREN, CobolTypes.RPAREN -> keys(PUNCTUATION)
            TokenType.BAD_CHARACTER -> keys(BAD_CHARACTER)
            else -> EMPTY_KEYS
        }
    }
}
