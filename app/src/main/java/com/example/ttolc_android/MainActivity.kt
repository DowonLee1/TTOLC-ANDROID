package com.example.ttolc_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FillEventHistory
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sermonButton = findViewById<Button>(R.id.button15);
        val buttonA = findViewById<Button>(R.id.button16)
        val buttonB = findViewById<Button>(R.id.button17)

        sermonButton.setOnClickListener {
            Toast.makeText(this, "Fade Out", Toast.LENGTH_SHORT).show()

            sermonButton.animate().apply {
                buttonB.animate().apply { this.alpha(0.0F) }.start()
            }.start()
        }

        buttonA.setOnClickListener {
            Toast.makeText(this, "Fade In", Toast.LENGTH_SHORT).show()

            buttonA.animate().apply {
                buttonB.animate().apply { this.alpha(1.0F) }.start()
            }.start()
        }

        val images = listOf<Image>(
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