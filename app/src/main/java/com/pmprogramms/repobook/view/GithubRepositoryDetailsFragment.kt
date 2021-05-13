package com.pmprogramms.repobook.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
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
        github = args.github

        return binding.root
    }
}