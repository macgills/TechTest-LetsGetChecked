package com.example.letsgetcheckedapplication.list

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.letsgetcheckedapplication.R
import com.example.letsgetcheckedapplication.extensions.inflate
import com.example.letsgetcheckedapplication.model.BlogPost
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.li_blog_post.*

class BlogAdapter(var items: List<BlogPost> = listOf(), var clickListener: ((BlogPost) -> Unit)? = null) :
    RecyclerView.Adapter<BlogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BlogViewHolder(parent.inflate(R.layout.li_blog_post))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) = holder.bind(items[position], clickListener)

    fun setData(blogPostList: List<BlogPost>) {
        items = blogPostList
        notifyDataSetChanged()
    }
}

class BlogViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(
        blogPost: BlogPost,
        clickListener: ((BlogPost) -> Unit)?
    ) {
        blogTitle.text = "${blogPost.title} ${blogPost.publish_date}"
        containerView.setOnClickListener { clickListener?.invoke(blogPost) }
    }
}
