package com.github.ivanshafran.raif.ui.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.data.model.SignInData
import com.github.ivanshafran.raif.ui.setVisible
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : MvpAppCompatFragment(), SignInView {

    companion object {
        fun newInstance(): Fragment {
            return SignInFragment()
        }
    }

    @InjectPresenter
    lateinit var presenter: SignInPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton.setOnClickListener {
            presenter.onLoginClicked(createSignInData())
        }
    }

    private fun createSignInData(): SignInData {
        return SignInData(
            loginEditText.text.toString(),
            passwordEditText.text.toString()
        )
    }

    override fun showProgressBar(shouldShow: Boolean) {
        progressBarView.setVisible(shouldShow)
    }

    override fun showError() {
    }
}
