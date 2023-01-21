package com.example.testjson.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.testjson.RandomRegionViewModel
import com.example.testjson.databinding.FragmentRandomRegionBinding
import com.example.testjson.mvvm.RandomRegionViewModelFactory
import com.example.testjson.mvvm.State


class RandomRegionFragment : Fragment(
) {

    private var _binding : FragmentRandomRegionBinding? = null
    private val binding get()=_binding!!

//private val Repo: RandomRegionRepository
//    get() {
//        Repo.getRandomRegion()
//    }
    private val viewModel: RandomRegionViewModel by viewModels{
        RandomRegionViewModelFactory()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomRegionBinding.inflate(inflater, container, false)
        binding.btnRestart.setOnClickListener {
            viewModel.btnRestartOnClick()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.
        launchWhenStarted {
            viewModel.state.collect{
                when(it){
                    State.Loading -> {
                        binding.progressBar.isVisible=true
                        binding.btnRestart.isEnabled=false
                    }
                    State.Success -> {
                        binding.progressBar.isVisible=false
                        binding.btnRestart.isEnabled=true
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.randomRegion.collect{
                binding.userImg.load(it?.flags?.png)
                binding.tvName.setText("${it?.name}")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}



