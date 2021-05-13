package com.pmprogramms.repobook.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.model.Github
import com.pmprogramms.repobook.view.MainFragment
import com.pmprogramms.repobook.view.MainFragmentDirections

class GithubRecyclerAdapter : RecyclerView.Adapter<GithubRecyclerAdapter.ViewHolder>() {
    private lateinit var listGHRepository: List<Github>

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameRepository: TextView = itemView.findViewById(R.id.title_repository)
        val username: TextView = itemView.findViewById(R.id.username)
        val container: ConstraintLayout = itemView.findViewById(R.id.container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listGHRepository[position]

        holder.nameRepository.text = holder.itemView.context.getString(R.string.repository_title, currentItem.name)
        holder.username.text = holder.itemView.context.getString(R.string.username, currentItem.owner.login)
        holder.container.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToGithubRepositoryDetailsFragment(
                currentItem
            )
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listGHRepository.size
    }

    fun setData(listGHRepository: List<Github>) {
        this.listGHRepository = listGHRepository
    }
}