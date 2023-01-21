package com.example.testjson

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.RandomRegion
import com.example.testjson.mvvm.State
import com.example.testjson.repository.RandomRegionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RandomRegionViewModel(
    private val repository: RandomRegionRepository
) : ViewModel() {
    private var _state: MutableStateFlow<State> = MutableStateFlow<State>(State.Success)
    var state=_state.asStateFlow()

    private var _randomRegion: MutableStateFlow<RandomRegion?> = MutableStateFlow<RandomRegion?>(RandomRegion()
    )
    var randomRegion=_randomRegion.asStateFlow()


    init {

        viewModelScope.launch {
            _state.value= State.Loading
            try {
                val user= repository.getRandomRegion()
                _randomRegion.value=user
            }
            catch (t:Throwable){
                _randomRegion.value= RandomRegion()

            }

            _state.value= State.Success
        }
    }

    fun btnRestartOnClick() {
        viewModelScope.launch {
            _state.value= State.Loading
            try {
                val user= repository.getRandomRegion()
                _randomRegion.value=user
            }
            catch (t:Throwable){
                _randomRegion.value=RandomRegion()

            }

            _state.value= State.Success
        }
    }
}
