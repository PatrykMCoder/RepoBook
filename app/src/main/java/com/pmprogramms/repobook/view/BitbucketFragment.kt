package com.pmprogramms.repobook.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pmprogramms.repobook.adapters.BitbucketRecyclerAdapter
import com.pmprogramms.repobook.adapters.GithubRecyclerAdapter
import com.pmprogramms.repobook.databinding.FragmentBitbucketBinding
import com.pmprogramms.repobook.viewmodel.RepositoriesViewModel

class BitbucketFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var recyclerAdapter: BitbucketRecyclerAdapter? = null
    private var viewModel: RepositoriesViewModel? = null
    private var sorted = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBitbucketBinding.inflate(layoutInflater)
        recyclerView = binding.recyclerView
        recyclerAdapter = BitbucketRecyclerAdapter()

        viewModel = ViewModelProvider(this).get(RepositoriesViewModel::class.java)

        recyclerView!!.layoutManager = LinearLayoutManager(requireContext())

        getDataRepositories(sorted)

        binding.sortResult.setOnClickListener {
            Toast.makeText(requireContext(), "Sorting...", Toast.LENGTH_SHORT).show()
            sorted = sorted.not()

            getDataRepositories(sorted)
        }

        return binding.root
    }

    private fun getDataRepositories(sorted: Boolean) {
        viewModel!!.getAllBitbucketRepositories(sorted).observe(viewLifecycleOwner, {
            if (it != null) {
                recyclerAdapter?.setData(it)
                recyclerView?.adapter = recyclerAdapter
            }
        })
    }
}
