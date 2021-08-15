package com.pmprogramms.repobook.view.github

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.adapters.github.GithubSearchRecyclerAdapter
import com.pmprogramms.repobook.databinding.FragmentSearchGithubBinding
import com.pmprogramms.repobook.viewmodel.RepositoriesViewModel

class GithubSearchFragment : Fragment() {
    private lateinit var viewModel: RepositoriesViewModel
    private lateinit var binding: FragmentSearchGithubBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
                                binding.recyclerView.apply {
                                    setHasFixedSize(true)
                                    adapter = GithubSearchRecyclerAdapter(it.items)
                                    layoutManager = LinearLayoutManager(requireContext())
                                }
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