package id.alik.tutor_android.service

import android.app.Activity
import android.content.Intent
import id.alik.tutor_android.presenter.tutordesign.intentlearning.IntentFirstActivity


class NavigationService {
    fun showIntentCase(context: Activity) {
        val intent = Intent(context, IntentFirstActivity::class.java)
        context.startActivity(intent)
    }

    fun showIntentSecondCase(context: Activity) {
        //TODO : add intent on this
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