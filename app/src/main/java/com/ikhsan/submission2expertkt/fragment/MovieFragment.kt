package com.ikhsan.submission2expertkt.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ikhsan.submission2expertkt.R
import com.ikhsan.submission2expertkt.activity.MovieDetailActivity
import com.ikhsan.submission2expertkt.adapter.MovieAdapter
import com.ikhsan.submission2expertkt.model.Movie
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    var list: ArrayList<Movie> = arrayListOf()
//
//    var dataPoster: TypedArray[]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_movies.setHasFixedSize(true)
        list.addAll(getListMovie())
        rv_movies.layoutManager = LinearLayoutManager(activity)
        val movieAdapter = MovieAdapter(list, {movie: Movie -> movieItemClicked(movie) })
        rv_movies.adapter = movieAdapter
    }

    private fun getListMovie(): ArrayList<Movie>{

        val dataPoster = resources.getStringArray(R.array.moviePoster)
        val dataTitle = resources.getStringArray(R.array.movieTitle)
        val dataReleaseDate = resources.getStringArray(R.array.movieReleaseDate)
        val dataOverview = resources.getStringArray(R.array.movieOverview)
        val dataCrew = resources.getStringArray(R.array.movieCrew)
        val dataUserScore = resources.getStringArray(R.array.movieUserScore)

        val listMovie = ArrayList<Movie>()
        for (i in dataTitle.indices){
            val movie = Movie(
                dataPoster[i],
                dataTitle[i],
                dataReleaseDate[i],
                dataOverview[i],
                dataCrew[i],
                dataUserScore[i]
            )
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun movieItemClicked(movie: Movie){
        val movieIntent = Intent(activity, MovieDetailActivity::class.java)
        movieIntent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie)
        startActivity(movieIntent)
    }

}
