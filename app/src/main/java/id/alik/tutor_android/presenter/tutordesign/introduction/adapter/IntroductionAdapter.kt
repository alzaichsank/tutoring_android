package id.alik.tutor_android.presenter.tutordesign.introduction.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.alik.tutor_android.presenter.tutordesign.introduction.fragment.SlideFragment


class IntroductionAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = listOf(
        SlideFragment.newInstance(FIRST),
        SlideFragment.newInstance(SECOND),
        SlideFragment.newInstance(LAST)
    )

    override fun getCount(): Int = fragments.count()

    override fun getItem(position: Int): Fragment {
        Log.d("cek", "onCreate: Fragment > $position")
        return fragments[position]
    }

    companion object {
        const val FIRST = 0
        const val SECOND = 1
        const val LAST = 2
    }
}