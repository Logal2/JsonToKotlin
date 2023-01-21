package com.example.testjson.repository

import com.example.example.RandomRegion
import com.example.testjson.RetrofitInstance

class RandomRegionRepository {

    suspend fun getRandomRegion():RandomRegion{
        return RetrofitInstance.searchRandomRegionApi.getRandomRegion().results[0]
    }
}