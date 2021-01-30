package com.hanamin.alaa.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.hanamin.alaa.BR
import com.hanamin.alaa.R
import com.hanamin.alaa.databinding.ListFragmentBinding
import com.hanamin.alaa.ui.base.BaseFragment
import com.hanamin.alaa.ui.viewmodel.HomeVm
import com.hanamin.alaa.utils.extensions.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListFragment : BaseFragment() {

    private val vm by viewModels<HomeVm>()
    private var binding by autoCleared<ListFragmentBinding>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        DataBindingUtil.inflate<ListFragmentBinding>(
            inflater,
            R.layout.list_fragment,
            container,
            false
        ).also {
            binding = it
        }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.vm, vm)

    }

}