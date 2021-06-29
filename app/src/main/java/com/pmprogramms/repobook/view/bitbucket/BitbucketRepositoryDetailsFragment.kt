package com.pmprogramms.repobook.view.bitbucket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.databinding.FragmentBitbucketRepositoryDetailsBinding
import com.pmprogramms.repobook.model.bitbucket.Bitbucket

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
        val imageProfile = binding.userAvatar

        bitbucketValue = args.bitbuckerValue

        usernameTV.text =
            requireContext().getString(R.string.username, bitbucketValue.owner.getName())
        repositoryTitleTV.text =
            requireContext().getString(R.string.repository_title, bitbucketValue.name)
        descriptionTV.text =
            requireContext().getString(R.string.description, bitbucketValue.description)

        Glide.with(this)
            .load(bitbucketValue.owner.links.avatar.avatarURL)
            .apply(RequestOptions().override(200, 200))
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(imageProfile)

        return binding.root
    }
}