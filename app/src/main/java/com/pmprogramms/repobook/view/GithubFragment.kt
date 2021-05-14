package com.pmprogramms.repobook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmprogramms.repobook.adapters.GithubRecyclerAdapter
import com.pmprogramms.repobook.databinding.FragmentGithubBinding
import com.pmprogramms.repobook.viewmodel.RepositoriesViewModel

class GithubFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGithubBinding.inflate(layoutInflater)
        val recyclerView = binding.recyclerView
        val recyclerAdapter = GithubRecyclerAdapter()

        val viewModel = ViewModelProvider(this).get(RepositoriesViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getAllGithubRepositories().observe(viewLifecycleOwner, {
            if (it != null) {
                recyclerAdapter.setData(it)
                recyclerView.adapter = recyclerAdapter
            }
            else {
//                todo -> handle error
            }
        })

        return binding.root
    }
}