package ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import util.extension.convertDPtoPX

class CustomSeparator(private val context: Context, private val attr: AttributeSet?) : View(context, attr) {
    private val paint = Paint().apply {
        color = Color.rgb(185, 185, 187)
        strokeWidth = convertDPtoPX(2f)
    }
    var startX = 0f
    var stopX = width.toFloat()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(startX, 0f, stopX, 0f, paint)
    }
}