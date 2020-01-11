package com.ikhsan.submission2expertkt.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ikhsan.submission2expertkt.R
import com.ikhsan.submission2expertkt.model.TvShow
import kotlinx.android.synthetic.main.activity_tv_show_detail.*
import kotlinx.android.synthetic.main.content_tv_show_detail.*

class TvShowDetailActivity : AppCompatActivity() {

    companion object{
        val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_detail)

        val tvShowIntent: TvShow? = intent.getParcelableExtra(EXTRA_TV_SHOW)

        btn_favorite.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.add_favorite) + " ${tvShowIntent?.title}", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        btn_watchlist.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.add_watchlist) + " ${tvShowIntent?.title}", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        txt_title.text = tvShowIntent?.title
        txt_releaseDate.text = tvShowIntent?.releaseDate
        txt_overview.text = tvShowIntent?.overview
        txt_crew.text = tvShowIntent?.crew
        txt_user_score.text = tvShowIntent?.userScore

        Glide.with(this)
            .load(tvShowIntent?.poster)
            .into(img_poster)

        Glide.with(this)
            .load(tvShowIntent?.poster)
            .into(img_poster_crop)
    }
}
