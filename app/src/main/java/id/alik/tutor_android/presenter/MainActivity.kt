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
                TUTOR_INTRO_PAGE
            )
        )
        { tutorName ->
            when (tutorName) {
                TUTOR_INTENT -> {
                    navigationService?.showIntentCase(this@MainActivity)
                }
                TUTOR_INTRO_PAGE -> {
                    //TODO : ADD intent
                }
                TUTOR_EDIT_TEXT ->{
                    //TODO : ADD intent
                }
                TUTOR_DIALOG ->{
                    //TODO : ADD intent
                }
                TUTOR_NAVIGATION_COMPONENT ->{
                    //TODO : ADD intent
                }
                TUTOR_ROOM ->{
                    //TODO : add intent implicit to the app or if not installed show the repo
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
        const val TUTOR_INTRO_PAGE = "Tutor intro Page"
        const val TUTOR_EDIT_TEXT = "Tutor Edit Text"
        const val TUTOR_NAVIGATION_COMPONENT = "Tutor navigation component"
        const val TUTOR_DIALOG = "Tutor dialog"
        const val TUTOR_ROOM = "Tutor room"
    }
}