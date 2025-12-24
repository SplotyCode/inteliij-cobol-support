package de.scandurra.inteliijcobolsupport

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

/* Diverged a bit from the tutorial */
/* To be more kotlin friendly, we use fieldName in the extension point */
/* See https://github.com/JetBrains/ideolog/blob/a2e078d13827d67cfff69bcd2f399e7756a147fe/src/main/kotlin/com/intellij/ideolog/fileType/LogFileType.kt */
object CobolFileType : LanguageFileType(CobolLanguage) {
    override fun getName(): String = "COBOL"

    override fun getDescription(): String = "COBOL source file"

    override fun getDefaultExtension(): String = "cob"

    override fun getIcon(): Icon = CobolIcons.iconType
}
