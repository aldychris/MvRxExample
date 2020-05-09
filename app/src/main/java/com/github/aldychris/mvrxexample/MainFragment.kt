package com.github.aldychris.mvrxexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: BaseMvRxFragment() {

    private val viewModel: CounterViewModel by activityViewModel(CounterViewModel::class)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPlus.clicks().subscribe {
            viewModel.up()
        }
        btnMinus.clicks().subscribe {
            viewModel.down()
        }

    }

    override fun invalidate() {
        withState(viewModel){
            if(it.isError)
                Toast.makeText(activity!!, "Minus value", Toast.LENGTH_LONG).show()

            tvCounter.text = "${it.count}"
        }
    }

}