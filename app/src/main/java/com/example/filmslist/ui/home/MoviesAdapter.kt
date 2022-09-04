package com.example.filmslist.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmslist.R
import com.example.filmslist.databinding.ItemMoviesBinding
import com.example.filmslist.model.SearchResult
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    var films: List<SearchResult> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding =
            ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(films[position])
    }

    override fun getItemCount(): Int = films.size

    class MoviesViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SearchResult) {
            if (data.image.isNotEmpty() ) {
                usePicassoToLoadPhoto(binding.imageMovies, data.image)
            }
            binding.nameMovies.text = data.title
        }

        private fun usePicassoToLoadPhoto(imageView: ImageView, imageLink: String) {
            Picasso.get().load(imageLink)
                .placeholder(R.drawable.no_img_200_200).fit().centerCrop()
                .into(imageView, object : Callback {
                    override fun onSuccess() {
                    }

                    override fun onError(e: Exception?) {
                        imageView.setImageResource(R.drawable.ic_baseline_error_outline_24)
                    }
                })
        }
    }
}