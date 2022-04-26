package id.alik.tutor_android.service

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import id.alik.tutor_android.presenter.tutordesign.intentlearning.IntentFirstActivity
import id.alik.tutor_android.presenter.tutordesign.intentlearning.IntentSecondsActivity
import id.alik.tutor_android.presenter.tutordesign.intentlearning.IntentSecondsActivity.Companion.INTENT_EXTRA_DOMISILI
import id.alik.tutor_android.presenter.tutordesign.intentlearning.IntentSecondsActivity.Companion.INTENT_EXTRA_EMAIL
import id.alik.tutor_android.presenter.tutordesign.intentlearning.IntentSecondsActivity.Companion.INTENT_EXTRA_NAME
import id.alik.tutor_android.presenter.tutordesign.intentlearning.IntentSecondsActivity.Companion.INTENT_EXTRA_STATUS
import id.alik.tutor_android.presenter.tutordesign.intentlearning.IntentSecondsActivity.Companion.INTENT_EXTRA_TYPE_INTENT
import id.alik.tutor_android.presenter.tutordesign.intentlearning.IntentSecondsActivity.Companion.INTENT_EXTRA_UMUR
import id.alik.tutor_android.presenter.tutordesign.intentlearning.model.PersonIntent
import id.alik.tutor_android.presenter.tutordesign.intentlearning.model.PersonIntentSerializable


class NavigationService {
    fun showIntentCase(context: Activity) {
        val intent = Intent(context, IntentFirstActivity::class.java)
        context.startActivity(intent)
    }

    fun showIntentSecondCase(context: Activity, type: String, data: Any) {
        val intent = Intent(context, IntentSecondsActivity::class.java).apply {
            when (type) {
                IntentFirstActivity.INTENT_EXTRA -> {
                    (data as PersonIntent).apply {
                        putExtra(INTENT_EXTRA_NAME, data.nama)
                        putExtra(INTENT_EXTRA_UMUR, data.umur)
                        putExtra(INTENT_EXTRA_EMAIL, data.email)
                        putExtra(INTENT_EXTRA_DOMISILI, data.domisili)
                        putExtra(INTENT_EXTRA_STATUS, data.statusMenikah)
                        putExtra(INTENT_EXTRA_TYPE_INTENT, type)
                    }
                }
                IntentFirstActivity.BUNDLE_EXTRA -> {
                    val bundle = Bundle()
                    (data as PersonIntent).apply {
                        bundle.apply {
                            putString(INTENT_EXTRA_NAME, data.nama)
                            putInt(INTENT_EXTRA_UMUR, data.umur)
                            putString(INTENT_EXTRA_EMAIL, data.email)
                            putString(INTENT_EXTRA_DOMISILI, data.domisili)
                            putBoolean(INTENT_EXTRA_STATUS, data.statusMenikah)
                            putExtra(INTENT_EXTRA_TYPE_INTENT, type)
                        }
                    }
                    putExtras(bundle)
                }
                IntentFirstActivity.SERIALIZABELE_EXTRA -> {
                    putExtra(INTENT_EXTRA_DATA, data as PersonIntentSerializable)
                    putExtra(INTENT_EXTRA_TYPE_INTENT, type)
                }
            }
        }
        context.startActivity(intent)
    }


    companion object {
        const val INTENT_CODE = 132
        const val INTENT_EXTRA_DATA = "intent.extra.data"
        const val INTENT_EXTRA_DATA_TWO = "intent.extra.data.two"
        const val INTENT_EXTRA_FILTER = "intent.extra.filter"
        const val INTENT_EXTRA = "intent.extra"
        const val INTENT_KEY_CREATE_ITEM = 300
    }
}