package com.android_devs.news.repository

import com.android_devs.news.api.RetrofitInstance
import com.android_devs.news.db.ArticleDatabase

class NewsRepository(val database: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuerry: String, pageNumber: Int) =
        RetrofitInstance.api.getSearchNews(searchQuerry, pageNumber)


}