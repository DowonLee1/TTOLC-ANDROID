package com.example.ttolc_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SectionAdapter(private val sectionList : ArrayList<SermonSection>) : RecyclerView.Adapter<SectionAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.section_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return sectionList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = sectionList[position]

        holder.firstName.text = currentitem.sectionTitle
        holder.lastName.text = currentitem.detailSection


    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val firstName : TextView = itemView.findViewById(R.id.firstName)
        val lastName: TextView = itemView.findViewById(R.id.lastName)
    }

}