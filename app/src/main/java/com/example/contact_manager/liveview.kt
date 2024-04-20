package com.example.contact_manager

import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class liveview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_liveview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val webview=findViewById<WebView>(R.id.webview)
        web(webview)
    }
    private fun web(a:WebView){
        a.webViewClient= WebViewClient()
        a.apply {
            a.settings.javaScriptEnabled=true
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                a.settings.safeBrowsingEnabled=true
            }
            loadUrl("https://6623dfab1f63a4ef18e9cdbb--classy-salmiakki-8f71dc.netlify.app/")
        }

    }
}