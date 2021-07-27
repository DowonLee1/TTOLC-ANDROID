package com.example.ttolc_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.*

class SectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section)

        val text = findViewById<TextView>(R.id.textView)
        text.text = "Hi"

        var sectionArray = arrayListOf<SermonSection>()
        getData()
    }
    
    private fun getData() {
        //Database Declaration
        lateinit var database : DatabaseReference
        database = FirebaseDatabase.getInstance().getReference("User")
        database.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapShot in snapshot.children) {
                        val user = userSnapShot.getValue(SermonSection::class.java)
                    }
                }
            }

        })

    }
}