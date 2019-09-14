package com.github.ivanshafran.raif.ui.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.data.model.SignInArgs
import com.github.ivanshafran.raif.di.Scopes
import com.github.ivanshafran.raif.ui.account_list.AccountListFragment
import com.github.ivanshafran.raif.ui.setVisible
import kotlinx.android.synthetic.main.fragment_sign_in.*
import toothpick.Toothpick

class SignInFragment : MvpAppCompatFragment(), SignInView {

    companion object {
        fun newInstance(): Fragment {
            return SignInFragment()
        }
    }

    @InjectPresenter
    lateinit var presenter: SignInPresenter

    @ProvidePresenter
    fun providePresenter(): SignInPresenter {
        return Toothpick
            .openScope(Scopes.GLOBAL_SCOPE)
            .getInstance(SignInPresenter::class.java)
    }

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

    private fun createSignInData(): SignInArgs {
        return SignInArgs(
            loginEditText.text.toString(),
            passwordEditText.text.toString()
        )
    }

    override fun showProgressBar(shouldShow: Boolean) {
        progressBarView.setVisible(shouldShow)
        loginButton.isEnabled = !shouldShow
        loginEditText.isEnabled = !shouldShow
        passwordEditText.isEnabled = !shouldShow
    }

    override fun openStartScreen() {
        requireFragmentManager()
            .beginTransaction()
            .remove(this)
            .commit()

        requireFragmentManager()
            .beginTransaction()
            .replace(R.id.container, AccountListFragment.newInstance())
            .commit()
    }

    override fun showError() {
    }
}
