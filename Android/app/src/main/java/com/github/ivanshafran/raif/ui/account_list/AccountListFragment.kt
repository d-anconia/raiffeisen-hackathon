package com.github.ivanshafran.raif.ui.account_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.data.model.ExchangeUsdEuro
import com.github.ivanshafran.raif.di.Scopes
import com.github.ivanshafran.raif.ui.account.AccountFragment
import kotlinx.android.synthetic.main.fragment_account_list.*
import toothpick.Toothpick

class AccountListFragment : MvpAppCompatFragment(), AccountListView {

    companion object {
        fun newInstance(): Fragment {
            return AccountListFragment()
        }
    }

    @InjectPresenter
    lateinit var presenter: AccountListPresenter

    @ProvidePresenter
    fun providePresenter(): AccountListPresenter {
        return Toothpick
            .openScope(Scopes.GLOBAL_SCOPE)
            .getInstance(AccountListPresenter::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_account_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        thirdCardLayout.setOnClickListener {
            presenter.onCardClick()
        }
    }

    override fun showExchange(exchangeUsdEuro: ExchangeUsdEuro) {
        dollarTextView.text = requireContext().getString(R.string.usd_exchange, exchangeUsdEuro.usd)
        euroTextView.text = requireContext().getString(R.string.euro_exchange, exchangeUsdEuro.euro)
    }

    override fun openAccountScreen() {
        requireFragmentManager()
            .beginTransaction()
            .replace(R.id.container, AccountFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }
}
