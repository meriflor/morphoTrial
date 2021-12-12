package com.example.morphotrial

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView


class TVOutline : AppCompatTextView {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val paint: Paint = Paint()
    private var theText: String = this.text.toString()

    override fun onDraw(canvas: Canvas) {
        val px = (canvas?.width?.div(2))
        val py = ((canvas?.height?.div(2))?.minus(((paint.descent() + paint.ascent()) / 2)))

        paint.textSize = this.textSize
        paint.typeface = this.typeface
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeWidth = 5f
        paint.color = this.currentTextColor
        paint.textAlign = Paint.Align.CENTER


        if (px != null && py != null) {
            canvas?.drawText(theText, px.toFloat(), py, paint)
        }
    }
}