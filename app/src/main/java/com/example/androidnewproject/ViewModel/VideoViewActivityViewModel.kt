package com.example.androidtask.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtask.Model.LanguageModel
import com.example.androidtask.Utility.Resource
import medSpell.Activity.Repository.SearchApiRepository

class VideoViewActivityViewModel() : ViewModel() {

    var repository: SearchApiRepository? = null

    init {
        repository = SearchApiRepository()
    }

    fun getMovieListApi(): MutableLiveData<Resource<LanguageModel>>? {
        return repository?.getMovieListApi()
    }

}