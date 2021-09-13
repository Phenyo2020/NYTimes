package com.assessment.nytimes.Ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.assessment.nytimes.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    private lateinit var url:String
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val bundle=intent.extras
        if(bundle != null){
            url= bundle.getString("url").toString()
        }
        webview.loadUrl(url)

    }
}