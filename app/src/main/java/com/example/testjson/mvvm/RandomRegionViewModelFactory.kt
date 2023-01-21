package com.example.testjson.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.example.RandomRegion
import com.example.testjson.RandomRegionViewModel
import com.example.testjson.repository.RandomRegionRepository

class RandomRegionViewModelFactory: ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(RandomRegionViewModel::class.java)){
            return RandomRegionViewModel(RandomRegionRepository()) as T
        }else
            throw IllegalArgumentException("Unknown class name")
    }
}