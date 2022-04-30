package id.alik.tutor_android.presenter.tutordesign.introduction.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.alik.tutor_android.R

class SlideFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slide, container, false)
    }

    companion object {
        private const val PAGE = "bundle.extra.page"
        fun newInstance(page: Int): SlideFragment {
            val newFragment = SlideFragment().apply {
                arguments = Bundle().apply { putInt(PAGE, page) }
            }
            return newFragment
        }
    }
}