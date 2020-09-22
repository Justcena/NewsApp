package com.android_devs.news.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android_devs.news.repository.NewsRepository
import com.android_devs.news.ui.news.NewsViewModel

class NewsViewModelProviderFactory(val newsRepository: NewsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }

}