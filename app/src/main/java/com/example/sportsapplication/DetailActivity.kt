package com.example.sportsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sportsapplication.R

class DetailActivity : AppCompatActivity() {
    private lateinit var textViewName: TextView
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewName = findViewById(R.id.textViewName)
        imageView = findViewById(R.id.imageViewDetail)

        val bundle = intent.extras
        val name = bundle?.getString("name", "")
        val url = bundle?.getString("url") ?: ""

        textViewName.text = name
        Glide.with(applicationContext)
            .load(url)
            .into(imageView)
    }
}

