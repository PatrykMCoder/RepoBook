package com.pmprogramms.repobook.view

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.adapters.GithubRecyclerAdapter
import com.pmprogramms.repobook.adapters.GithubSearchRecyclerAdapter
import com.pmprogramms.repobook.databinding.FragmentSearchGithubBinding
import com.pmprogramms.repobook.viewmodel.RepositoriesViewModel

class GithubSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSearchGithubBinding.inflate(layoutInflater)
        val viewModel = ViewModelProvider(this).get(RepositoriesViewModel::class.java)
        val recyclerView = binding.recyclerView
        val recyclerAdapter = GithubSearchRecyclerAdapter()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.searchText.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if ((event?.action == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)
                ) {
                    viewModel.getGithubRepositoriesSearch(binding.searchText.text.toString())
                        .observe(viewLifecycleOwner, {
                            if (it != null) {
                                binding.countSearchedText.text =
                                    requireContext().getString(R.string.count, it.count.toString())

                                recyclerAdapter.setData(it.items)
                                recyclerView.adapter = recyclerAdapter
                            }
                        })
                    return true
                }
                return false
            }
        })

        return binding.root
    }

}