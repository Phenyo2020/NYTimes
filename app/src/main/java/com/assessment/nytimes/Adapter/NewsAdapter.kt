package com.assessment.nytimes.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assessment.nytimes.Model.Result
import com.bumptech.glide.Glide
import com.assessment.nytimes.Listener.Listener
import com.assessment.nytimes.R

class NewsAdapter (private val context: Context, private var newsList:ArrayList<Result>, private val listener:Listener) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))

    override fun getItemCount(): Int =newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news=newsList[position]
        holder.title.text=news.title
        holder.content.text=news.abstract
        holder.publishedDate.text=news.publishedDate
        holder.mokwadi.text=news.byline
        Glide.with(context)
            .load(news.media)
            .into(holder.image)
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val image: ImageView =itemView.findViewById(R.id.image)
        val title: TextView =itemView.findViewById(R.id.title)
        val content:TextView=itemView.findViewById(R.id.content)
        val publishedDate:TextView=itemView.findViewById(R.id.publishedDate)
        val mokwadi:TextView=itemView.findViewById(R.id.mokwadi)
        init {
            itemView.setOnClickListener {
                listener.onItemClickListener(adapterPosition)
            }
        }
    }

    fun setData(newsList: ArrayList<Result>)
    {
        this.newsList=newsList
        notifyDataSetChanged()
    }
}