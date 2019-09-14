package com.github.ivanshafran.raif.ui.start_stub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.ui.account.AccountFragment
import kotlinx.android.synthetic.main.fragment_start_screen.*

class StartStubFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment {
            return StartStubFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startScreenImageView.setOnClickListener {
            openAccountScreen()
        }
    }

    private fun openAccountScreen() {
        requireFragmentManager()
            .beginTransaction()
            .replace(R.id.container, AccountFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

}
