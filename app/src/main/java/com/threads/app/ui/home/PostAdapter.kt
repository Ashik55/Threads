package com.threads.app.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.threads.app.R
import com.threads.app.data.Post

class PostAdapter(private val posts: List<Post>, private val onItemClick: (Post) -> Unit) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    companion object {
        private const val TYPE_IMAGE = 1
        private const val TYPE_TEXT = 3
        private const val TYPE_ADS = 4
    }

    override fun getItemViewType(position: Int): Int {
        return when (posts[position].type) {
            "image" -> TYPE_IMAGE
            "text" -> TYPE_TEXT
            "ads" -> TYPE_ADS
            else -> TYPE_TEXT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = when (viewType) {
            TYPE_IMAGE -> layoutInflater.inflate(R.layout.post_type_image, parent, false)
//            TYPE_VIDEO -> layoutInflater.inflate(R.layout.post_type_video, parent, false)
            TYPE_TEXT -> layoutInflater.inflate(R.layout.post_type_text, parent, false)
//            TYPE_ADS -> layoutInflater.inflate(R.layout.post_type_ads, parent, false)
            else -> layoutInflater.inflate(R.layout.post_type_text, parent, false)
        }
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
        holder.itemView.setOnClickListener { onItemClick(post) }
    }

    override fun getItemCount() = posts.size

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) {
            // Bind data based on view type
            when (getItemViewType(adapterPosition)) {
                TYPE_IMAGE -> {
                    val imageView = itemView.findViewById<ImageView>(R.id.post_image)
                    imageView.load(post.imageUrl) {
                        crossfade(true)

                    }
                    itemView.findViewById<TextView>(R.id.post_title).text = post.title
                    itemView.findViewById<TextView>(R.id.post_description).text = post.description
                }

                TYPE_TEXT -> {
                    itemView.findViewById<TextView>(R.id.post_title).text = post.title
                    itemView.findViewById<TextView>(R.id.post_description).text = post.description
                }

                TYPE_ADS -> {
                    // Set up ads view
                }
            }
        }
    }
}