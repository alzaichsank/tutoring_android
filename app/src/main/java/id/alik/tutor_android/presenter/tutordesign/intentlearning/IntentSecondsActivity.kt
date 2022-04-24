package id.alik.tutor_android.presenter.tutordesign.intentlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.alik.tutor_android.databinding.ActivityIntentTwoBinding


class IntentSecondsActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityIntentTwoBinding
    private var name = "-"
    private var age = "-"
    private var email = "-"
    private var address = "-"
    private var marriageStatus = "-"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityIntentTwoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        checkIntent()
    }

    private fun checkIntent() {
        with(mBinding) {
            val intentExtras = intent.extras
            if (intentExtras != null) {
                when (intentExtras.getString(INTENT_EXTRA_TYPE_INTENT)) {
                    IntentFirstActivity.INTENT_EXTRA -> {
                        "Nama : ${
                            intentExtras.getString(
                                INTENT_EXTRA_NAME,
                                ""
                            )
                        }".also { name = it }
                        "Umur : ${
                            intentExtras.getInt(
                                INTENT_EXTRA_UMUR,
                                0
                            )
                        }".also { age = it }
                        "Email : ${
                            intentExtras.getString(
                                INTENT_EXTRA_EMAIL,
                                ""
                            )
                        }".also { email = it }
                        "Alamat : ${
                            intentExtras.getString(
                                INTENT_EXTRA_DOMISILI,
                                ""
                            )
                        }".also { address = it }
                        "Status Menikah : ${
                            if (intentExtras.getBoolean(
                                    INTENT_EXTRA_STATUS,
                                    false
                                )
                            ) {
                                "Sudah Menikah"
                            } else {
                                "Belum Menikah"
                            }
                        }".also { marriageStatus = it }
                    }
                }

                setViewData()
            }
        }
    }

    private fun setViewData() {
        mBinding.apply {
            tvName.text = name
            tvAge.text = age
            tvEmail.text = email
            tvAddress.text = address
            tvMarriage.text = marriageStatus
        }
    }


    companion object {
        const val INTENT_EXTRA_NAME = "intent.key.name"
        const val INTENT_EXTRA_UMUR = "intent.key.age"
        const val INTENT_EXTRA_EMAIL = "intent.key.email"
        const val INTENT_EXTRA_DOMISILI = "intent.key.address"
        const val INTENT_EXTRA_STATUS = "intent.key.mariage"
        const val INTENT_EXTRA_TYPE_INTENT = "intent.key.type"
    }
}