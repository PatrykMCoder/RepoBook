package com.pmprogramms.repobook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.databinding.FragmentBitbucketRepositoryDetailsBinding
import com.pmprogramms.repobook.model.Bitbucket


class BitbucketRepositoryDetailsFragment : Fragment() {
    private val args by navArgs<BitbucketRepositoryDetailsFragmentArgs>()
    private lateinit var bitbucketValue: Bitbucket.Value

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBitbucketRepositoryDetailsBinding.inflate(layoutInflater)
        val usernameTV = binding.username
        val repositoryTitleTV = binding.titleRepository
        val descriptionTV = binding.description

        bitbucketValue = args.bitbuckerValue

        usernameTV.text = requireContext().getString(R.string.username, bitbucketValue.owner.displayName)
        repositoryTitleTV.text = requireContext().getString(R.string.repository_title, bitbucketValue.name)
        descriptionTV.text = requireContext().getString(R.string.description, bitbucketValue.description)

        return binding.root
    }
}