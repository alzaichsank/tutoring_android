package id.alik.tutor_android.presenter.tutordesign.intentlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.alik.tutor_android.R

class IntentSecondsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_two)
    }

    companion object {
        const val INTENT_EXTRA_NAME = "intent.key.name"
        const val INTENT_EXTRA_UMUR = "intent.key.age"
        const val INTENT_EXTRA_EMAIL = "intent.key.email"
        const val INTENT_EXTRA_DOMISILI = "intent.key.address"
        const val INTENT_EXTRA_STATUS = "intent.key.mariage"


    }
}