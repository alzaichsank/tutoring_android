package id.alik.tutor_android.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.alik.tutor_android.databinding.ActivityMainBinding
import id.alik.tutor_android.presenter.adapter.DemoListAdapter
import id.alik.tutor_android.service.NavigationService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var navigationService: NavigationService? = null
    lateinit var demoListAdapter: DemoListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigationService = NavigationService()
        setUpView()
    }

    private fun setUpView() {
        demoListAdapter = DemoListAdapter(
            arrayListOf(
                TUTOR_INTENT,
                TUTOR_VIEW_PAGER
            )
        )
        { tutorName ->
            when (tutorName) {
                TUTOR_INTENT -> {
                    navigationService?.showIntentCase(this@MainActivity)
                }
                TUTOR_VIEW_PAGER -> {
                    //TODO : ADD intent
                }
            }
        }

        with(binding.rvDemoList) {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter = demoListAdapter
        }
    }

    private companion object {
        const val TUTOR_INTENT = "Tutor Intent"
        const val TUTOR_VIEW_PAGER = "Tutor View Pager"
    }
}