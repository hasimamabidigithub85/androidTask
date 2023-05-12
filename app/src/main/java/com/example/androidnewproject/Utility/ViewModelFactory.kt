package com.example.androidtask.Utility

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidtask.ViewModel.VideoViewActivityViewModel


class ViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

//        if (modelClass.isAssignableFrom(VideoViewActivityViewModel::class.java)) {
//            return VideoViewActivityViewModel() as T
//        }


        if (modelClass.isAssignableFrom(VideoViewActivityViewModel::class.java)) {
            return VideoViewActivityViewModel() as T
        }

        throw IllegalArgumentException("Unknown class name")
    }

}