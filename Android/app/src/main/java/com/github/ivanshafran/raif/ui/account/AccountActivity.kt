package com.github.ivanshafran.raif.ui.account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.data.model.Account
import com.github.ivanshafran.raif.di.Scopes
import com.github.ivanshafran.raif.ui.history.HistoryFragment
import kotlinx.android.synthetic.main.activity_account.*
import toothpick.Toothpick

class AccountActivity : MvpAppCompatActivity(), AccountView {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, AccountActivity::class.java)
        }
    }

    @InjectPresenter
    lateinit var presenter: AccountPresenter

    @ProvidePresenter
    fun providePresenter(): AccountPresenter {
        return Toothpick
            .openScope(Scopes.GLOBAL_SCOPE)
            .getInstance(AccountPresenter::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        backArrowButton.setOnClickListener { finish() }
    }

    override fun showScreen(screen: AccountView.Screen) {
        when (screen) {
            AccountView.Screen.INFO -> {
                tabLayout.getTabAt(0)?.select()
            }
            AccountView.Screen.HISTORY -> {
                tabLayout.getTabAt(1)?.select()
                showFragment(HistoryFragment.newInstance())
            }
            AccountView.Screen.TAX -> {
                tabLayout.getTabAt(2)?.select()
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.accountContainer, fragment)
            .commit()
    }

    override fun showAccount(account: Account) {
        cardNameTextView.text = account.cardName
        val balance = getString(R.string.rub, account.balance.toString())
        balanceTextView.text = balance
    }
}
