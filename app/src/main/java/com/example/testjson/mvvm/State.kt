package com.example.testjson.mvvm

sealed class State {
    object Loading: State()
    object Success: State()
}