package com.pmprogramms.repobook.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.pmprogramms.repobook.databinding.FragmentMainBinding
import com.pmprogramms.repobook.view.bitbucket.BitbucketFragment
import com.pmprogramms.repobook.view.github.GithubFragment

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(layoutInflater)

        val tabLayout = binding.tabLayout
        val pager = binding.pager
        val adapter = PagerAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(pager)

        pager.adapter = adapter

        return binding.root
    }

    class PagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int {
            return 2
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> GithubFragment()
                1 -> BitbucketFragment()
                else ->  GithubFragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence {
            return when (position) {
                0 -> "Github"
                1 -> "Bitbucket"
                else ->  "Github"
            }
        }
    }
}