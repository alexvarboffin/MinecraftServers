package com.mine.minecraftservers.fragment.serverOneVersion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mine.minecraftservers.R
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerOneBinding
import com.mine.domain.model.ServerDivider
import com.mine.domain.model.ServerItemType
import com.mine.minecraftservers.list.ServerOneAdapter


class ServerOneFragment : BaseFragment<FragmentServerOneBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerOneBinding = FragmentServerOneBinding.inflate(inflater, container, false)


    override fun FragmentServerOneBinding.onBindView(saveInstanceState: Bundle?) {
        buttonBackToHome.setOnClickListener {
            navController.navigate(ServerOneFragmentDirections.actionServerOneFragmentToHomeFragment())
        }
        val adapterOne = ServerOneAdapter()
        adapterOne.submitList(
            listOf(
                ServerItemType(
                    "BloodMine",
                    "IP BMPE.PW",
                    "PORT 19132",
                    image = R.drawable.bloodmine
                ) {
                    navController.navigate(ServerOneFragmentDirections.actionServerOneFragmentToServerDescriptionOneFragment())
                },
                ServerDivider,
                ServerItemType(
                    "BloodMine SkyWars",
                    "IP BMPE.PW",
                    "PORT 19130", image = R.drawable.skywars
                ) {
                    navController.navigate(ServerOneFragmentDirections.actionServerOneFragmentToServerDescriptionTwoFragment())
                },
                ServerDivider,
                ServerItemType(
                    "FitoCraft",
                    "IP fitocraft.ru",
                    "PORT 19138", image = R.drawable.fitocraft
                ) {
                    navController.navigate(ServerOneFragmentDirections.actionServerOneFragmentToServerDescriptionThreeFragment())
                },
                ServerDivider,
                ServerItemType(
                    "NeoMain",
                    "IP neomain.ru",
                    "PORT 19132", R.drawable.neomine
                ) {
                    navController.navigate(ServerOneFragmentDirections.actionServerOneFragmentToServerDescriptionFourFragment())
                }, ServerDivider
            )
        )

        with(binding) {
            recyclerViewServer.adapter = adapterOne
        }

    }
}


