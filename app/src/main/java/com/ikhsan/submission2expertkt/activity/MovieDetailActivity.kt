package com.ikhsan.submission2expertkt.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.ikhsan.submission2expertkt.R
import com.ikhsan.submission2expertkt.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.content_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    companion object{
        val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movieIntent: Movie? = intent.getParcelableExtra(EXTRA_MOVIE)

        btn_favorite.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.add_favorite) + " ${movieIntent?.title}", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        btn_watchlist.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.add_watchlist) + " ${movieIntent?.title}", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        txt_title.text = movieIntent?.title
        txt_releaseDate.text = movieIntent?.releaseDate
        txt_overview.text = movieIntent?.overview
        txt_crew.text = movieIntent?.crew
        txt_user_score.text = movieIntent?.userScore

        Glide.with(this)
            .load(movieIntent?.poster)
            .into(img_poster)

        Glide.with(this)
            .load(movieIntent?.poster)
            .into(img_poster_crop)

    }
}
