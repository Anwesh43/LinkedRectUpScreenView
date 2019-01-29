package com.anwesh.uiprojects.rectupscreenview

/**
 * Created by anweshmishra on 29/01/19.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Color
import android.graphics.RectF
import android.content.Context
import android.app.Activity

val colors : Array<String> = arrayOf("#673AB7", "#01579B", "#e53935", "#00838F", "#880E4F")
val rects : Int = 4
val scGap : Float = 0.05f
val scDiv : Double = 0.51
val sizeFactor : Int = 2
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.scaleFactor() : Float = Math.floor(this / scDiv).toFloat()
fun Float.mirrorValue(a : Int, b : Int) : Float = (1 - scaleFactor()) * a.inverse() + scaleFactor() * b.inverse()
fun Float.updateValue(dir : Float, a : Int, b : Int) : Float = mirrorValue(a, b) * dir * scGap

fun Canvas.drawRect(i : Int, w : Float, h : Float, scale : Float, paint : Paint) {
    save()
    translate((i % 2) * w, (i / 2) * h)
    drawRect(RectF(0f, 0f, w * (1 - scale), h * (1 - scale)), paint )
    restore()
}

fun Canvas.drawRUSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val wSize : Float = w / sizeFactor
    val hSize : Float = h / sizeFactor
    val sc1 : Float = scale.divideScale(0, 2)
    val sc2 : Float = scale.divideScale(1, 2)
    paint.color = Color.parseColor(colors[i])
    save()
    translate(0f, h * (1 - sc1))
    for (j in (0..rects - 1)) {
        drawRect(j, wSize, hSize, sc2.divideScale(0, 2), paint)
    }
    restore()
}

class RectUpScreenView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}