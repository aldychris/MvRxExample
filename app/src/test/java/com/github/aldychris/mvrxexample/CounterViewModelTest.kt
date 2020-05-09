package com.github.aldychris.mvrxexample

import com.airbnb.mvrx.test.MvRxTestRule
import com.airbnb.mvrx.withState
import org.junit.Assert.*
import org.junit.ClassRule
import org.junit.Test

class CounterViewModelTest {

    companion object {
        @JvmField
        @ClassRule
        val mvrxTestRule = MvRxTestRule()
    }

    @Test
    fun testPlus() {
        val viewModel = CounterViewModel(CounterState())
        viewModel.up()
        withState(viewModel) { state ->
            assertEquals(1, state.count)
            assertEquals(false, state.isError)
        }
    }

    @Test
    fun testMinus() {
        val viewModel = CounterViewModel(CounterState(count = 2))
        viewModel.down()
        withState(viewModel) { state ->
            assertEquals(1, state.count)
            assertEquals(false, state.isError)
        }
    }

    @Test
    fun testError() {
        val viewModel = CounterViewModel(CounterState(count = 0))
        viewModel.down()
        withState(viewModel) { state ->
            assertEquals(0, state.count)
            assertEquals(true, state.isError)
        }
    }
}