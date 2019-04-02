package com.example.letsgetcheckedapplication.di

import com.example.letsgetcheckedapplication.BuildConfig
import com.example.letsgetcheckedapplication.list.BlogListViewModel
import com.example.letsgetcheckedapplication.network.BlogService
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "http://10.0.2.2:9001"

val networkModule = module {
    single {
        createWebService<BlogService>(
            get()
        )
    }
    single {
        retroFit(
            BASE_URL,
            get(),
            get(),
            get()
        )
    }
    single { okHttpClient(get()) }
    single { httpLoggingInterceptor() }
    single<CallAdapter.Factory> { RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()) }
    single<Converter.Factory> { MoshiConverterFactory.create() }
}

val viewModelModule = module {
    viewModel { BlogListViewModel(get()) }
}

private fun httpLoggingInterceptor() =
    HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
    }


inline fun <reified T> createWebService(retrofit: Retrofit) = retrofit.create(T::class.java)

private fun retroFit(
    baseUrl: String,
    okHttpClient: OkHttpClient,
    callAdapterFactory: CallAdapter.Factory,
    converterFactory: Converter.Factory
) = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addCallAdapterFactory(callAdapterFactory)
    .client(okHttpClient)
    .addConverterFactory(converterFactory)
    .build()

private fun okHttpClient(interceptor: HttpLoggingInterceptor) =
    OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()