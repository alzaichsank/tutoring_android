package id.alik.tutor_android.presenter.tutordesign.introduction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import id.alik.tutor_android.R
import id.alik.tutor_android.base.makeDisable
import id.alik.tutor_android.base.makeEnable
import id.alik.tutor_android.base.makeInvisible
import id.alik.tutor_android.base.makeVisible
import id.alik.tutor_android.databinding.ActivityIntroductionBinding
import id.alik.tutor_android.presenter.tutordesign.introduction.adapter.IntroductionAdapter

class IntroductionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroductionBinding
    private var adapterPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setUpView()
    }

    private fun setUpView() {
        binding.apply {
            vpSlider.apply {
                adapter = IntroductionAdapter(supportFragmentManager)
                currentItem = 0

                val viewPagerPageChangeListener: ViewPager.OnPageChangeListener =
                    object : ViewPager.OnPageChangeListener {
                        override fun onPageSelected(position: Int) {
                            adapterPosition = position
                            setViewEachPage(position)
                        }

                        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) = Unit

                        override fun onPageScrollStateChanged(arg0: Int) = Unit
                    }
                addOnPageChangeListener(viewPagerPageChangeListener)
            }
            tabIndicator.setupWithViewPager(vpSlider, true)
            btnNext.setOnClickListener {
                val isLastPage: Boolean
                val position = if (adapterPosition < IntroductionAdapter.SECOND) {
                    isLastPage = false
                    adapterPosition + 1
                } else {
                    isLastPage = true
                    adapterPosition
                }
                checkNextLogicCase(position, isLastPage)
            }
            btnBack.setOnClickListener {
                val position = if (adapterPosition > 0) {
                    adapterPosition - 1
                } else {
                    adapterPosition
                }
                vpSlider.currentItem = position
            }
        }
    }

    private fun checkNextLogicCase(position: Int, lastPage: Boolean) {
        if (lastPage) {
            //TODO : go to home or main
        } else {
            binding.vpSlider.currentItem = position
        }
    }

    private fun setViewEachPage(selectedPosition: Int) {
        binding.apply {
            when (selectedPosition) {
                IntroductionAdapter.FIRST -> {
                    btnNext.text = getString(R.string.text_btn_next)
                    btnBack.makeInvisible()
                    btnBack.makeDisable()
                }
                IntroductionAdapter.SECOND -> {
                    btnNext.text = getString(R.string.text_btn_next)
                    btnBack.makeInvisible()
                    btnBack.makeEnable()
                }
                IntroductionAdapter.LAST -> {
                    btnNext.text = getString(R.string.text_btn_finish)
                    btnBack.makeVisible()
                    btnBack.makeEnable()
                }
            }
        }
    }
}