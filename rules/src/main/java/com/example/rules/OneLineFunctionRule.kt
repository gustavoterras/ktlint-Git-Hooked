package com.example.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class OneLineFunctionRule : Rule("one-line-function") {

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == KtStubElementTypes.FUNCTION && !node.text.contains('\n')) {
            val child = node.findChildByType(KtNodeTypes.VALUE_PARAMETER_LIST) ?: return
            if (child.treeNext.elementType == KtTokens.WHITE_SPACE && child.treeNext.treeNext.elementType == KtTokens.EQ) {
                emit(node.startOffset, "need return type!!!", false)
            }
        }
    }
}
