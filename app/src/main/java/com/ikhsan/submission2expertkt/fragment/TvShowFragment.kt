package com.ikhsan.submission2expertkt.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ikhsan.submission2expertkt.R
import com.ikhsan.submission2expertkt.activity.TvShowDetailActivity
import com.ikhsan.submission2expertkt.adapter.TvShowAdapter
import com.ikhsan.submission2expertkt.model.TvShow
import kotlinx.android.synthetic.main.fragment_tv_show.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment() {

    private var list: ArrayList<TvShow> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_tv_show.setHasFixedSize(true)
        list.addAll(getListTvShow())
        rv_tv_show.layoutManager = LinearLayoutManager(activity)
        val tvShowAdapter = TvShowAdapter(list,{tvShow: TvShow -> tvShowItemClicked(tvShow) })
        rv_tv_show.adapter = tvShowAdapter
    }
    private fun getListTvShow(): ArrayList<TvShow>{
        val dataPoster = resources.getStringArray(R.array.tvShowPoster)
        val dataTitle = resources.getStringArray(R.array.tvShowTitle)
        val dataReleaseDate = resources.getStringArray(R.array.tvShowReleaseDate)
        val dataOverview = resources.getStringArray(R.array.tvShowOverview)
        val dataCrew = resources.getStringArray(R.array.tvShowCrew)
        val dataUserScore = resources.getStringArray(R.array.tvShowUserScore)

        val listTvShow = ArrayList<TvShow>()
        for (i in dataTitle.indices){
            val tvShow = TvShow(
                dataPoster[i],
                dataTitle[i],
                dataReleaseDate[i],
                dataOverview[i],
                dataCrew[i],
                dataUserScore[i]
            )
            listTvShow.add(tvShow)
        }
        return listTvShow
    }

    private fun tvShowItemClicked(tvShow: TvShow){
        val tvShowIntent = Intent(activity, TvShowDetailActivity::class.java)
        tvShowIntent.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW, tvShow)
        startActivity(tvShowIntent)
    }

}
