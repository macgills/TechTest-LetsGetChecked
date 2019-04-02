package com.example.letsgetcheckedapplication.network

import com.example.letsgetcheckedapplication.model.BlogComment
import com.example.letsgetcheckedapplication.model.BlogPost
import io.reactivex.Flowable
import retrofit2.http.*

interface BlogService {
    @GET("/posts")
    fun posts(): Flowable<List<BlogPost>>

    @GET("/posts/{id}")
    fun aPost(@Path("id") id: Int): Flowable<BlogPost>

    @GET("/posts/{id}/comments")
    fun comments(@Path("id") id: Int): Flowable<List<BlogComment>>

    @POST("/posts/{id}/comments")
    fun addComment(@Path("id") id: Int, @Body comment: BlogComment): Flowable<BlogComment>

    @PUT("/comments/{id}")
    fun updateComment(@Path("id") id: Int, @Body comment: BlogComment): Flowable<BlogComment>
}