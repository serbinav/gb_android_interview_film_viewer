package com.example.filmslist.ui.description

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.filmslist.databinding.FragmentDescriptionBinding
import com.example.filmslist.model.SearchResult

class DescriptionFragment : Fragment() {

    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!
    private var filmDescription: SearchResult? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            filmDescription = it.getParcelable(FILM_DESCRIPTION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)

        filmDescription?.let {
            with(binding) {
                //image.
                title.text = it.title
                fullTitle.text = it.fullTitle
                year.text = it.year
                crew.text = it.crew
                imDbRating.text = it.imDbRating
            }
        }

        return binding.root
    }

    companion object {
        const val FILM_DESCRIPTION = "FILM_DESCRIPTION"
    }
}