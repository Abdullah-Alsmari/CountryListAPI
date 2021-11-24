package com.example.flaglistbyretrofitmoshi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val data: List<Data>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(data: Data){
            val title = view.findViewById<TextView>(R.id.name)
            val imageView = view.findViewById<ImageView>(R.id.flag)

            title.text = data.name

           val imageLoader = ImageLoader.Builder(view.context)
                .componentRegistry { add(SvgDecoder(view.context)) }
                .build()

            val request = ImageRequest.Builder(view.context)
                .crossfade(true)
                .crossfade(500)
                .data(data.flag)
                .target(imageView)
                .build()

            imageLoader.enqueue(request)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data.get(position))
    }


}
