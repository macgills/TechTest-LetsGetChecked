package com.example.letsgetcheckedapplication.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.letsgetcheckedapplication.model.BlogPost
import com.example.letsgetcheckedapplication.network.BlogService
import io.reactivex.disposables.CompositeDisposable

class BlogListViewModel(private val blogService: BlogService) : ViewModel() {
    val compositeDisposable = CompositeDisposable()
    val blogPosts = MutableLiveData<List<BlogPost>>()

    init {
        compositeDisposable.addAll(
            blogService.posts().subscribe(
                { blogPosts.postValue(it.sortedBy { it.publish_date }) },
                { blogPosts.postValue(listOf()) })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

}
