package com.android_devs.news.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.android_devs.news.R
import com.android_devs.news.ui.NewsActivity
import com.android_devs.news.ui.NewsViewModel

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {
    lateinit var viewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
    }
}