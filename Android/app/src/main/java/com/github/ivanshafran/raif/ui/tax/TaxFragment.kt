package com.github.ivanshafran.raif.ui.tax

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.data.model.RevenueInfo
import com.github.ivanshafran.raif.di.Scopes
import kotlinx.android.synthetic.main.fragment_tax.*
import toothpick.Toothpick

class TaxFragment : MvpAppCompatFragment(), TaxView {

    companion object {

        fun newInstance(): Fragment {
            return TaxFragment()
        }

    }

    @InjectPresenter
    lateinit var presenter: TaxPresenter

    @ProvidePresenter
    fun providePresenter(): TaxPresenter {
        return Toothpick
            .openScope(Scopes.GLOBAL_SCOPE)
            .getInstance(TaxPresenter::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tax, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun showRevenue(info: RevenueInfo) {
        taxValue.text = requireContext().getString(
            R.string.rub,
            info.taxValue
        )
        infoPayTextView.text = requireContext().getString(
            R.string.pay_tax_info,
            info.yearToDate
        )
    }
}
