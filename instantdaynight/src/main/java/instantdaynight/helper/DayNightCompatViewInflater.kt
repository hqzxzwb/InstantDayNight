package instantdaynight.helper

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatViewInflater
import androidx.appcompat.widget.*
import instantdaynight.widget.*

open class DayNightCompatViewInflater : AppCompatViewInflater() {
    override fun createAutoCompleteTextView(
        context: Context,
        attrs: AttributeSet?
    ): AppCompatAutoCompleteTextView {
        return DayNightCompatAutoCompleteTextView(context, attrs)
    }

    override fun createButton(context: Context, attrs: AttributeSet?): AppCompatButton {
        return DayNightCompatButton(context, attrs)
    }

    override fun createCheckBox(context: Context, attrs: AttributeSet?): AppCompatCheckBox {
        return DayNightCompatCheckBox(context, attrs)
    }

    override fun createCheckedTextView(
        context: Context,
        attrs: AttributeSet?
    ): AppCompatCheckedTextView {
        return DayNightCompatCheckedTextView(context, attrs)
    }

    override fun createEditText(context: Context, attrs: AttributeSet?): AppCompatEditText {
        return DayNightCompatEditText(context, attrs)
    }

    override fun createImageButton(context: Context, attrs: AttributeSet?): AppCompatImageButton {
        return DayNightCompatImageButton(context, attrs)
    }

    override fun createImageView(context: Context, attrs: AttributeSet?): AppCompatImageView {
        return DayNightCompatImageView(context, attrs)
    }

    override fun createMultiAutoCompleteTextView(
        context: Context,
        attrs: AttributeSet?
    ): AppCompatMultiAutoCompleteTextView {
        return DayNightCompatMultiAutoCompleteTextView(context, attrs)
    }

    override fun createRadioButton(context: Context, attrs: AttributeSet?): AppCompatRadioButton {
        return DayNightCompatRadioButton(context, attrs)
    }

    override fun createRatingBar(context: Context, attrs: AttributeSet?): AppCompatRatingBar {
        return DayNightCompatRatingBar(context, attrs)
    }

    override fun createSeekBar(context: Context, attrs: AttributeSet?): AppCompatSeekBar {
        return DayNightCompatSeekBar(context, attrs)
    }

    override fun createSpinner(context: Context, attrs: AttributeSet?): AppCompatSpinner {
        return DayNightCompatSpinner(context, attrs)
    }

    override fun createTextView(context: Context, attrs: AttributeSet?): AppCompatTextView {
        return DayNightCompatTextView(context, attrs)
    }

    override fun createToggleButton(
        context: Context,
        attrs: AttributeSet?
    ): AppCompatToggleButton {
        return DayNightCompatToggleButton(context, attrs)
    }

    override fun createView(context: Context, name: String?, attrs: AttributeSet?): View? {
        return when (name) {
            "View" -> DayNightCompatView(context, attrs)
            else -> super.createView(context, name, attrs)
        }
    }
}
