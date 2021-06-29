package com.pmprogramms.repobook.view.github

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.databinding.FragmentGithubRepositoryDetailsBinding
import com.pmprogramms.repobook.model.github.Github

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
        val imageProfile = binding.userAvatar
        val htmlUrlTV = binding.htmlUrl

        github = args.github

        usernameTV.text = requireContext().getString(R.string.username, github.owner.username)
        repositoryTitleTV.text =
            requireContext().getString(R.string.repository_title, github.repositoryTitle)
        descriptionTV.text = requireContext().getString(R.string.description, github.description)
        htmlUrlTV.text = requireContext().getString(R.string.html_url, github.url)

        Glide.with(this)
            .load(github.owner.avatarURL)
            .apply(RequestOptions().override(200, 200))
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(imageProfile)

        return binding.root
    }
}
