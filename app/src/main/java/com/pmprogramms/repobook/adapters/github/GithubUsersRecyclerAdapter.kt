package com.pmprogramms.repobook.adapters.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pmprogramms.repobook.R
import com.pmprogramms.repobook.model.github.GithubUsers

class GithubUsersRecyclerAdapter(private val users: List<GithubUsers>) : RecyclerView.Adapter<GithubUsersRecyclerAdapter.UsersViewHolder>() {
    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatarImage = itemView.findViewById<ImageView>(R.id.user_avatar)
        private val usernameTextView = itemView.findViewById<TextView>(R.id.username)
        fun bind(user: GithubUsers) {
            Glide.with(itemView.context).load(user.avatar_url).into(avatarImage)
            usernameTextView.text = user.login
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}