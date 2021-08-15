package com.pmprogramms.repobook.view.bitbucket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pmprogramms.repobook.adapters.bitbucket.BitbucketRecyclerAdapter
import com.pmprogramms.repobook.databinding.FragmentBitbucketBinding
import com.pmprogramms.repobook.view.dialog.SomethingWrongDialog
import com.pmprogramms.repobook.viewmodel.RepositoriesViewModel

class BitbucketFragment : Fragment() {
    private lateinit var viewModel: RepositoriesViewModel
    private var sorted = false
    private lateinit var binding: FragmentBitbucketBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBitbucketBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(RepositoriesViewModel::class.java)

        getDataRepositories(sorted)

        binding.sortResult.setOnClickListener {
            Toast.makeText(requireContext(), "Sorting...", Toast.LENGTH_SHORT).show()
            sorted = sorted.not()

            getDataRepositories(sorted)
        }

        return binding.root
    }

    private fun getDataRepositories(sorted: Boolean) {
        viewModel.getAllBitbucketRepositories(sorted).observe(viewLifecycleOwner, {
            if (it != null) {
                binding.recyclerView.apply {
                    setHasFixedSize(true)
                    adapter = BitbucketRecyclerAdapter(it)
                    layoutManager = LinearLayoutManager(requireContext())
                }
            } else {
                val somethingWrongDialog = SomethingWrongDialog()
                somethingWrongDialog.show(childFragmentManager, "SomethingWrong")
            }
        })
    }
}
