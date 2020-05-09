package com.github.aldychris.mvrxexample

import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.PersistState

data class CounterState(
    @PersistState val count: Int = 0,
    val isError: Boolean = false) : MvRxState

class CounterViewModel(state: CounterState) : MvRxViewModel<CounterState>(state) {

    fun up() = setState {
        copy(count = count + 1)
    }

    fun down() = setState {
        if(count > 0 )
            copy(count = count - 1)
        else
            copy(isError = true)
    }

}