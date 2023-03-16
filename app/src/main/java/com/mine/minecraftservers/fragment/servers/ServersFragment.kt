package com.mine.minecraftservers.fragment.servers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ServersFragment : BaseFragment<FragmentServerBinding>() {
    private val viewModel by viewModel<ServersViewModel>()
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerBinding = FragmentServerBinding.inflate(inflater, container, false)

    override fun FragmentServerBinding.onBindView(saveInstanceState: Bundle?) {
        buttonBackToHome.setOnClickListener {
            viewModel.getServers()
        }
        viewModel.serversLiveData.observe(viewLifecycleOwner) { servers ->
            println("              " + servers.toString())

        }
    }
}



