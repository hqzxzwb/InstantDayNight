package instantdaynight.helper

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import instantdaynight.activity.DayNightCompatActivity
import instantdaynight.R

class DayNightCompatHelper(private val view: View) {
    private val dayNightActivity = view.context.findActivityOrNull() as? DayNightCompatActivity
    private val dayNightListener = { view.refreshDrawableState() }

    inline fun onCreateDrawableState(extraSpace: Int, superFunction: (Int) -> IntArray): IntArray {
        val isNight = isNight
        val additionalExtraSpace = if (isNight) 1 else 0
        val superResult = superFunction(extraSpace + additionalExtraSpace)
        if (isNight) {
            superResult[superResult.lastIndex - extraSpace] = R.attr.state_night
        }
        return superResult
    }

    val isNight: Boolean
        get() {
            val activity = dayNightActivity
            return activity != null && activity.isNightMode
        }

    fun onAttachedToWindow() {
        dayNightActivity?.addNightModeListener(dayNightListener)
    }

    fun onDetachedFromWindow() {
        dayNightActivity?.removeNightModeListener(dayNightListener)
    }

    private fun Context.findActivityOrNull(): Activity? {
        var c = this
        while (c is ContextWrapper) {
            if (c is Activity) {
                return c
            }
            c = c.baseContext
        }
        return null
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
