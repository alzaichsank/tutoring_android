package id.alik.tutor_android.presenter.tutordesign.introduction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import id.alik.tutor_android.databinding.ActivityIntroductionBinding

class IntroductionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroductionBinding

    private var fragmentTransaction: FragmentTransaction? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setUpView()
    }

    private fun setUpView() {
        setFragmentTransaction()
//        fragmentTransaction.add(R.id.frame_layout,SlideFragment)
    }

    private fun setFragmentTransaction() {
        val fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
    }
}