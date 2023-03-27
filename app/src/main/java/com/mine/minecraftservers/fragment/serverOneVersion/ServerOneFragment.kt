package com.mine.minecraftservers.fragment.serverOneVersion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerOneBinding
import com.mine.minecraftservers.list.ServerOneAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class ServerOneFragment : BaseFragment<FragmentServerOneBinding>() {
    private val viewModel by viewModel<ServerOneViewModel>()
    private val serverOneAdapter = ServerOneAdapter()
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerOneBinding = FragmentServerOneBinding.inflate(inflater, container, false)


    override fun FragmentServerOneBinding.onBindView(saveInstanceState: Bundle?) {
        buttonBackToHome.setOnClickListener {
            navController.navigate(ServerOneFragmentDirections.actionServerOneFragmentToHomeFragment())
        }
        viewModel.getServers()
        recyclerViewServer.adapter = serverOneAdapter
        viewModel.serverOneLiveData.observe(viewLifecycleOwner) { servers ->
            serverOneAdapter.submitList(servers)
        }
    }
}
