package com.pmprogramms.repobook.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.adapters.BitbucketRecyclerAdapter
import com.pmprogramms.repobook.databinding.FragmentBitbucketBinding
import com.pmprogramms.repobook.viewmodel.RepositoriesViewModel

class BitbucketFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBitbucketBinding.inflate(layoutInflater)
        val recyclerView = binding.recyclerView
        val recyclerAdapter = BitbucketRecyclerAdapter()

        val viewModel = ViewModelProvider(this).get(RepositoriesViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getAllBitbucketRepositories().observe(viewLifecycleOwner, {
            if (it != null) {
                recyclerAdapter.setData(it)
                recyclerView.adapter = recyclerAdapter
            }
        })

        return binding.root
    }
}
