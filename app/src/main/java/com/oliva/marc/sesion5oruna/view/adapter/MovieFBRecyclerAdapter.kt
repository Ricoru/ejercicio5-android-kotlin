package com.oliva.marc.sesion5oruna.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.oliva.marc.sesion5oruna.R
import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB
import kotlinx.android.synthetic.main.row_item_movie.view.*

class MovieFBRecyclerAdapter(val movies: ArrayList<MovieFB>) :
    RecyclerView.Adapter<MovieFBRecyclerAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_item_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) =
        holder.setDataMovie(movies[position])

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var pictureImageView = itemView.picture_imageview
        var nameTextview = itemView.name_textview
        var ratingRatingBar = itemView.rating_ratingbar
        var categoryTextview = itemView.category_textview

        fun setDataMovie(movie: MovieFB) {
            nameTextview.text = movie.name
            categoryTextview.text = movie.category
            ratingRatingBar.rating = movie.rating.toFloat()
            pictureImageView.load(movie.picture) {
                crossfade(true)
                placeholder(R.drawable.ic_picture_movie)
            }

        }
    }
}