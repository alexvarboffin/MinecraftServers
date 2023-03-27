package com.mine.minecraftservers.fragment.serverTwoVersion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerTwoBinding
import com.mine.minecraftservers.fragment.serverTwoVersion.serverDescriptionTwo.ServerTwoViewModel
import com.mine.minecraftservers.list.ServerTwoAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class ServerTwoFragment : BaseFragment<FragmentServerTwoBinding>() {
    private val viewModel by viewModel<ServerTwoViewModel>()
    private val serverTwoAdapter = ServerTwoAdapter()
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerTwoBinding = FragmentServerTwoBinding.inflate(inflater, container, false)


    override fun FragmentServerTwoBinding.onBindView(saveInstanceState: Bundle?) {
        buttonBackToHomeTwo.setOnClickListener {
            navController.navigate(ServerTwoFragmentDirections.actionServerTwoFragmentToHomeFragment())
        }
        viewModel.getServers()
        recyclerViewServerTwo.adapter = serverTwoAdapter
        viewModel.serverTwoLiveData.observe(viewLifecycleOwner) { servers ->
            serverTwoAdapter.submitList(servers)
        }
    }
}


