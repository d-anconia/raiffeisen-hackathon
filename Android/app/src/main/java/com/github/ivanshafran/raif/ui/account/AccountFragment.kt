package com.github.ivanshafran.raif.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.data.model.Transaction
import com.github.ivanshafran.raif.di.Scopes
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

    private lateinit var adapter: TransactionAdapter

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
        adapter = TransactionAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun showTranscations(transcations: List<Transaction>) {
        adapter.setTranscations(transcations)
    }
}
