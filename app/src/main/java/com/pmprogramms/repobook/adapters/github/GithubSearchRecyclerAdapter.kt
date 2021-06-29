package com.pmprogramms.repobook.adapters.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.model.github.Github
import com.pmprogramms.repobook.view.GithubSearchFragmentDirections

class GithubSearchRecyclerAdapter : RecyclerView.Adapter<GithubSearchRecyclerAdapter.ViewHolder>() {
    private lateinit var listGHRepository: List<Github>

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameRepository: TextView = itemView.findViewById(R.id.title_repository)
        val username: TextView = itemView.findViewById(R.id.username)
        val container: ConstraintLayout = itemView.findViewById(R.id.container)
        val imageProfile: ImageView = itemView.findViewById(R.id.user_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listGHRepository[position]

        holder.nameRepository.text = holder.itemView.context.getString(
            R.string.repository_title,
            currentItem.repositoryTitle
        )
        holder.username.text =
            holder.itemView.context.getString(R.string.username, currentItem.owner.username)
        holder.container.setOnClickListener {
            val action = GithubSearchFragmentDirections.actionSearchGithubFragmentToGithubRepositoryDetailsFragment(
                currentItem
            )
            holder.itemView.findNavController().navigate(action)
        }

        Glide.with(holder.itemView)
            .load(currentItem.owner.avatarURL)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(holder.imageProfile)
    }

    override fun getItemCount(): Int {
        return listGHRepository.size
    }

    fun setData(listGHRepository: List<Github>) {
        this.listGHRepository = listGHRepository
    }
}