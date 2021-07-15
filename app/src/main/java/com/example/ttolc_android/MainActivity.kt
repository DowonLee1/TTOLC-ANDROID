package com.example.ttolc_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FillEventHistory
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf<Image>(
            Image(R.drawable.img1),
            Image(R.drawable.img1),
            Image(R.drawable.img1),
            Image(R.drawable.img1)
        )
        val recyclerView = findViewById<RecyclerView>(R.id.mainSection)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, images)

    }
}