package instantdaynight.activity

import android.content.res.Configuration
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.ArraySet

open class DayNightCompatActivity : AppCompatActivity {
    constructor() : super()
    @ContentView
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    private val nightModeListeners = ArraySet<() -> Unit>()
    var isNightMode = false
        private set(value) {
            if (field == value) return
            field = value
            nightModeListeners.forEach { it() }
        }

    internal fun addNightModeListener(listener: () -> Unit) {
        nightModeListeners += listener
    }

    internal fun removeNightModeListener(listener: () -> Unit) {
        nightModeListeners -= listener
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val isNightMode = when (newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> true
            else -> false
        }
        this.isNightMode = isNightMode
    }
}
