package com.mikirinkode.suitmediatest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mikirinkode.suitmediatest.data.model.UserEntity
import com.mikirinkode.suitmediatest.databinding.ItemUserBinding

class UserAdapter : PagingDataAdapter<UserEntity, UserAdapter.UserViewHolder>(UserDiffCallBack()) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val data = getItem(position)

        if (data != null) {
            holder.bind(data)
        }

        val name = data?.firstName + " " + data?.lastName

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(name)
        }
    }

    class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserEntity) {

            binding.apply {
                tvUserEmail.text = user.email
                tvUserFullname.text = user.firstName + " " + user.lastName

                Glide.with(itemView)
                    .load(user.avatarUrl)
                    .into(ivUserProfile)
            }
        }
    }



    interface OnItemClickCallback {
        fun onItemClicked(name: String)
    }

    class UserDiffCallBack : DiffUtil.ItemCallback<UserEntity>() {
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem == newItem
        }
    }
}