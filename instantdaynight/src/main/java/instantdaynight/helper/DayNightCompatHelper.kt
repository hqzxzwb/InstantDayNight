package instantdaynight.helper

import android.content.res.Configuration
import android.view.View
import instantdaynight.R

class DayNightCompatHelper(private val view: View) {
    inline fun onCreateDrawableState(extraSpace: Int, superFunction: (Int) -> IntArray): IntArray {
        val isNight = isNight
        val additionalExtraSpace = if (isNight) 1 else 0
        val superResult = superFunction(extraSpace + additionalExtraSpace)
        if (isNight) {
            superResult[superResult.lastIndex - extraSpace] = R.attr.state_night
        }
        return superResult
    }

    var isNight: Boolean = nightModeFromConfiguration(view.resources.configuration)
        private set(value) {
            if (field == value) return
            field = value
            view.refreshDrawableState()
        }

    fun onConfigurationChanged(newConfig: Configuration) {
        isNight = nightModeFromConfiguration(newConfig)
    }

    private fun nightModeFromConfiguration(configuration: Configuration): Boolean {
        return configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }
}

val View.dayNightCompatHelper: DayNightCompatHelper
    get() {
        var result = getTag(R.id.id_tag_day_night_compat_helper) as? DayNightCompatHelper
        if (result == null) {
            result = DayNightCompatHelper(this)
            setTag(R.id.id_tag_day_night_compat_helper, result)
        }
        return result
    }
