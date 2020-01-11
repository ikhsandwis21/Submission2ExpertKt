package com.ikhsan.submission2expertkt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ikhsan.submission2expertkt.R
import com.ikhsan.submission2expertkt.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val listMovie: ArrayList<Movie>, val clickListener: (Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MovieHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_movie, viewGroup, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieHolder, i: Int) {
        holder.bind(listMovie[i],clickListener)
    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie, clickListener: (Movie) -> Unit){
            with(itemView){
                Glide.with(itemView.context)
                    .load(movie.poster)
                    .apply(RequestOptions().override(350,550))
                    .into(img_poster)

                txt_title.text = movie.title
                txt_releaseDate.text = movie.releaseDate
                txt_overview.text = movie.overview

                itemView.setOnClickListener{clickListener(movie)}
            }
        }


    }
}