package com.pmprogramms.repobook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.databinding.FragmentGithubRepositoryDetailsBinding
import com.pmprogramms.repobook.model.Github

class GithubRepositoryDetailsFragment : Fragment() {

    private val args by navArgs<GithubRepositoryDetailsFragmentArgs>()
    private lateinit var github: Github

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGithubRepositoryDetailsBinding.inflate(layoutInflater)
        val usernameTV = binding.username
        val repositoryTitleTV = binding.titleRepository
        val descriptionTV = binding.description
        github = args.github

        usernameTV.text = requireContext().getString(R.string.username, github.owner.username)
        repositoryTitleTV.text = requireContext().getString(R.string.repository_title, github.repositoryTitle)
        descriptionTV.text = requireContext().getString(R.string.description, github.description)

        return binding.root
    }
}
