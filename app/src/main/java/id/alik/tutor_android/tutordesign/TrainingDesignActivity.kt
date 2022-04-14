package id.alik.tutor_android.tutordesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import id.alik.tutor_android.R

class TrainingDesignActivity : AppCompatActivity() {

    private var fragmentTransaction : FragmentTransaction?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training_design)
        setUpView()
    }

    private fun setUpView(){
        setFragmentTransaction()
//        fragmentTransaction.add(R.id.frame_layout,SlideFragment)
    }

    private fun setFragmentTransaction(){
        val fragmentManager = supportFragmentManager
        fragmentTransaction  = fragmentManager.beginTransaction()
    }
}