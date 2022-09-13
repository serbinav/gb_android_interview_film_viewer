package com.example.filmslist.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmslist.R
import com.example.filmslist.databinding.FragmentFilmsBinding
import com.example.filmslist.ui.description.DescriptionFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmsFragment : Fragment() {

    private var _binding: FragmentFilmsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FilmsViewModel by viewModel()

    private val adapter: MoviesAdapter by lazy {
        MoviesAdapter { data ->
            val bundle = bundleOf(DescriptionFragment.FILM_DESCRIPTION to data)
            findNavController()
                .navigate(R.id.action_navigation_films_to_navigation_description, bundle)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmsBinding.inflate(inflater, container, false)
        binding.recyclerFilms.adapter = adapter
        binding.recyclerFilms.layoutManager = GridLayoutManager(
            requireContext(),
            3,
            RecyclerView.VERTICAL,
            false
        )
        viewModel.getData();
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.progress.isVisible = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}