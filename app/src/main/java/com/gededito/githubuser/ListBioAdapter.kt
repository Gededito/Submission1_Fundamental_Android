package com.gededito.githubuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gededito.githubuser.databinding.ItemUserBinding

class ListBioAdapter(private val listBio: ArrayList<DataBio>) : RecyclerView.Adapter<ListBioAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listBio[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listBio[position])}
    }

    override fun getItemCount(): Int = listBio.size

    class ListViewHolder(private var binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DataBio) {
            binding.tvUsername.text = data.username
            binding.tvLocation.text = data.location
            Glide.with(binding.root)
                .load(data.photo)
                .circleCrop()
                .into(binding.itemPhoto)
        }

    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataBio)
    }

}