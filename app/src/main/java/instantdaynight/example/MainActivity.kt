package instantdaynight.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import instantdaynight.activity.DayNightCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DayNightCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switch_compat.setOnCheckedChangeListener { _, isChecked ->
            AppCompatDelegate.setDefaultNightMode(if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}
