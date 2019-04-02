package com.example.letsgetcheckedapplication.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.letsgetcheckedapplication.R
import com.example.letsgetcheckedapplication.detail.DetailActivity
import com.example.letsgetcheckedapplication.extensions.startActivity
import com.example.letsgetcheckedapplication.model.BlogPost
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val blogListViewModel: BlogListViewModel by viewModel()

    private val blogAdapter = BlogAdapter {
        startActivity<DetailActivity>(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        blogList.setHasFixedSize(true)
        blogList.layoutManager = LinearLayoutManager(this)
        blogList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        blogList.adapter = blogAdapter
        blogListViewModel.blogPosts.observe(this, Observer<List<BlogPost>>(blogAdapter::setData))
    }
}
