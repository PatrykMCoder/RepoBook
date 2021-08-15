package com.pmprogramms.repobook.view.github

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.adapters.github.GithubUsersRecyclerAdapter
import com.pmprogramms.repobook.databinding.FragmentGithubUsersBinding
import com.pmprogramms.repobook.viewmodel.RepositoriesViewModel

class GithubUsersFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGithubUsersBinding.inflate(layoutInflater)
        val viewModel = ViewModelProvider(this).get(RepositoriesViewModel::class.java)

        viewModel.getAllUsersGithub().observe(viewLifecycleOwner,  { users ->
            if (users != null)
                binding.usersRecyclerView.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = GithubUsersRecyclerAdapter(users)
                }
        })

        return binding.root
    }

}