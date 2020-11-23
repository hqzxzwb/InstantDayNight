package instantdaynight.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton
import instantdaynight.R
import instantdaynight.helper.dayNightCompatHelper

open class DayNightCompatImageButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.attr.imageButtonStyle
) : AppCompatImageButton(context, attrs, defStyleAttr) {
    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        return dayNightCompatHelper.onCreateDrawableState(extraSpace) {
            super.onCreateDrawableState(it)
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        dayNightCompatHelper.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        dayNightCompatHelper.onDetachedFromWindow()
    }
}
