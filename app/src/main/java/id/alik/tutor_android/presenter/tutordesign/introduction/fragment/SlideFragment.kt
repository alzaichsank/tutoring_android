package id.alik.tutor_android.presenter.tutordesign.introduction.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.alik.tutor_android.base.makeGone
import id.alik.tutor_android.base.makeVisible
import id.alik.tutor_android.databinding.FragmentSlideBinding
import id.alik.tutor_android.presenter.tutordesign.introduction.adapter.IntroductionAdapter

class SlideFragment : Fragment() {
    private var mPage: Int = 0
    private val view: FragmentSlideBinding by lazy {
        FragmentSlideBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!requireArguments().containsKey(PAGE))
            throw RuntimeException("Fragment must contain a \"$PAGE\" argument!")
        mPage = requireArguments().getInt(PAGE)
        Log.d("cek", "onCreate: PAGE > $PAGE")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return setUpView()
    }

    private fun setUpView(): View {
        return when (mPage) {
            IntroductionAdapter.FIRST -> {
                view.apply {
                    introductionOne.root.makeVisible()
                    introductionTwo.root.makeGone()
                    introductionThree.root.makeGone()
                }.root
            }
            IntroductionAdapter.SECOND -> {
                view.apply {
                    introductionOne.root.makeGone()
                    introductionTwo.root.makeVisible()
                    introductionThree.root.makeGone()
                }.root
            }
            IntroductionAdapter.LAST -> {
                view.apply {
                    introductionOne.root.makeGone()
                    introductionTwo.root.makeGone()
                    introductionThree.root.makeVisible()
                }.root
            }
            else -> {
                view.apply {
                    introductionOne.root.makeVisible()
                    introductionTwo.root.makeGone()
                    introductionThree.root.makeGone()
                }.root
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