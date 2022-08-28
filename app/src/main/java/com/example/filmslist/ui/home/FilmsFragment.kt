package com.example.filmslist.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.filmslist.databinding.FragmentFilmsBinding

class FilmsFragment : Fragment() {

    private var _binding: FragmentFilmsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FilmsViewModel by lazy {
        ViewModelProvider(this).get(FilmsViewModel::class.java)
    }
    private val adapter: MoviesAdapter by lazy {
        MoviesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmsBinding.inflate(inflater, container, false)
        binding.recyclerFilms.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.data.observe(viewLifecycleOwner) {
            adapter.films = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}