package id.alik.tutor_android.tutordesign.intentlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.alik.tutor_android.databinding.ActivityIntentFirstBinding

class IntentFirstActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityIntentFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityIntentFirstBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setUpView()
    }

    private fun setUpView() {
        with(mBinding) {
            btnIntent.setOnClickListener {

            }
            btnIntentBundle.setOnClickListener {

            }
            btnIntentSerializable.setOnClickListener { }

            btnIntentParcelabel.setOnClickListener {

            }


        }
    }
}