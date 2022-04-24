package id.alik.tutor_android.presenter.tutordesign.intentlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.alik.tutor_android.databinding.ActivityIntentFirstBinding
import id.alik.tutor_android.presenter.tutordesign.intentlearning.model.PersonIntent
import id.alik.tutor_android.service.NavigationService

class IntentFirstActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityIntentFirstBinding
    private var navigationService: NavigationService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityIntentFirstBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        navigationService = NavigationService()
        setUpView()
    }

    private fun setUpView() {

        with(mBinding) {
            btnIntent.setOnClickListener {
                setUpData(INTENT_EXTRA)
            }
            btnIntentBundle.setOnClickListener {
                setUpData(BUNDLE_EXTRA)
            }
            btnIntentSerializable.setOnClickListener {
                setUpData(SERIALIZABELE_EXTRA)
            }

            btnIntentParcelabel.setOnClickListener {
                setUpData(PARCELABEL_EXTRA)
            }
        }
    }

    private fun setUpData(type: String) {
        when (type) {
            INTENT_EXTRA -> {
                val person = PersonIntent(
                    nama = "Alza Ichsan Kurnaiwan",
                    email = "useremail@mail.com",
                    umur = 25,
                    domisili = "Bogor",
                    statusMenikah = true
                )
                navigationService?.showIntentSecondCase(this@IntentFirstActivity,INTENT_EXTRA,person)
            }
            BUNDLE_EXTRA -> {
                //TODO add case for bundle
            }
            SERIALIZABELE_EXTRA -> {
                //TODO add case for serializabele
            }
            PARCELABEL_EXTRA -> {
                //TODO add case for parcelable
            }
        }
    }

    companion object {
        const val INTENT_EXTRA = "intent.key"
        const val BUNDLE_EXTRA = "bundle.key"
        const val SERIALIZABELE_EXTRA = "serializabele.key"
        const val PARCELABEL_EXTRA = "parcelable.key"
    }
}