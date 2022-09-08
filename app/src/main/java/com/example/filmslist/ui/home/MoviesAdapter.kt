package com.example.filmslist.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.filmslist.databinding.ItemMoviesBinding
import com.example.filmslist.model.SearchResult
import com.example.filmslist.usePicassoToLoadPhoto

class MoviesAdapter(
    private val onItemClick: (SearchResult) -> Unit
) : ListAdapter<SearchResult, MoviesAdapter.MoviesViewHolder>(NoteItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding =
            ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class MoviesViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SearchResult) {
            with(binding) {
                if (data.image.isNotEmpty()) {
                    usePicassoToLoadPhoto(imageMovies, data.image)
                }
                binding.nameMovies.text = data.title
                
                root.setOnClickListener { onItemClick.invoke(data) }
            }
        }
    }
}

class NoteItemCallback : DiffUtil.ItemCallback<SearchResult>() {
    override fun areItemsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
        return oldItem == newItem
    }
}