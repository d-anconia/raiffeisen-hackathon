package com.github.ivanshafran.raif.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.data.model.Account
import com.github.ivanshafran.raif.di.Scopes
import com.github.ivanshafran.raif.ui.history.HistoryFragment
import kotlinx.android.synthetic.main.activity_account.*
import toothpick.Toothpick

class AccountFragment : MvpAppCompatFragment(), AccountView {

    companion object {
        fun newInstance(): Fragment {
            return AccountFragment()
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backArrowButton.setOnClickListener {
            requireFragmentManager().popBackStack()
        }
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
        requireFragmentManager()
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
