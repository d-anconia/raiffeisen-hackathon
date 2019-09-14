package com.github.ivanshafran.raif.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.ui.signin.SignInFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, SignInFragment.newInstance())
                .commit()
        }
    }
}
