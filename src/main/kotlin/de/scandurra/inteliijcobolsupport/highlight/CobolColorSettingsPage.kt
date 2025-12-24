package de.scandurra.inteliijcobolsupport.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import de.scandurra.inteliijcobolsupport.CobolIcons
import javax.swing.Icon

class CobolColorSettingsPage : ColorSettingsPage {
    private val descriptors = arrayOf(
        AttributesDescriptor("Keywords", CobolSyntaxHighlighter.Companion.KEYWORD),
        AttributesDescriptor("Identifiers", CobolSyntaxHighlighter.Companion.IDENTIFIER),
        AttributesDescriptor("Numbers", CobolSyntaxHighlighter.Companion.NUMBER),
        AttributesDescriptor("Strings", CobolSyntaxHighlighter.Companion.STRING),
        AttributesDescriptor("Operators", CobolSyntaxHighlighter.Companion.OPERATOR),
        AttributesDescriptor("Punctuation", CobolSyntaxHighlighter.Companion.PUNCTUATION),
        AttributesDescriptor("Line numbers (as code)", CobolSyntaxHighlighter.Companion.LINE_NUMBER),
        AttributesDescriptor("Bad character", CobolSyntaxHighlighter.Companion.BAD_CHARACTER),
    )

    override fun getIcon(): Icon = CobolIcons.FILE
    override fun getHighlighter() = CobolSyntaxHighlighter()

    override fun getDemoText(): String = """
01 IDENTIFICATION DIVISION.
02 PROGRAM-ID. HELLO.
03 DATA DIVISION.
04 WORKING-STORAGE SECTION.
05 01 WS-A PIC 9(2) VALUE 0.
06 PROCEDURE DIVISION.
07 A-PARA.
08 PERFORM B-PARA VARYING WS-A FROM 2 BY 2 UNTIL WS-A=12
09 STOP RUN.
10 B-PARA.
11 DISPLAY 'B-PARA ' WS-A.
12 DISPLAY 'B-PARA'.
""".trimIndent()

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? = null
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = descriptors
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
    override fun getDisplayName(): String = "COBOL"
}