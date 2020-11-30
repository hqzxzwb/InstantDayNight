package instantdaynight.widget

import android.content.Context
import android.content.res.Configuration
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatRatingBar
import instantdaynight.R
import instantdaynight.helper.dayNightCompatHelper

open class DayNightCompatRatingBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.attr.ratingBarStyle
) : AppCompatRatingBar(context, attrs, defStyleAttr) {
    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        return dayNightCompatHelper.onCreateDrawableState(extraSpace) {
            super.onCreateDrawableState(it)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        dayNightCompatHelper.onConfigurationChanged(newConfig)
    }
}
