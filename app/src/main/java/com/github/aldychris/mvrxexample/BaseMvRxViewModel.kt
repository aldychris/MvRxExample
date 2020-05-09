package com.github.aldychris.mvrxexample

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState

abstract class MvRxViewModel<T : MvRxState>(state: T) : BaseMvRxViewModel<T>(state)