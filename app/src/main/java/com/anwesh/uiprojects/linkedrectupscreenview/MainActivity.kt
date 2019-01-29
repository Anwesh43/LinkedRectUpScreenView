package com.anwesh.uiprojects.linkedrectupscreenview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.rectupscreenview.RectUpScreenView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RectUpScreenView.create(this)
    }
}
