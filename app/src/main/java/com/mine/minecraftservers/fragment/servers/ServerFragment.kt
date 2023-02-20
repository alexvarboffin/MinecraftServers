package com.mine.minecraftservers.fragment.servers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerBinding
import com.mine.minecraftservers.list.ServersAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class ServerFragment : BaseFragment<FragmentServerBinding>() {
    private val viewModel by viewModel<ServersViewModel>()
    private val serversAdapter = ServersAdapter()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerBinding = FragmentServerBinding.inflate(inflater, container, false)


    override fun FragmentServerBinding.onBindView(saveInstanceState: Bundle?) {
        viewModel.getServers(4)
        recyclerViewServers.adapter = serversAdapter

        viewModel.serversLiveData.observe(viewLifecycleOwner) { servers ->
            serversAdapter.submitList(servers)

        }
    }
}
