package com.example.ttolc_android

import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
        private val context: Context,
        private val images: List<Image>
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(view:View): RecyclerView.ViewHolder(view) {
        val img = itemView.findViewById<ImageView>(R.id.image)
        fun bindView(image: Image) {
            img.setImageResource(image.imageSrc)
        }

        // RECYCLER VIEW CLICK ON LISTENER SETTUP
        init {
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                var textString = ""
                if (position == 0) {
                    textString = "ABOUT US"
                }
                else if (position == 1) {
                    textString = "MISSIONARY"
                }
                else if (position == 2) {
                    textString = "HOR BOOKS"
                }
                Toast.makeText(itemView.context, "You Clicked on item # ${textString}", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder = ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_main_section, parent, false))


    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }

}
