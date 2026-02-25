package com.example.spaceflightnewsapp.repository

import com.example.spaceflightnewsapp.api.NewsApi
import com.example.spaceflightnewsapp.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

// Manual constructor injection
// TODO: Hilt DI
//class NewsRepository(private val api: NewsApi = RetrofitClient.api) {
@Singleton
class NewsRepository @Inject constructor(private val api: NewsApi) {
    suspend fun getNews(): Result<List<com.example.spaceflightnewsapp.model.Result>> = withContext(Dispatchers.IO){
        try {
            val response = api.getNews()
            val news = response.results
            Result.success(news)
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}
