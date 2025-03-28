package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SampleCanvas @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint= Paint()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.setColor(Color.YELLOW)
        canvas.drawPaint(paint)
        paint.setColor(Color.RED)
        canvas.drawCircle(300f,250f,200f,paint)
   paint.textSize=100f
        canvas.drawText("Circle",200f,600f,paint)
        paint.setColor(Color.BLUE)
        canvas.drawRect(100f,650f,600f,950f,paint)
        paint.textSize=100f
        canvas.drawText("Rectangle",150f,1100f,paint)
        canvas.drawLine(200f,1200f,200f,1700f,paint)
        paint.textSize=100f
        canvas.drawText("lINE",150f,1800f,paint)
    }
//onDraw


}
