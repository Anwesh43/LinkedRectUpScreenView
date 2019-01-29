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