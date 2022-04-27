package id.alik.tutor_android.presenter.tutordesign.intentlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.alik.tutor_android.databinding.ActivityIntentTwoBinding
import id.alik.tutor_android.presenter.tutordesign.intentlearning.model.PersonIntentParcelable
import id.alik.tutor_android.presenter.tutordesign.intentlearning.model.PersonIntentSerializable
import id.alik.tutor_android.service.NavigationService


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
        val intent = intent
        if (intent != null) {
            when (intent.getStringExtra(INTENT_EXTRA_TYPE_INTENT)) {
                IntentFirstActivity.INTENT_EXTRA -> {
                    mappingDataIntentCase()
                }
                IntentFirstActivity.BUNDLE_EXTRA -> {
                    if (intent.extras != null) {
                        mappingDataBundleCase(intent.extras!!)
                    }
                }
                IntentFirstActivity.SERIALIZABELE_EXTRA -> {
                    mappingDataSerializableCase()
                }
                IntentFirstActivity.PARCELABEL_EXTRA -> {
                    mappingDataParcelableCase()
                }
            }
            setViewData()
        }
    }

    private fun mappingDataIntentCase() {
        setVariableData(
            nameData = intent.getStringExtra(
                INTENT_EXTRA_NAME
            ).toString(),
            ageData = intent.getIntExtra(
                INTENT_EXTRA_UMUR, 0
            ).toString(),
            emailData = intent.getStringExtra(
                INTENT_EXTRA_EMAIL
            ).toString(),
            addressData = intent.getStringExtra(
                INTENT_EXTRA_DOMISILI
            ).toString(),
            marriageStatusData = intent.getBooleanExtra(
                INTENT_EXTRA_STATUS, false
            )
        )
    }

    private fun mappingDataBundleCase(intentExtras: Bundle) {
        setVariableData(
            nameData = intentExtras.getString(
                INTENT_EXTRA_NAME,
                ""
            ),
            ageData = intentExtras.getInt(
                INTENT_EXTRA_UMUR,
                0
            ).toString(),
            emailData = intentExtras.getString(
                INTENT_EXTRA_EMAIL,
                ""
            ),
            addressData = intentExtras.getString(
                INTENT_EXTRA_DOMISILI,
                ""
            ),
            marriageStatusData = intentExtras.getBoolean(
                INTENT_EXTRA_STATUS,
                false
            )
        )
    }

    private fun mappingDataSerializableCase() {
        val data =
            intent.getSerializableExtra(NavigationService.INTENT_EXTRA_DATA) as PersonIntentSerializable
        setVariableData(
            nameData = data.nama,
            ageData = data.umur.toString(),
            emailData = data.email,
            addressData = data.domisili,
            marriageStatusData = data.statusMenikah
        )
    }

    private fun mappingDataParcelableCase() {
        val data =
            intent.getParcelableExtra<PersonIntentParcelable>(NavigationService.INTENT_EXTRA_DATA)
        if (data != null) {
            setVariableData(
                nameData = data.nama,
                ageData = data.umur.toString(),
                emailData = data.email,
                addressData = data.domisili,
                marriageStatusData = data.statusMenikah
            )
        }
    }

    private fun setVariableData(
        nameData: String,
        ageData: String,
        emailData: String,
        addressData: String,
        marriageStatusData: Boolean
    ) {
        name = "Nama : $nameData"
        age = "Umur : $ageData"
        email = "Email : $emailData"
        address = "Alamat : $addressData"
        marriageStatus = "Status Menikah : ${
            if (marriageStatusData) {
                "Sudah Menikah"
            } else {
                "Belum Menikah"
            }
        }"
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