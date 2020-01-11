package com.ikhsan.submission2expertkt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ikhsan.submission2expertkt.R
import com.ikhsan.submission2expertkt.model.TvShow
import kotlinx.android.synthetic.main.item_tv_show.view.*

class TvShowAdapter(private val listTvShow: ArrayList<TvShow>, val clickListener: (TvShow) -> Unit) : RecyclerView.Adapter<TvShowAdapter.TvShowHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): TvShowHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_tv_show, viewGroup, false)
        return TvShowHolder(view)
    }

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: TvShowHolder, i: Int) {
        holder.bind(listTvShow[i],clickListener)
    }

    inner class TvShowHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShow, clickListener: (TvShow) -> Unit){
            with(itemView){
                Glide.with(itemView.context)
                    .load(tvShow.poster)
                    .apply(RequestOptions().override(350,550))
                    .into(img_poster)

                txt_title.text = tvShow.title
                txt_releaseDate.text = tvShow.releaseDate
                txt_overview.text = tvShow.overview

                itemView.setOnClickListener{clickListener(tvShow)}
            }
        }

    }
}