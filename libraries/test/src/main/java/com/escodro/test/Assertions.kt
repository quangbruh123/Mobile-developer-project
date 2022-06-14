package com.escodro.test

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assert

fun SemanticsNodeInteraction.assertLines(lines: Int): SemanticsNodeInteraction =
    assert(hasLines(lines))
