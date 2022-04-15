package id.alik.tutor_android.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.alik.tutor_android.databinding.ActivityMainBinding
import id.alik.tutor_android.service.NavigationService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var navigationService: NavigationService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigationService = NavigationService()
        setUpView()
    }

    private fun setUpView() {
        with(binding) {
            btnIntent.setOnClickListener {
                navigationService?.showIntentCase(this@MainActivity)
            }
        }
    }
}