package com.github.ivanshafran.raif.ui.main

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.di.Scopes
import com.github.ivanshafran.raif.ui.account_list.AccountListFragment
import com.github.ivanshafran.raif.ui.signin.SignInFragment
import toothpick.Toothpick

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter {
        return Toothpick
            .openScope(Scopes.GLOBAL_SCOPE)
            .getInstance(MainPresenter::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun openSignIn() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, SignInFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    override fun openStartScreen() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, AccountListFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

}
