package com.github.ivanshafran.raif.ui.history

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
import com.github.ivanshafran.raif.di.Scopes
import kotlinx.android.synthetic.main.fragment_history.*
import toothpick.Toothpick

class HistoryFragment : MvpAppCompatFragment(), HistoryView {

    companion object {
        fun newInstance(): Fragment {
            return HistoryFragment()
        }
    }

    @InjectPresenter
    lateinit var presenter: HistoryPresenter

    private lateinit var adapter: TransactionAdapter

    @ProvidePresenter
    fun providePresenter(): HistoryPresenter {
        return Toothpick
            .openScope(Scopes.GLOBAL_SCOPE)
            .getInstance(HistoryPresenter::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TransactionAdapter(object : AddReceiptViewHolder.Listener {
            override fun onClick() {
                presenter.onAddReceiptClick()
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun showTranscations(transcations: List<TransactionViewModel>) {
        adapter.setTranscations(transcations)
    }

}
