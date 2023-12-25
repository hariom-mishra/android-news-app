package com.luffyKaizoku.newsapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter( private val listener: NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {
    private val items = ArrayList<News>()

    //called first time for each views on the screen afhat it will be recycle
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        //to convert xml to view we use LayoutInflater
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    //called first time to count the items
    override fun getItemCount(): Int {
       return items.size
    }

    //binds data into viewHolder
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       val currentItem = items[position]
        holder.titleview.text = currentItem.title
        holder.author.text = currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image)
    }
    fun updateNews(updatedNews: ArrayList<News>){
       items.clear()
       items.addAll(updatedNews)

        //to update items
        notifyDataSetChanged()
    }
}

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val titleview: TextView = itemView.findViewById(R.id.title)
    val image: ImageView = itemView.findViewById(R.id.news_image)
    val author: TextView = itemView.findViewById(R.id.news_author)
}

interface NewsItemClicked{
    fun onItemClicked(item: News)
}