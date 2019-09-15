package com.github.ivanshafran.raif.ui.add_receipt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpBottomSheetDialogFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.di.Scopes
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_add_receipt.*
import toothpick.Toothpick

class AddReceiptBottomDialogFragment : MvpBottomSheetDialogFragment(), AddReceiptView {

    companion object {
        fun newInstance(): BottomSheetDialogFragment {
            return AddReceiptBottomDialogFragment()
        }
    }

    @InjectPresenter
    lateinit var presenter: AddReceiptPresenter

    @ProvidePresenter
    fun providePresenter(): AddReceiptPresenter {
        return Toothpick
            .openScope(Scopes.GLOBAL_SCOPE)
            .getInstance(AddReceiptPresenter::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_receipt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addReceiptButton.setOnClickListener {

        }
    }

}
