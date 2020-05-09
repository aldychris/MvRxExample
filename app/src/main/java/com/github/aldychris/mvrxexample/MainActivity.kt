package com.github.aldychris.mvrxexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.mvrx.MvRx
import com.airbnb.mvrx.MvRxViewModelConfigFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MvRx.viewModelConfigFactory = MvRxViewModelConfigFactory(applicationContext)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, MainFragment())
            .commitAllowingStateLoss()
    }
}