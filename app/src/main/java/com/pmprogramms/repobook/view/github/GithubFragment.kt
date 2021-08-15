package com.pmprogramms.repobook.view.github

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.adapters.github.GithubRecyclerAdapter
import com.pmprogramms.repobook.databinding.FragmentGithubBinding
import com.pmprogramms.repobook.view.dialog.SomethingWrongDialog
import com.pmprogramms.repobook.viewmodel.RepositoriesViewModel

class GithubFragment : Fragment() {
    private lateinit var viewModel: RepositoriesViewModel
    private var sorted = false
    private lateinit var binding: FragmentGithubBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGithubBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(RepositoriesViewModel::class.java)

        getDataRepositories(sorted)

        binding.sortResult.setOnClickListener {
            Toast.makeText(requireContext(), "Sorting...", Toast.LENGTH_SHORT).show()
            sorted = sorted.not()

            getDataRepositories(sorted)
        }

        binding.searchRepositories.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_searchGithubFragment)
        }

        binding.githubUsers.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_githubUsersFragment)
        }

        return binding.root
    }

    private fun getDataRepositories(sorted: Boolean) {
        viewModel.getAllGithubRepositories(sorted).observe(viewLifecycleOwner, {
            if (it != null) {
                binding.recyclerView.apply {
                    setHasFixedSize(true)
                    adapter = GithubRecyclerAdapter(it)
                    layoutManager = LinearLayoutManager(requireContext())
                }
            } else {
                val somethingWrongDialog = SomethingWrongDialog()
                somethingWrongDialog.show(childFragmentManager, "SomethingWrong")
            }
        })
    }
}