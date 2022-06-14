package com.escodro.core.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineDebouncer {

    private var debounceJob: Job? = null

    operator fun invoke(
        delay: Long = 500,
        coroutineScope: CoroutineScope,
        function: suspend () -> Unit
    ) {
        debounceJob?.cancel()
        debounceJob = coroutineScope.launch {
            delay(delay)
            function()
        }
    }
}
