package com.escodro.test

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.SemanticsMatcher

fun hasLines(lines: Int): SemanticsMatcher =
    SemanticsMatcher(
        description = "Has $lines lines"
    ) { node ->
        node.config.getOrNull(SemanticsProperties.Text)?.get(0)?.text?.lines()?.size == lines
    }
