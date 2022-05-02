package id.alik.tutor_android.presenter.tutordesign.introduction.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.alik.tutor_android.databinding.FragmentSlideBinding
import id.alik.tutor_android.presenter.tutordesign.introduction.adapter.IntroductionAdapter

class SlideFragment : Fragment() {
    private var mPage: Int = 0
    private lateinit var binding: FragmentSlideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSlideBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        when (mPage) {
            IntroductionAdapter.FIRST -> {
                view.apply {

                }
            }
            IntroductionAdapter.SECOND -> {
                view.apply {

                }
            }
            IntroductionAdapter.LAST -> {
                view.apply {

                }
            }
        }
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