package com.example.ttolc_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*


class SectionActivity : AppCompatActivity() {

    private lateinit var database : DatabaseReference
    private lateinit var sectionRecyclerView: RecyclerView
    private lateinit var sectionArrayList : ArrayList<SermonSection>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section)

        sectionRecyclerView = findViewById(R.id.sectionList)
        sectionRecyclerView.layoutManager = LinearLayoutManager(this)
        sectionRecyclerView.setHasFixedSize(true)

        sectionArrayList = arrayListOf<SermonSection>()
        getData()

    }
    
    private fun getData() {

        //Database Declaration
        database = FirebaseDatabase.getInstance().getReference().child("koreanSection")
        database.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(error: DatabaseError) {
                println("ERROR is --------> " + error)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapShot in snapshot.children) {
                        val user = userSnapShot.getValue(SermonSection::class.java)
                        sectionArrayList.add(user!!)
                    }
                    sectionRecyclerView.adapter = SectionAdapter(sectionArrayList)
//                    println(sectionArrayList[0].sectionTitle)
                }
            }

        })

    }
}