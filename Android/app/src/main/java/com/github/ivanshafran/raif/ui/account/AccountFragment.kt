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
import com.github.ivanshafran.raif.data.model.RevenueInfo
import com.github.ivanshafran.raif.di.Scopes
import com.github.ivanshafran.raif.ui.history.HistoryFragment
import com.github.ivanshafran.raif.ui.info.InfoFragment
import com.github.ivanshafran.raif.ui.tax.TaxFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_account.*
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
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backArrowButton.setOnClickListener {
            requireFragmentManager().popBackStack()
        }
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                presenter.onTabSelected(tab.position)
            }
        })
    }

    override fun showScreen(screen: AccountView.Screen) {
        when (screen) {
            AccountView.Screen.INFO -> {
                tabLayout.getTabAt(0)?.select()
                showFragment(InfoFragment.newInstance())
            }
            AccountView.Screen.HISTORY -> {
                tabLayout.getTabAt(1)?.select()
                showFragment(HistoryFragment.newInstance())
            }
            AccountView.Screen.TAX -> {
                tabLayout.getTabAt(2)?.select()
                showFragment(TaxFragment.newInstance())
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

    override fun showRevenue(revenue: RevenueInfo) {
        monthMoneyValue.text = requireContext().getString(R.string.rub, revenue.monthValue)
        monthMoneyTextView.text =
            requireContext().getString(R.string.month_money, revenue.monthName)
        yearMoneyRange.text =
            requireContext().getString(R.string.year_money_description, revenue.yearToDate)
        yearMoneyValue.text = requireContext().getString(R.string.rub, revenue.yearValue)
        taxValue.text = requireContext().getString(R.string.tax_draft, revenue.taxValue)
    }
}
