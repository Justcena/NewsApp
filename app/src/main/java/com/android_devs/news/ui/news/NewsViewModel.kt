package com.android_devs.news.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_devs.news.models.Article
import com.android_devs.news.models.NewsResponse
import com.android_devs.news.repository.NewsRepository
import com.android_devs.news.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(val newsRepository: NewsRepository) : ViewModel() {

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private val breakingNewsPage = 1
    val breakingNewsResponse: NewsResponse? = null

    val saerchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private val searchNewsPage = 1
    val searchNewsResponse: NewsResponse? = null

    init {
        getBreakingNews("us")
    }

    fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    fun searchNews(searchQuerry: String) = viewModelScope.launch {
        saerchNews.postValue(Resource.Loading())
        val response = newsRepository.searchNews(searchQuerry, searchNewsPage)
        saerchNews.postValue(handleSearchNewsResponse(response))
    }


    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleSearchNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }


    fun saveArticle(article: Article) = viewModelScope.launch {
        newsRepository.upsert(article)
    }

    fun getSavedNews() = newsRepository.getSavedNews()

    fun deleteArticle(article: Article) = viewModelScope.launch {
        newsRepository.delet(article)
    }

}