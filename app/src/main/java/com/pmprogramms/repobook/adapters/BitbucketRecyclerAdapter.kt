package com.pmprogramms.repobook.adapters

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
import com.pmprogramms.repobook.model.Bitbucket
import com.pmprogramms.repobook.view.MainFragmentDirections

class BitbucketRecyclerAdapter : RecyclerView.Adapter<BitbucketRecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameRepository: TextView = itemView.findViewById(R.id.title_repository)
        val username: TextView = itemView.findViewById(R.id.username)
        val container: ConstraintLayout = itemView.findViewById(R.id.container)
        val imageProfile: ImageView = itemView.findViewById(R.id.user_avatar)
    }

    private lateinit var bitbucketRepository: Bitbucket

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = bitbucketRepository.values[position]

        holder.nameRepository.text = holder.itemView.context.getString(R.string.repository_title, currentItem.name)
        holder.username.text = holder.itemView.context.getString(R.string.username, currentItem.owner.getName())
        holder.container.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToBitbucketRepositoryDetailsFragment(
                currentItem
            )

            holder.itemView.findNavController().navigate(action)
        }

        Glide.with(holder.itemView)
            .load(currentItem.owner.links.avatar.avatarURL)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(holder.imageProfile)
    }

    override fun getItemCount(): Int {
        return bitbucketRepository.values.size
    }

    fun setData(bitbucket: Bitbucket) {
        this.bitbucketRepository = bitbucket
    }
}